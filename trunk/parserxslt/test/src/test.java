import xslt.parser.*;
import xslt.lexer.*;
import xslt.node.*;
import java.io.*;

public class test { 
	public static void main(String[] arguments) 
	{ 
		try {
// Create a Parser instance. 
		Parser p =new Parser(new Lexer(new PushbackReader(new InputStreamReader(new FileInputStream ("test")), 1024)));

// Parse the input. 
		Start tree = p.parse();
		tree.apply(new Translation());
		//System.out.println(tree.toString());
		}
// Apply the translation. 
		 catch(Exception e) { System.out.println(e.getMessage()); } } } 