<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
  <xsl:output method=xml indent=yes
    doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
    doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"/>

<xsl:template match="/">
  <html>
  <head>
  <style>
  table {
  border-collapse: collapse;
  border: 2px solid #C5BA85;
  font: normal 10px verdana, arial, helvetica, sans-serif;
  color: #333333;
  background: #BFE756;
  }
caption {
  padding: 0 .4em .4em;
  text-align: left;
  font-size: 1em;
  font-weight: bold;
  text-transform: uppercase;
  color: #333333;
  background: transparent;
  }
td, th {
  color: #636363;
  border: 1px solid #cc9;
  padding: .3em;
  }
thead th, tfoot th {
  font: normal 11px georgia, verdana, arial, helvetica, sans-serif;
  border: transparent;
  text-align: left;
  font-size: 1em;
  font-weight: bold;
  color: #333333;
  background: #C5BA85;
  }
tbody td a {
  background: transparent;
  color: #72724c;
  text-decoration: none;
  }
tbody td a:hover {
  background: transparent;
  color: #636363;
  }
tbody th a {
  font: normal 11px georgia, verdana, arial, helvetica, sans-serif;
  background: transparent;
  color: #333333;
  text-decoration: none;
  font-weight:normal;
  }
tbody th a:hover {
  background: transparent;
  color: #333333;
  }
tbody th, tbody td {
  vertical-align: top;
  text-align: left;
  }
tfoot td {
  border: 1px solid #C5BA85;
  background: #C5BA85;
  }
.odd {
  background: #91AB59;
  }
tbody tr:hover {
  color: #333444;
  background: #DDCFAE;
  }
tbody tr:hover th,
tbody tr.odd:hover th {
  background: #C5BA85;
  }
  </style>
  </head>
  <body>
    <h2>My CD Collection</h2>
    <table border="1">
	<tbody>
      <tr bgcolor="#9acd32">
        <th>Title</th>

        <th>Artist</th>
      </tr>
      <xsl:for-each select="catalog/cd">
      <tr>
        <td><xsl:value-of select="title" /></td>
        <td><xsl:value-of select="artist" /></td>
      </tr>
      </xsl:for-each>
	</tbody>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>