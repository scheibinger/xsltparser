<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
  <xsl:output method=xml indent=yes
    doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
    doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"/>
  <xsl:template match="katalog">
      <html> <head> <title>Katalog <xsl:value-of select="./tytulKatalogu"/></title>
		<style>
			table {
				  border-collapse: collapse;
				  border: 1px solid #03476F;
				  font: normal 11px verdana, arial, helvetica, sans-serif;
				  color: #363636;
				  background: #92C428;
				  }
caption {
				  text-align: center;
				  font: bold 18px arial, helvetica, sans-serif;
				  background: transparent;
				  padding:6px 4px 8px 0px;
				  color: #03476F;
				  text-transform: uppercase;
				  }
td, th {
				  border: 1px dotted #03476F;
				  padding: .4em;
				  color: #363636;
				  }

thead th, tfoot th {
				  font: bold 11px verdana, arial, helvetica, sans-serif;
				  border: 1px solid #03476F;;
				  text-align: left;
				  background: #4591AD;
				  color: #FFFFFF;
				  padding-top:3px;
				  }
tbody td a {
				  background: transparent;
				  text-decoration: none;
				  color: #363636;
				  }
tbody td a:hover {
				  background: #C2F64D;
				  color: #363636;
				  }
tbody th a {
				  font: normal 11px verdana, arial, helvetica, sans-serif;
				  background: transparent;
				  text-decoration: none;
				  font-weight:normal;
				  color: #363636;
				  }
tbody th a:hover {
				  background: transparent;
				  color: #363636;
				  }
tbody th, tbody td {
				  vertical-align: top;
				  text-align: left;
				  }
tfoot td {
				  border: 1px solid #03476F;
				  background: #4591AD;
				  padding-top:3px;
				  color: #FFFFFF;
				  }
.odd {
				  background: #AEE239;
				  }
tbody tr:hover {
				  background: #FFD800;
				  border: 1px solid #03476F;
				  color: #FFFFFF;
				  }
tbody tr:hover th,
tbody tr.odd:hover th {
				  background: #FFD800;
				  color: #FFFFFF;
				  }
		</style>
		</head><body><xsl:apply-templates/>
</body></html></xsl:template>
  <xsl:template match="ksiazka">
    <xsl:apply-templates/>
</xsl:template>
  <xsl:template match="id">
    <h3>Dane identyfikacyjne ksiazki</h3>
	Tytul: <xsl:value-of select="tytul"/><br/>
	ISBN: <xsl:value-of select="isbn"/><br/>
	Autor: <xsl:value-of select="autor"/><br/>
 </xsl:template>
  <xsl:template match="spisTresci">
    <h3>Spis tresci</h3><table><tr><th>Nr</th><th>Tytul</th></tr><tbody>
	<xsl:apply-templates />
    </tbody></table></xsl:template>
     <xsl:template match="rozdzialy">
      
      <xsl:for-each select="r">

        <tr>
       <td><xsl:value-of select="chapter" /></td>
       <td><xsl:value-of select="tytul" /></td>
        </tr>  

      
    
  </xsl:template>
</xsl:stylesheet>