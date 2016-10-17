<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/Store">
        <table border="1">
            <tr><td>Email</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Store/Admin">
    <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="Store/Admin/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Store/User">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="Store/User/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>