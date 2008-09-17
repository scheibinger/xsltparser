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
import java.util.ArrayList;
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
    private ArrayList<Object> chooseIndexes = new ArrayList<Object>();
    private ArrayList<Boolean> forEachIf = new ArrayList<Boolean>();
    private HashMap variables=new HashMap();
    private ArrayList<String> currentVariables=new ArrayList<String>();
    private String errors="";
    private ArrayList<Integer> sortIndexes = new ArrayList<Integer>();
    private ArrayList<Boolean> ifResults = new ArrayList<Boolean>();
    private Boolean sort=false;
    private String sortSelect="";
    private String attributes;
    private Boolean attribute=false;
    private Boolean choose = true;
    private Boolean alreadyChoosed = false;
    private Boolean sortAsc = true;
    private Boolean sortText = true;
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
                if(chooseIndexes.size()>0)
                {
                    Boolean[] indexes = ((Boolean[])(chooseIndexes.get(0)));
                    int buff=0;
                    for(int i=0;i<forEachElements;i++)
                    {
                        if(indexes[i]==true)
                        {
                        buff--;
                        if(forEachContent.size()<i+1+buff)
                            forEachContent.add(text);
                        else
                        {
                            tmp=forEachContent.get(i+buff);
                            tmp+=text;
                            forEachContent.remove(i+buff);
                            forEachContent.add(i+buff, tmp);    
                        }
                        }
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
                if(chooseIndexes.size()>0)
                {
                    Boolean[] indexes = ((Boolean[])(chooseIndexes.get(0)));
                    int buff=0;
                    for(int i=0;i<forEachElements;i++)
                    {
                        String path=forEachPath +"["+(i+1)+"]"+"/"+ node.getText().toString().trim().replaceAll("\"","");
                        path=path.replaceAll("//","/");
                        if(indexes[i]==true)
                        {
                        buff--;
                        if(forEachContent.size()<i+1)
                            forEachContent.add(readPath(path,XPathConstants.STRING).toString());
                        else
                        {
                            tmp=forEachContent.get(i+buff);
                            tmp+=(readPath(path,XPathConstants.STRING).toString());
                            forEachContent.remove(i+buff);
                            forEachContent.add(i+buff, tmp);    
                        }
                        }
                    }
                }
                for(int i=0;i<forEachElements;i++)
                {
                    String path=forEachPath +"["+(i+1)+"]"+"/"+ node.getText().toString().trim().replaceAll("\"","");
                    path=path.replaceAll("//","/");
                    if(forEachContent.size()<i+1)
                        forEachContent.add(readPath(path,XPathConstants.STRING).toString());
                    else
                    {
                        tmp=forEachContent.get(i);
                        tmp+=(readPath(path,XPathConstants.STRING).toString());
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
    public void caseAOrderAscSortOptions(AOrderAscSortOptions node)
    {
        sortAsc=true;
    }
        public void caseAOrderDescSortOptions(AOrderDescSortOptions node)
    {
        sortAsc=false;
    }
        
        public void caseADataTypeTextSortOptions(ADataTypeTextSortOptions node)
    {
        sortText=true;
    }
        public void caseADataTypeNumberSortOptions(ADataTypeNumberSortOptions node)
    {
        sortAsc=false;
    }
    public void outASorting(ASorting node){
        ArrayList<Object> values = new ArrayList<Object>();
        String path = forEachPath.trim().replaceAll("\"","");
        int size=((NodeList)readPath(path,XPathConstants.NODESET)).getLength();
        String tmp;
        for(int i=0;i<size;i++)
        {
            tmp=readPath(path+"["+(i+1)+"]"+"/"+sortSelect.trim().replaceAll("\"",""),XPathConstants.STRING).toString();
            values.add(tmp);
        }
        Collections.sort(values,new Comparator() {

            public int compare(Object o1, Object o2) {
                int tmp1=0;
                int tmp2=0;
                String tmp3="";
                String tmp4="";
                if(sortText)
                {
                    tmp3=o1.toString();
                    tmp4=o2.toString();
                }
                else
                {
                    tmp1=Integer.parseInt(o1.toString());
                    tmp2=Integer.parseInt(o2.toString());
                }
                if(!sortText)
                {
                    if(sortAsc)
                    {
                        if(tmp1>tmp2)
                        {
                            return 1;
                        }
                        else if(tmp1<tmp2)
                            return -1;
                        else return 0;
                    }
                    else
                    {
                        if(tmp1>tmp2)
                        {
                            return -1;
                        }
                        else if(tmp1<tmp2)
                            return 1;
                        else return 0;
                    }
                }
                else
                {
                   if(sortAsc)
                    {
                       return tmp3.compareTo(tmp4);
                    }
                   else
                       return tmp4.compareTo(tmp3);
                }
            }
        });
        for(int i=0;i<size;i++)
        {
            if(sortText)
                sortIndexes.add(i, values.indexOf((readPath(path+"["+(i+1)+"]"+"/"+sortSelect.trim().replaceAll("\"",""),XPathConstants.STRING).toString())));
            else
                sortIndexes.add(i, values.indexOf(Integer.parseInt(readPath(path+"["+(i+1)+"]"+"/"+sortSelect.trim().replaceAll("\"",""),XPathConstants.STRING).toString())));
            
        }
        //na podstawie pobranych w foreach elementow z xmla oraz ustawionych zmiennych na podstawie opcji sorta nastepuje sortowanie po pierwszym dziecku
        sort=true;
        sortAsc=true;
        sortText=true;
    }
    public void inAIfTemplateContent(AIfTemplateContent node) {
        String test = node.getText().toString();
        //test=test.replaceAll("gt","&gt;");
        String path = forEachPath.trim().replaceAll("\"","");
        int size=((NodeList)readPath(path,XPathConstants.NODESET)).getLength();
       String tmp;
        for(int i=0;i<size;i++)
        {
            
            tmp=(readPath(path+"["+(i+1)+"]["+test.trim().replaceAll("\"","")+']',XPathConstants.STRING).toString());
            if(tmp.contentEquals(""))
                ifResults.add(false);
            else
                ifResults.add(true);
        }
    }

    public void outAIfTemplateContent(AIfTemplateContent node) {
        ifResult = true;
    }

    public void inAForEachTemplateContent(AForEachTemplateContent node){
        forEachPath=currentMatch.trim().replaceAll("\"","")+"/"+node.getText().toString().trim().replaceAll("\"","");
        forEach=true;
         forEachElements=((NodeList)readPath(forEachPath,XPathConstants.NODESET)).getLength();
         
        //todo:dodanie w jakiejs strukturze wszystkich danych z xmla i zapisujemy jezeli jest sort do sortIndex odpowiednia kolejnosc
        //np. jezeli pierwszy element ma byc piaty to dodajemy: sortIndex.add(0,4);
    }
    public void outAForEachTemplateContent(AForEachTemplateContent node){
        forEach=false;
        if(sort)
        {
            String tmp;
            boolean tmp2;
            String[]sortedList = new String[sortIndexes.size()];
            boolean[] sortedList2 = new boolean[ifResults.size()];               
            for(int i=0;i<sortIndexes.size();i++)
            {
                tmp=forEachContent.get(i);
                sortedList[sortIndexes.get(i)]=tmp;
                if(ifResults.size()>0)
                {
                    tmp2=ifResults.get(i);
                    sortedList2[sortIndexes.get(i)]=tmp2;
                }
                
            }
            forEachContent.removeAll(forEachContent);
            for(int i = 0;i<sortedList.length;i++)
                forEachContent.add(sortedList[i]);
            if(ifResults.size()>0)
               for(int i =0;i<sortedList.length;i++)
               {
                   if(sortedList2[i]==false)
                       forEachContent.remove(i);
               }
        }
        else if(ifResults.size()>0)
        {
           for(int i =0;i<forEachContent.size();i++)
               {
                   if(ifResults.get(i)==false)
                       forEachContent.remove(i);
               } 
        }
        if(applyingTemplateIndex==0)
        templates.addAll(forEachContent);//todo:dodac sprawdzanie co z ifa moze byc wstawione
        else
            templates.addAll(applyingTemplateIndex,forEachContent);
        forEachContent.removeAll(forEachContent);
        sort=false;
        sortIndexes.removeAll(sortIndexes);
        ifResults.removeAll(ifResults);
    }
    
    public void inAChooseTemplateContent(AChooseTemplateContent node){
        choose=false;
    }
    public void inATestElement(ATestElement node){
        if(!alreadyChoosed)
        {
        String test = node.getText().toString();
        
        String path = forEachPath.trim().replaceAll("\"","");
        int size=((NodeList)readPath(path,XPathConstants.NODESET)).getLength();
        Boolean[] indexes = new Boolean[size];
        String tmp;
        for(int i=0;i<size;i++)
        {
            
            tmp=(readPath(path+"["+(i+1)+"]["+test.trim().replaceAll("\"","")+']',XPathConstants.STRING).toString());
            if(tmp.contentEquals(""))
                indexes[i]=false;
            else
                indexes[i]=true;
        }
        chooseIndexes.add(indexes);
        }
    }
    public void outATestElement(ATestElement node){
        chooseIndexes.remove(0);
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