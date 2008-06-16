<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
<xsl:output method=xml indent=yes
    doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
    doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"/>


<xsl:template match="/">
<xsl:variable name="header" select="red"/>
  <html>
  <body>
  <table>
     <xsl:copy-of select="header" />
    <xsl:for-each select="reference/record">
    <tr>
      <td><xsl:value-of select="element"/></td>
      <td><xsl:value-of select="description"/></td>
    </tr>
    </xsl:for-each>
  </table>
  <br />
  <table>
     <xsl:copy-of select="header" />
    <xsl:for-each select="table/record">
    <tr>
      <td><xsl:value-of select="element"/></td>
      <td><xsl:value-of select="description"/></td>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>

<xsl:template match="/">
  <html>
  <body>
  <table>
     <xsl:copy-of select="header" />
    <xsl:for-each select="reference/record">
    <tr>
      <td><xsl:value-of select="element"/></td>
      <td><xsl:value-of select="description"/></td>
    </tr>
    </xsl:for-each>
  </table>
  <br />
  <table>
     <xsl:copy-of select="header" />
    <xsl:for-each select="table/record">
    <tr>
      <td><xsl:value-of select="element"/></td>
      <td><xsl:value-of select="description"/></td>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>


</xsl:stylesheet>