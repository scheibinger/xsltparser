/*
 * NewJFrame.java
 *
 * Created on 4 czerwiec 2008, 18:32
 */

package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import javax.swing.JFileChooser;
import java.util.ArrayList;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;

import xslt.lexer.Lexer;
import xslt.node.Start;
import xslt.parser.Parser;

/**
 *
 * @author  Administrator
 */
public class Main extends javax.swing.JFrame {
    String contentXslt,contentXML,XsltFilePath,XmlFilePath;
    private Translation translation;
    private File xmlFile;
    //FileInputStream file;
    BufferedReader buffer;
    Lexer lexer;
    final JFileChooser fc;
    final JFileChooser XMLfileChoser;
    boolean counting=false;
    int htmlLines=0;
    ArrayList<Integer> htmlLinesCollection = new ArrayList<Integer>();
    /** Creates new form NewJFrame */
    public Main() {

     fc= new JFileChooser();
     XMLfileChoser= new JFileChooser();

        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jScrollPaneXSLPreview = new javax.swing.JScrollPane();
      jTextAreaXSLPreview = new javax.swing.JTextArea();
      jScrollPaneHTMLCodePreview = new javax.swing.JScrollPane();
      jTextAreaHTMLCodePreview = new javax.swing.JTextArea();
      jTextFieldXSLfileName = new javax.swing.JTextField();
      jButtonChooseXSLFile = new javax.swing.JButton();
      jButtonGenerateHTML = new javax.swing.JButton();
      jLabelErrorReport = new javax.swing.JLabel();
      jScrollPaneHTMLPreview = new javax.swing.JScrollPane();
      jEditorPaneHTMLPreview = new javax.swing.JEditorPane();
      jLabelInfoHtmlPreview = new javax.swing.JLabel();
      jLabelInfoHTMLCodePreview = new javax.swing.JLabel();
      jLabelInfoErrorReport = new javax.swing.JLabel();
      jTextFieldXMLFileName = new javax.swing.JTextField();
      jButtonChooseXMLFile = new javax.swing.JButton();
      jScrollPaneXMLPreview = new javax.swing.JScrollPane();
      jEditorPaneXMLPreview = new javax.swing.JEditorPane();
      jLabelInfoHTMLCodePreview1 = new javax.swing.JLabel();
      jLabelInfoHTMLCodePreview2 = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Procesor XSLT");

      jTextAreaXSLPreview.setColumns(20);
      jTextAreaXSLPreview.setRows(5);
      jTextAreaXSLPreview.setEnabled(false);
      jScrollPaneXSLPreview.setViewportView(jTextAreaXSLPreview);

      jTextAreaHTMLCodePreview.setColumns(20);
      jTextAreaHTMLCodePreview.setRows(5);
      jScrollPaneHTMLCodePreview.setViewportView(jTextAreaHTMLCodePreview);

      jTextFieldXSLfileName.setFont(new java.awt.Font("Tahoma", 0, 10));
      jTextFieldXSLfileName.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextFieldXSLfileNameActionPerformed(evt);
         }
      });

      jButtonChooseXSLFile.setText("Wybierz plik XSL");
      jButtonChooseXSLFile.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButtonChooseXSLFileMouseClicked(evt);
         }
      });
      jButtonChooseXSLFile.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonChooseXSLFileActionPerformed(evt);
         }
      });

      jButtonGenerateHTML.setText("Generuj plik html");
      jButtonGenerateHTML.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonGenerateHTMLActionPerformed(evt);
         }
      });

      jEditorPaneHTMLPreview.setContentType("text/html");
      jScrollPaneHTMLPreview.setViewportView(jEditorPaneHTMLPreview);

      jLabelInfoHtmlPreview.setText("Podgląd wyjściowego pliku xHTML");

      jLabelInfoHTMLCodePreview.setText("Podgląd kodu html");

      jLabelInfoErrorReport.setText("Informacje o błędach:");

      jTextFieldXMLFileName.setFont(new java.awt.Font("Tahoma", 0, 10));

      jButtonChooseXMLFile.setText("Wybierz plik XML z danymi");
      jButtonChooseXMLFile.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonChooseXMLFileActionPerformed(evt);
         }
      });

      jScrollPaneXMLPreview.setViewportView(jEditorPaneXMLPreview);

      jLabelInfoHTMLCodePreview1.setText("podgląd XML'a wejściowego");

      jLabelInfoHTMLCodePreview2.setText("podgląd XML'a wejściowego");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabelInfoErrorReport)
               .addComponent(jLabelErrorReport, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jTextFieldXSLfileName, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(16, 16, 16)
                  .addComponent(jButtonChooseXSLFile, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
               .addComponent(jScrollPaneXSLPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabelInfoHTMLCodePreview2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabelInfoHTMLCodePreview)
                  .addGap(294, 294, 294))
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jScrollPaneHTMLCodePreview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldXMLFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonChooseXMLFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                     .addComponent(jScrollPaneXMLPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                     .addComponent(jLabelInfoHTMLCodePreview1))
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jLabelInfoHtmlPreview)
                           .addComponent(jScrollPaneHTMLPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButtonGenerateHTML)))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jTextFieldXSLfileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jButtonChooseXSLFile)
               .addComponent(jTextFieldXMLFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jButtonChooseXMLFile)
               .addComponent(jButtonGenerateHTML))
            .addGap(11, 11, 11)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabelInfoHtmlPreview)
               .addComponent(jLabelInfoHTMLCodePreview1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabelInfoHTMLCodePreview2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPaneHTMLPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(jScrollPaneXSLPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                  .addGap(11, 11, 11)
                  .addComponent(jLabelInfoErrorReport)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jLabelErrorReport, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(jScrollPaneXMLPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jLabelInfoHTMLCodePreview)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jScrollPaneHTMLCodePreview, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldXSLfileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldXSLfileNameActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldXSLfileNameActionPerformed

    private void jButtonChooseXSLFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseXSLFileActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jButtonChooseXSLFileActionPerformed

    private void jButtonChooseXSLFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonChooseXSLFileMouseClicked
        // TODO add your handling code here:
        int returnVal = fc.showOpenDialog(jLabelErrorReport);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            XsltFilePath=file.getAbsolutePath();
            jTextFieldXSLfileName.setText(XsltFilePath);
            String linia = "";
            int line=1;
            contentXslt="";
            try{
            FileReader file2 = new FileReader(file);
            BufferedReader bfr = new BufferedReader(file2);
            while((linia = bfr.readLine()) != null){
                if(!counting)
                {
                    if(linia.contains("<")&&!linia.contains("<xsl"))
                    {
                        counting=true;
                    }
                }
                else
                {
                    if(linia.contains("<xsl"))
                    {
                        counting=false;
                        htmlLinesCollection.add(htmlLines+2);
                        htmlLines=0;
                    }
                    else
                        htmlLines++;
                }
                contentXslt+=line+":    "+linia+'\n';
                line++;
            }
        } catch( IOException ex ){
            System.out.println("Błąd przy operacji na pliku: "+ex);
        }
         System.out.println(contentXslt);
        jTextAreaXSLPreview.setText(contentXslt);
        }
}//GEN-LAST:event_jButtonChooseXSLFileMouseClicked

    private void jButtonGenerateHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateHTMLActionPerformed
       try {
// Create a Parser instance.
           
           lexer=new Lexer(new PushbackReader(new InputStreamReader(new FileInputStream (XsltFilePath)), 1024),htmlLinesCollection);
                
           Parser p =new Parser(lexer,htmlLinesCollection);
       
// Parse the input. 
		Start tree = p.parse();
		translation=new Translation();
                translation.prepareXml(xmlFile);
		tree.apply(translation);
		jTextAreaHTMLCodePreview.setText(translation.getOutput());
                jLabelErrorReport.setText(translation.getErrors());
		//System.out.println(tree.toString());
                File html=new File(XsltFilePath+".html");
                FileWriter result=new FileWriter(html);
                jLabelErrorReport.setText(translation.getErrors());
                if(jLabelErrorReport.getText().contentEquals(translation.getErrors())){
                    result.write(jTextAreaHTMLCodePreview.getText());
                    jEditorPaneHTMLPreview.setText(jTextAreaHTMLCodePreview.getText());
                }
                result.close();
                
		}
