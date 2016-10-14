<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Library</h2>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="catalog">
        <h3>Sci-Fi</h3>
        <xsl:apply-templates select="genre[@name='Sci-Fi']"/>
        <hr/>
        <h3>Fantasy</h3>
        <xsl:apply-templates select="genre[@name='Fantasy']"/>
    </xsl:template>

    <xsl:template match="genre[@name='Sci-Fi']">
        <table border="1" bgcolor="95C0FF" width="600px" bordercolor="black">
            <tr align="center">
                <td width="200px"><b>Title</b></td>
                <td width="500px"><b>Authors</b></td>
                <td><b>Year</b></td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="genre[@name='Fantasy']">
        <table border="1" bgcolor="FFA4A4" width="600px" bordercolor="black">
            <tr align="center">
                <td width="200px"><b>Title</b></td>
                <td width="500px"><b>Authors</b></td>
                <td><b>Year</b></td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="book">
        <tr>
            <td><xsl:value-of select="./title"/></td>
            <td><xsl:apply-templates select="./authors"/></td>
            <td><xsl:value-of select="./year"/></td>
        </tr>
    </xsl:template>

    <xsl:template match="authors">
        <xsl:for-each select="./author">
            <xsl:value-of select="."/>
            <br/>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>