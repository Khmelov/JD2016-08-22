<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl ="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
    <xsl:template match="/Dillers">
    <table border="1">
        <tr><td>Name</td><td>Email</td><td>Nickname</td><td>Password</td><td>Ad</td></tr>
        <xsl:apply-templates/>
    </table>
    </xsl:template>

            <xsl:template match="/Dillers/Diller">
            <tr><xsl:apply-templates/></tr>
            </xsl:template>

            <xsl:template match="/Dillers/Diller/Name">
            <td><xsl:apply-templates/></td>
            </xsl:template>

            <xsl:template match="/Dillers/Diller/Email">
            <td><xsl:apply-templates/></td>
            </xsl:template>

            <xsl:template match="/Dillers/Diller/Nickname">
            <td><xsl:apply-templates/></td>
            </xsl:template>

            <xsl:template match="/Dillers/Diller/Password">
            <td><xsl:apply-templates/></td>
            </xsl:template>

            <xsl:template match="/Dillers/Diller/Ad">
            <td><xsl:apply-templates/></td>
            </xsl:template>

</xsl:stylesheet>