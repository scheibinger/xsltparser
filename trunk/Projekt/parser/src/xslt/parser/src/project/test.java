package project;
import xslt.parser.*;
import xslt.lexer.*;
import xslt.node.*;
import java.io.*;

public class test { 
	private static Translation translation;
	public static void main(String[] arguments) 
	{ 
		try {
// Create a Parser instance. 
		Parser p =new Parser(new Lexer(new PushbackReader(new InputStreamReader(new FileInputStream ("test.xslt")), 1024),null),null);

// Parse the input. 
		Start tree = p.parse();
		translation=new Translation();
		tree.apply(translation);
		translation.getOutput();
		//System.out.println(tree.toString());
		}
// Apply the translation. 
		 catch(Exception e) { System.out.println(e.getMessage()); } } } 