//todo: sposob na przejscie do wybranej galezi przy ApplyTemplates
//wyczaic jak dobrac sie do zlozonych produkcji
//do przekonwertowania gramatyka
package project;

import java.util.*;

import java.io.File;
import java.util.regex.*;
import xslt.analysis.*;
import xslt.node.*;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;




class Translation extends DepthFirstAdapter {

    private String currentMatch = "";
    private ArrayList<Object> templates = new ArrayList<Object>();
    private int applyingTemplateIndex = 0;
    private String applyingTemplatePath = "";
    private String text = "";
    private LinkedList textTmp;
    private String applyTemplatesSelect = "";
    private boolean ifResult = true;
    private boolean forEach = false;
    private String forEachPath;
    private int forEachElements=0;
    private ArrayList<String> forEachContent= new ArrayList<String>();
    private ArrayList<Boolean> forEachIf = new ArrayList<Boolean>();
    private HashMap variables=new HashMap();
    private ArrayList<String> currentVariables=new ArrayList<String>();
    private String errors="";
    private ArrayList<Integer> sortIndexes = new ArrayList<Integer>();
    private Boolean sort=false;
    private String sortSelect="";
    private String attributes;
    private Boolean attribute=false;
    private Boolean choose = true;
    private Boolean alreadyChoosed = false;
    
    private Document xmlDocument;
    private XPath xPath;

    public void caseAVariableInnerElement(AVariableInnerElement node){
        variables.put(node.getParamName().toString(),node.getParamSelect().toString());
    }
    public void inAMatchTemplateElement(AMatchTemplateElement node) {
        currentMatch += node.getText().toString();
        int size = templates.size();
        applyingTemplateIndex = 0;
        search:
        for (int i = 0; i < size; i++) {
            Object element = templates.get(i);
            if (element instanceof Template) {
                int pathSize = ((Template) element).getXPath().size();
                for (int j = 1; j < pathSize; j++) {
                    if (((Template) element).getXPath().get(j).contentEquals(currentMatch.trim().replaceAll("\"",""))) {
                        applyingTemplateIndex = i;
                        //applyingTemplatePath = ((Template) element).getXPath().get(0);
                        currentMatch = ((Template) element).getXPath().get(0).trim().replaceAll("\"","")+ "/"+currentMatch.trim().replaceAll("\"","");
                        break search;
                    }
                }
            }
        }
    }
    public void inAAttributeElement(AAttributeElement node){
        attribute=true;
        attributes=node.getText().toString().replace('"',' ').trim()+"=\"";
    }
    public void outAAttributeElement(AAttributeElement node){
        attribute=false;
        if(applyingTemplateIndex==0){
            String tmp=(String) templates.get(templates.size()-1);
            tmp=tmp.replace('>',' ')+attributes+">";
            templates.remove(templates.size()-1);
            templates.add(tmp);
        }
        else
        {
            String tmp=(String)templates.get(applyingTemplateIndex-1);
            tmp=tmp.replace('>',' ')+attributes+">";
            templates.remove(applyingTemplateIndex-1);
            templates.add(applyingTemplateIndex-1,tmp);
        }
    }
    public void caseAVariableTemplateContent(AVariableTemplateContent node){
        variables.put(node.getParamName().toString(),node.getParamSelect().toString());
        currentVariables.add(node.getParamName().toString());
    }
    public void caseACopyOfTemplateContent(ACopyOfTemplateContent node){
        if(variables.get(node.getText().toString())==null)
        {
            errors+=" Brak zdefiniowanej zmiennej: "+node.getText();
        }
        else
        {
            String value=variables.get(node.getText().toString()).toString();
            value=value.subSequence(1, value.length()-2).toString();
        if(forEach)
            {
             String tmp;
                if(sort)
                {
                    if(sortIndexes.size()>forEachContent.size())
                        for(int i=forEachContent.size()-1;i<sortIndexes.size();i++)
                        {
                                forEachContent.add("");
                        }
                    for(int i=0;i<sortIndexes.size();i++)
                {
                        tmp=forEachContent.get(sortIndexes.get(i));
                        tmp+=value;
                        forEachContent.remove(sortIndexes.get(i));
                        forEachContent.add(sortIndexes.get(i), tmp);

                }
                }
                else
                for(int i=0;i<forEachElements;i++)
                {
                    if(forEachContent.size()<i+1)
                        forEachContent.add(value);
                    else
                    {
                        tmp=forEachContent.get(i);
                        tmp+=value;
                        forEachContent.remove(i);
                        forEachContent.add(i, tmp);
                    }
                }
            }
            else{
            if (applyingTemplateIndex == 0) //templates.add(node.getTextToPass().toString());
            {
                templates.add(value);
            } else {
                //templates.add(applyingTemplateIndex,node.getTextToPass().toString());
                templates.add(applyingTemplateIndex, value);
                applyingTemplateIndex++;
            }
            }
        }
    }
    public void inAPassthruTemplateContent(APassthruTemplateContent node) {
        if (currentMatch != "" && ((choose&&ifResult)||forEach)) {
            String tmp;
            text = "<";
            textTmp = node.getTextToPass();
            int size = textTmp.size();
            for (int i = 0; i < size; i++) {
                tmp = textTmp.pop().toString();
                if (tmp.charAt(0) != ' ' && (text.charAt(text.length() - 1)) == ' ') {
                    text = text.substring(0, text.length() - 1);
                }
                text += tmp;
            }
           if(forEach)
            {
                if(sort)
                {
                    if(sortIndexes.size()>forEachContent.size())
                        for(int i=forEachContent.size()-1;i<sortIndexes.size();i++)
                        {
                                forEachContent.add("");
                        }
                    for(int i=0;i<sortIndexes.size();i++)
                {
                        tmp=forEachContent.get(sortIndexes.get(i));
                        tmp+=text;
                        forEachContent.remove(sortIndexes.get(i));
                        forEachContent.add(sortIndexes.get(i), tmp);

                }
                }
                else
                for(int i=0;i<forEachElements;i++)
                {
                    if(forEachContent.size()<i+1)
                        forEachContent.add(text);
                    else
                    {
                        tmp=forEachContent.get(i);
                        tmp+=text;
                        forEachContent.remove(i);
                        forEachContent.add(i, tmp);
                    }
                }
            }
            else{
            if (applyingTemplateIndex == 0) //templates.add(node.getTextToPass().toString());
            {
                templates.add(text);
            } else {
                //templates.add(applyingTemplateIndex,node.getTextToPass().toString());
                templates.add(applyingTemplateIndex, text);
                applyingTemplateIndex++;
            }
            }
        }
    }

