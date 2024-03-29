/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.analysis;

import xslt.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAFile(AFile node);
    void caseAFooter(AFooter node);
    void caseAHeader(AHeader node);
    void caseASetOutput(ASetOutput node);
    void caseASingleOutputOptions(ASingleOutputOptions node);
    void caseAMultipleOutputOptions(AMultipleOutputOptions node);
    void caseAMethodXmlOutputOption(AMethodXmlOutputOption node);
    void caseAMethodHtmlOutputOption(AMethodHtmlOutputOption node);
    void caseAMethodTextOutputOption(AMethodTextOutputOption node);
    void caseAVersionOutputOption(AVersionOutputOption node);
    void caseAEncodingOutputOption(AEncodingOutputOption node);
    void caseAOmitXmlDeclarationYesOutputOption(AOmitXmlDeclarationYesOutputOption node);
    void caseAOmitXmlDeclarationNoOutputOption(AOmitXmlDeclarationNoOutputOption node);
    void caseAStandaloneYesOutputOption(AStandaloneYesOutputOption node);
    void caseAStandaloneNoOutputOption(AStandaloneNoOutputOption node);
    void caseADoctypePublicOutputOption(ADoctypePublicOutputOption node);
    void caseADoctypeSystemOutputOption(ADoctypeSystemOutputOption node);
    void caseACdataSectionElementsOutputOption(ACdataSectionElementsOutputOption node);
    void caseAIndentYesOutputOption(AIndentYesOutputOption node);
    void caseAIndentNoOutputOption(AIndentNoOutputOption node);
    void caseAMediaTypeOutputOption(AMediaTypeOutputOption node);
    void caseADocument(ADocument node);
    void caseASingleImports(ASingleImports node);
    void caseAMultipleImports(AMultipleImports node);
    void caseAImportImportElement(AImportImportElement node);
    void caseAIncludeImportElement(AIncludeImportElement node);
    void caseASingleInnerElements(ASingleInnerElements node);
    void caseAMultipleInnerElements(AMultipleInnerElements node);
    void caseAParamInnerElement(AParamInnerElement node);
    void caseAVariableInnerElement(AVariableInnerElement node);
    void caseAAttributeInnerElement(AAttributeInnerElement node);
    void caseATemplateInnerElement(ATemplateInnerElement node);
    void caseASingleAttributes(ASingleAttributes node);
    void caseAMultipleAttributes(AMultipleAttributes node);
    void caseAAttributeElement(AAttributeElement node);
    void caseAMatchTemplateElement(AMatchTemplateElement node);
    void caseANameTemplateElement(ANameTemplateElement node);
    void caseAModeTemplateOptions(AModeTemplateOptions node);
    void caseAPriorityTemplateOptions(APriorityTemplateOptions node);
    void caseAApplyImportsTemplateContent(AApplyImportsTemplateContent node);
    void caseAApplyTemplatesTemplateContent(AApplyTemplatesTemplateContent node);
    void caseAApplyTemplates2TemplateContent(AApplyTemplates2TemplateContent node);
    void caseAAttributeTemplateContent(AAttributeTemplateContent node);
    void caseACallTemplateTemplateContent(ACallTemplateTemplateContent node);
    void caseAChooseTemplateContent(AChooseTemplateContent node);
    void caseACommentTemplateContent(ACommentTemplateContent node);
    void caseACopyTemplateContent(ACopyTemplateContent node);
    void caseACopyOfTemplateContent(ACopyOfTemplateContent node);
    void caseAElementTemplateContent(AElementTemplateContent node);
    void caseAFallbackTemplateContent(AFallbackTemplateContent node);
    void caseAForEachTemplateContent(AForEachTemplateContent node);
    void caseAIfTemplateContent(AIfTemplateContent node);
    void caseAValueOfTemplateContent(AValueOfTemplateContent node);
    void caseAParamTemplateContent(AParamTemplateContent node);
    void caseAVariableTemplateContent(AVariableTemplateContent node);
    void caseAPassthruTemplateContent(APassthruTemplateContent node);
    void caseASelectApplyTemplatesOptions(ASelectApplyTemplatesOptions node);
    void caseAModeApplyTemplatesOptions(AModeApplyTemplatesOptions node);
    void caseAParameterApplyTemplatesParameters(AParameterApplyTemplatesParameters node);
    void caseASortingApplyTemplatesParameters(ASortingApplyTemplatesParameters node);
    void caseASorting(ASorting node);
    void caseASelectSortOptions(ASelectSortOptions node);
    void caseAOrderAscSortOptions(AOrderAscSortOptions node);
    void caseAOrderDescSortOptions(AOrderDescSortOptions node);
    void caseACaseOrderUpperSortOptions(ACaseOrderUpperSortOptions node);
    void caseACaseOrderLoweaSortOptions(ACaseOrderLoweaSortOptions node);
    void caseALangSortOptions(ALangSortOptions node);
    void caseADataTypeTextSortOptions(ADataTypeTextSortOptions node);
    void caseADataTypeNumberSortOptions(ADataTypeNumberSortOptions node);
    void caseAParameter(AParameter node);
    void caseASingleTests(ASingleTests node);
    void caseAMultipleTests(AMultipleTests node);
    void caseATestElement(ATestElement node);
    void caseAText(AText node);

    void caseTTextToPass(TTextToPass node);
    void caseTSign(TSign node);
    void caseTDot(TDot node);
    void caseTComma(TComma node);
    void caseTColon(TColon node);
    void caseTSemicolon(TSemicolon node);
    void caseTLPar(TLPar node);
    void caseTRPar(TRPar node);
    void caseTLBracket(TLBracket node);
    void caseTRBracket(TRBracket node);
    void caseTLBrace(TLBrace node);
    void caseTRBrace(TRBrace node);
    void caseTStar(TStar node);
    void caseTDiv(TDiv node);
    void caseTMod(TMod node);
    void caseTAmpersand(TAmpersand node);
    void caseTPlus(TPlus node);
    void caseTMinus(TMinus node);
    void caseTCaret(TCaret node);
    void caseTTilde(TTilde node);
    void caseTBar(TBar node);
    void caseTEqual(TEqual node);
    void caseTEq(TEq node);
    void caseTNeq(TNeq node);
    void caseTOpenTag(TOpenTag node);
    void caseTCloseTag(TCloseTag node);
    void caseTCloseTagRange(TCloseTagRange node);
    void caseTBlank(TBlank node);
    void caseTXml(TXml node);
    void caseTHtml(THtml node);
    void caseTTextFormat(TTextFormat node);
    void caseTHref(THref node);
    void caseTYes(TYes node);
    void caseTNo(TNo node);
    void caseTStyle(TStyle node);
    void caseTXsltTag(TXsltTag node);
    void caseTCloseXsltTag(TCloseXsltTag node);
    void caseTVersion(TVersion node);
    void caseTVersionOption(TVersionOption node);
    void caseTXmlns(TXmlns node);
    void caseTXslUrl(TXslUrl node);
    void caseTXmlnsUrl(TXmlnsUrl node);
    void caseTOutput(TOutput node);
    void caseTMethod(TMethod node);
    void caseTEncoding(TEncoding node);
    void caseTOmitXmlDeclaration(TOmitXmlDeclaration node);
    void caseTStandalone(TStandalone node);
    void caseTDoctypePublic(TDoctypePublic node);
    void caseTDoctypeSystem(TDoctypeSystem node);
    void caseTCdataSectionElements(TCdataSectionElements node);
    void caseTIndent(TIndent node);
    void caseTMediaType(TMediaType node);
    void caseTImport(TImport node);
    void caseTInclude(TInclude node);
    void caseTName(TName node);
    void caseTSelect(TSelect node);
    void caseTParam(TParam node);
    void caseTVariable(TVariable node);
    void caseTMatch(TMatch node);
    void caseTTemplate(TTemplate node);
    void caseTMode(TMode node);
    void caseTPriority(TPriority node);
    void caseTApplyTemplates(TApplyTemplates node);
    void caseTApplyImports(TApplyImports node);
    void caseTCallTemplate(TCallTemplate node);
    void caseTChoose(TChoose node);
    void caseTComment(TComment node);
    void caseTCopy(TCopy node);
    void caseTCopyOf(TCopyOf node);
    void caseTElement(TElement node);
    void caseTForEach(TForEach node);
    void caseTFallback(TFallback node);
    void caseTIf(TIf node);
    void caseTMessage(TMessage node);
    void caseTTerminate(TTerminate node);
    void caseTNumber(TNumber node);
    void caseTProcessingInstruction(TProcessingInstruction node);
    void caseTDisableOutputEscaping(TDisableOutputEscaping node);
    void caseTValueOf(TValueOf node);
    void caseTSort(TSort node);
    void caseTOrder(TOrder node);
    void caseTAscending(TAscending node);
    void caseTDescending(TDescending node);
    void caseTCaseOrder(TCaseOrder node);
    void caseTUpperFirst(TUpperFirst node);
    void caseTLowerFirst(TLowerFirst node);
    void caseTLang(TLang node);
    void caseTDataType(TDataType node);
    void caseTWithParam(TWithParam node);
    void caseTAttribute(TAttribute node);
    void caseTWhen(TWhen node);
    void caseTTest(TTest node);
    void caseTNamespace(TNamespace node);
    void caseTCount(TCount node);
    void caseTLevel(TLevel node);
    void caseTSingle(TSingle node);
    void caseTMultiple(TMultiple node);
    void caseTAny(TAny node);
    void caseTFrom(TFrom node);
    void caseTValue(TValue node);
    void caseTFormat(TFormat node);
    void caseTLetterValue(TLetterValue node);
    void caseTAlphabetic(TAlphabetic node);
    void caseTTraditional(TTraditional node);
    void caseTGroupingSeparator(TGroupingSeparator node);
    void caseTGroupingSize(TGroupingSize node);
    void caseTAttributeSet(TAttributeSet node);
    void caseTWords(TWords node);
    void caseTDigits(TDigits node);
    void caseEOF(EOF node);
}
