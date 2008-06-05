//todo: sposob na przejscie do wybranej galezi przy ApplyTemplates
//wyczaic jak dobrac sie do zlozonych produkcji
package project;
import java.util.ArrayList;
import java.util.LinkedList;

import xslt.analysis.*;
import xslt.node.*;

class Translation extends DepthFirstAdapter{ 
	private String currentMatch="";
	private ArrayList<Object> templates=new ArrayList<Object>();
	private int applyingTemplateIndex=0;
	private String applyingTemplatePath="";
	private String text="";
	private LinkedList textTmp;
	
	private String applyTemplatesSelect="";
	
	public void inAMatchTemplateElement(AMatchTemplateElement node){
			currentMatch+=node.getText().toString();
			int size=templates.size();
			applyingTemplateIndex=0;
			search:
			for(int i=0;i<size;i++)
			{
				Object element=templates.get(i);
				if(element instanceof Template)
				{
					int pathSize=((Template)element).getXPath().size();
					for(int j=1;j<pathSize;j++)
					{
						if(((Template)element).getXPath().get(j)==currentMatch)
							{
								applyingTemplateIndex=i;
								applyingTemplatePath=((Template)element).getXPath().get(0);
								break   search;
							}
					}
				}
			}
	}
	
	public void inAPassthruTemplateContent(APassthruTemplateContent node){
		if(currentMatch!="")
		{
			String tmp;
			text="<";
			textTmp=node.getTextToPass();
			int size=textTmp.size();
			for(int i=0;i<size;i++)
			{
				tmp=textTmp.pop().toString();
				if(tmp.charAt(0)!=' '&&(text.charAt(text.length()-1))==' ')
					text=text.substring(0,text.length()-1);
				text+=tmp;
			}
			if(applyingTemplateIndex==0)	
				//templates.add(node.getTextToPass().toString());
				templates.add(text);
			else
			{
				//templates.add(applyingTemplateIndex,node.getTextToPass().toString());
				templates.add(applyingTemplateIndex,text);
			}
		}
	}

	public void inAValueOfTemplateContent(AValueOfTemplateContent node){
		if(currentMatch!="")
		{
			if(applyingTemplateIndex==0)
				templates.add(currentMatch+node.getText().toString());
			else
			{
				templates.add(applyingTemplateIndex,applyingTemplatePath+currentMatch+node.getText().toString());
			}
	//todo:formatowanie stringow do xPath,wstawienie elementu z xml
		}
	}
	
	public void outAApplyTemplates2TemplateContent(AApplyTemplates2TemplateContent node){
		ArrayList<String> paths=new ArrayList<String>();
		paths.add(currentMatch);
		if(applyTemplatesSelect!="")
		{
			paths.add(applyTemplatesSelect);
			templates.add(new Template(paths));
		}
		//todo:dodawanie dzieci z xml wystepujace pod currentMatch
		applyTemplatesSelect="";
	}
	public void caseASelectApplyTemplatesOptions(ASelectApplyTemplatesOptions node){
		applyTemplatesSelect=node.getText().toString();
	}
	
	public void outAMatchTemplateElement(AMatchTemplateElement node){
		currentMatch="";
	}
	public String getOutput(){
		int size=templates.size();
                String tmp="";
		for(int i=0;i<size;i++)
		{
			if(templates.get(i) instanceof String)
				tmp+=(templates.get(i).toString());
		}
                return tmp;
	}
}
/*
public void outAPlusExpr(APlusExpr node) {// out of alternative {plus} in Expr, we print the plus. System.out.print(node.getPlus()); }

public void outAMinusExpr(AMinusExpr node) {// out of alternative {minus} in Expr, we print the minus. System.out.print(node.getMinus()); }

public void outAMultFactor(AMultFactor node) {// out of alternative {mult} in Factor, we print the mult. System.out.print(node.getMult()); }

public void outADivFactor(ADivFactor node) {// out of alternative {div} in Factor, we print the div. System.out.print(node.getDiv()); }

public void outAModFactor(AModFactor node) {// out of alternative {mod} in Factor, we print the mod. System.out.print(node.getMod()); } }
*/ 