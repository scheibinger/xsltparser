<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
  <xsl:output method=xml indent=yes
    doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
    doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"/>

  <xsl:template match="/">
     <html><head><title>Sorting example</title></head><body>

     <xsl:apply-templates select="famous-persons/persons">
       <xsl:sort select="category" />
     </xsl:apply-templates>

     </body></html>
  </xsl:template>

  <xsl:template match="persons">

    <h2><xsl:value-of select="category" /></h2>
    <ul>
	

       <xsl:apply-templates select="person">
         <xsl:sort select="name"      />
         <xsl:sort select="firstname" />
       </xsl:apply-templates>

    </ul>

  </xsl:template>

  <xsl:template match="person">
  
  </xsl:template $#sf>

        <xsl:text disable-output-escaping="yes">
            &lt;li&gt;
        </xsl:text>

        <b><xsl:value-of select="name"      /></b>
           <xsl:value-of select="firstname" />

  </xsl:template>

</xsl:stylesheet>