    public void inAValueOfTemplateContent(AValueOfTemplateContent node) {
        if (currentMatch != "" && ((choose&&ifResult)||forEach)) {
                   if(forEach)
            {
             String tmp;
                if(sort)
                {
                    if(sortIndexes.size()>forEachContent.size())
                        for(int i=forEachContent.size()-1;i<sortIndexes.size();i++)
                        {
                                forEachContent.add("");
                        }
                    for(int i=0;i<sortIndexes.size();i++)
                {
                        tmp=forEachContent.get(sortIndexes.get(i));
                        tmp+=forEachPath + node.getText().toString();
                        forEachContent.remove(sortIndexes.get(i));
                        forEachContent.add(sortIndexes.get(i), tmp);

                }
                }
                else
                for(int i=0;i<forEachElements;i++)
                {
                    if(forEachContent.size()<i+1)
                        forEachContent.add(forEachPath + node.getText().toString());
                    else
                    {
                        tmp=forEachContent.get(i);
                        tmp+=forEachPath + node.getText().toString();
                        forEachContent.remove(i);
                        forEachContent.add(i, tmp);
                    }
                }
            }
            else{
            if(attribute){
                attributes+=currentMatch + node.getText().toString()+"\"";
            }
            else{
                String path = currentMatch.trim().replaceAll("\"","")+"/"+node.getText().toString().trim().replaceAll("\"","");
            if (applyingTemplateIndex == 0) { 
                
                templates.add(readPath(path.replaceAll("//","/"),XPathConstants.STRING));
            } else {
                    //path =applyingTemplatePath.trim().replaceAll("\"","")+"/" + path;
                templates.add(applyingTemplateIndex,readPath(path.replaceAll("//","/"),XPathConstants.STRING));
                applyingTemplateIndex++;
            }
            }
        //todo:formatowanie stringow do xPath,wstawienie elementu z xml
            }
        }
    }

