<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
  <xsl:output method=xml indent=yes
    doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
    doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"/>
  <xsl:template match="katalog">
      <html> <head> <title>Katalog <xsl:value-of select="./tytulKatalogu"/></title> </head><body><xsl:apply-templates/>
</body></html></xsl:template>
  <xsl:template match="ksiazka">
    <xsl:apply-templates/>
</xsl:template>
  <xsl:template match="id">
    <h3>Dane identyfikacyjne ksiazki</h3>Tytul: <xsl:value-of select="tytul"/><br/>ISBN: <xsl:value-of select="isbn"/><br/>Autor: <xsl:value-of select="autor"/><br/></xsl:template>
  <xsl:template match="spisTresci">
    <h3>Spis tresci</h3><table><xsl:apply-templates />
    </table></xsl:template>
  <xsl:template match="rozdzialy">
      
      <xsl:for-each select="r">
          <xsl:sort select="tytul">
       <tr>
       <td>Tytul rozdzialu: <xsl:value-of select="chapter" /></td>
       <td>Nr rozdzialu: <xsl:value-of select="tytul" /></td>
        </tr>
      </xsl:for-each>
    
  </xsl:template>
</xsl:stylesheet>