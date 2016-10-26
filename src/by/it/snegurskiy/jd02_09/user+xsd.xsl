<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/users">
        <table border="1">
            <tr><td>surname</td><td>name</td><td>login</td><td>password</td><td>account</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/users/user">
    <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/users/user/surname">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/account">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>