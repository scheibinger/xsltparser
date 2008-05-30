//todo: sposob na przejscie do wybranej galezi przy ApplyTemplates
import java.util.ArrayList;
import xslt.analysis.*;
import xslt.node.*;

class Translation extends DepthFirstAdapter{ 
	private String currentMatch;
	private ArrayList<String> visitedTemplates=new ArrayList<String>();
	
	public void inAMatchTemplateElement(AMatchTemplateElement node){
		if(!visitedTemplates.contains(currentMatch))
			currentMatch=node.getText().toString();
		//else todo:pominiecie galezi drzewa jezeli juz bylo analizowane np. przez ApplyTemplates	
	}
	
	public void inAPassthruTemplateContent(APassthruTemplateContent node){
		System.out.print(node.getTextToPass()); 
	}

	public void inAValueOfTemplateContent(AValueOfTemplateContent node){
		System.out.print(currentMatch+node.getText()); 	//todo:formatowanie stringow do xPath,wstawienie elementu z xml
	}
	
	public void outAMatchTemplateElement(AMatchTemplateElement node){
		visitedTemplates.add(currentMatch);
		currentMatch="";
	}
}
/*
public void outAPlusExpr(APlusExpr node) {// out of alternative {plus} in Expr, we print the plus. System.out.print(node.getPlus()); }

public void outAMinusExpr(AMinusExpr node) {// out of alternative {minus} in Expr, we print the minus. System.out.print(node.getMinus()); }

public void outAMultFactor(AMultFactor node) {// out of alternative {mult} in Factor, we print the mult. System.out.print(node.getMult()); }

public void outADivFactor(ADivFactor node) {// out of alternative {div} in Factor, we print the div. System.out.print(node.getDiv()); }

public void outAModFactor(AModFactor node) {// out of alternative {mod} in Factor, we print the mod. System.out.print(node.getMod()); } }
*/ 