// Apply the translation. 
		 catch(Exception e) { jLabelErrorReport.setText(e.getMessage());
                 }
}//GEN-LAST:event_jButtonGenerateHTMLActionPerformed

    private void jButtonChooseXMLFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseXMLFileActionPerformed
        // TODO add your handling code here:
        int returnVal = XMLfileChoser.showOpenDialog(jLabelErrorReport);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            xmlFile = XMLfileChoser.getSelectedFile();
            XmlFilePath=xmlFile.getAbsolutePath();
            jTextFieldXMLFileName.setText(XmlFilePath);
            String linia = "";
            int line=1;
            contentXML="";
            try{
            FileReader file2 = new FileReader(xmlFile);
            BufferedReader bfr = new BufferedReader(file2);
            while((linia = bfr.readLine()) != null){
                contentXML+=line+":    "+linia+'\n';
                line++;
            }
        } catch( IOException ex ){
            System.out.println("Błąd przy operacji na pliku: "+ex);
        }
         System.out.println(contentXML);
        jEditorPaneXMLPreview.setText(contentXML);
        }
    }//GEN-LAST:event_jButtonChooseXMLFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButtonChooseXMLFile;
   private javax.swing.JButton jButtonChooseXSLFile;
   private javax.swing.JButton jButtonGenerateHTML;
   private javax.swing.JEditorPane jEditorPaneHTMLPreview;
   private javax.swing.JEditorPane jEditorPaneXMLPreview;
   private javax.swing.JLabel jLabelErrorReport;
   private javax.swing.JLabel jLabelInfoErrorReport;
   private javax.swing.JLabel jLabelInfoHTMLCodePreview;
   private javax.swing.JLabel jLabelInfoHTMLCodePreview1;
   private javax.swing.JLabel jLabelInfoHTMLCodePreview2;
   private javax.swing.JLabel jLabelInfoHtmlPreview;
   private javax.swing.JScrollPane jScrollPaneHTMLCodePreview;
   private javax.swing.JScrollPane jScrollPaneHTMLPreview;
   private javax.swing.JScrollPane jScrollPaneXMLPreview;
   private javax.swing.JScrollPane jScrollPaneXSLPreview;
   private javax.swing.JTextArea jTextAreaHTMLCodePreview;
   private javax.swing.JTextArea jTextAreaXSLPreview;
   private javax.swing.JTextField jTextFieldXMLFileName;
   private javax.swing.JTextField jTextFieldXSLfileName;
   // End of variables declaration//GEN-END:variables
    
}