    public void outAApplyTemplates2TemplateContent(AApplyTemplates2TemplateContent node) {
        if (ifResult) {
            ArrayList<String> paths = new ArrayList<String>();
            paths.add(currentMatch);
            if (!applyTemplatesSelect.contentEquals("")) 
            {
                paths.add(applyTemplatesSelect.trim().replaceAll("\"",""));
                if(applyingTemplateIndex==0)
                    templates.add(new Template(paths));
                 else
                {
                    templates.add(applyingTemplateIndex,new Template(paths));
                    applyingTemplateIndex++;
                }
            }
            else
            {
            NodeList list = (NodeList)readPath((currentMatch.trim().replaceAll("\"","")+"/*"),XPathConstants.NODESET);
            
            for(int i = 0;i < list.getLength();i++)
                paths.add(list.item(i).getNodeName());
            if(applyingTemplateIndex==0)
                templates.add(new Template(paths));
            else
            {
                templates.add(applyingTemplateIndex,new Template(paths));
                applyingTemplateIndex++;
            }
            }
            applyTemplatesSelect = "";
        }
    }

    public void caseASelectApplyTemplatesOptions(ASelectApplyTemplatesOptions node) {
        applyTemplatesSelect = node.getText().toString();
    }
    public void caseASelectSortOptions(ASelectSortOptions node){
        sortSelect=node.getText().toString();
    }
    public void outASorting(ASorting node){
        //na podstawie pobranych w foreach elementow z xmla oraz ustawionych zmiennych na podstawie opcji sorta nastepuje sortowanie po pierwszym dziecku
        sort=true;

    }
    public void inAIfTemplateContent(AIfTemplateContent node) {
        String test = node.getText().toString();
        String[] tab = test.split(" ");
        int value = Integer.parseInt(tab[2]);
        currentMatch += tab[0];
        //todo:dodanie sprawdzanie warunkow po wyciagnieciu danych z xmla
        //sprawdzanie jak jest foreach dla kazdego dziecka
        if (tab[1].contentEquals("&gt;")) {

        } else if (tab[1].contentEquals("&lt;")) {

        }

    }

    public void outAIfTemplateContent(AIfTemplateContent node) {
        ifResult = true;
    }

    public void inAForEachTemplateContent(AForEachTemplateContent node){
        forEachPath=currentMatch+node.getText();
        forEach=true;
         forEachElements=5;
        //todo:dodanie w jakiejs strukturze wszystkich danych z xmla i zapisujemy jezeli jest sort do sortIndex odpowiednia kolejnosc
        //np. jezeli pierwszy element ma byc piaty to dodajemy: sortIndex.add(0,4);
    }
    public void outAForEachTemplateContent(AForEachTemplateContent node){
        forEach=false;
        if(applyingTemplateIndex==0)
        templates.addAll(forEachContent);//todo:dodac sprawdzanie co z ifa moze byc wstawione
        else
            templates.addAll(applyingTemplateIndex,forEachContent);
        forEachContent.removeAll(forEachContent);
        sort=false;
        sortIndexes.removeAll(sortIndexes);
    }
    
    public void inAChooseTemplateContent(AChooseTemplateContent node){
        choose=false;
    }
    public void inATestElement(ATestElement node){
        if(!alreadyChoosed)
        {
        String test = node.getText().toString();
        String[] tab = test.split(" ");
        int value = Integer.parseInt(tab[2]);
        currentMatch += tab[0];
        //todo:dodanie sprawdzanie warunkow po wyciagnieciu danych z xmla
        if (tab[1].contentEquals("&gt;")) {

        } else if (tab[1].contentEquals("&lt;")) {

        }
        //jezeli spelniony to ustawiamy choose na true oraz alreadyChoosed na true
        }
    }
    public void outATestElement(ATestElement node){
        choose=false;
    }
    public void outAChooseTemplateContent(AChooseTemplateContent node){
        choose=true;
    }
    public void outAMatchTemplateElement(AMatchTemplateElement node) {
        currentMatch = "";
        for(int i=0;i<currentVariables.size();i++)
        {
            variables.remove(currentVariables.get(i));
        }
        currentVariables.removeAll(currentVariables);
    }

    public String getOutput() {
        int size = templates.size();
        String tmp = "";
        for (int i = 0; i < size; i++) {
            if (templates.get(i) instanceof String) {
                tmp += (templates.get(i).toString());
            }
        }
        return tmp;
    }
    public String getErrors(){
        return errors;
    }
    public void prepareXml(File xml)
    {
        try {
            xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);            
            xPath =  XPathFactory.newInstance().newXPath();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }  
    }
    
    public Object readPath(String expression, 
			QName returnType)
    {
        try {
            XPathExpression xPathExpression = 
			xPath.compile(expression);
            return xPathExpression.evaluate
			(xmlDocument, returnType);
        } catch (XPathExpressionException ex) {
            ex.printStackTrace();
            return null;
        }
    }


}