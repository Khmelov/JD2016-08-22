<?xml version="1.0" encoding="UTF-8" ?>
<xsl:transform  version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/airport">
    <table border="1">
        <tr><td>company</td><td>plane</td><td>departureTime</td><td>arrivalTime</td><td>crew</td></tr>
        <xsl:apply-templates/>
    </table>
    </xsl:template>

    <xsl:template match="/airport/flights/flight">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/airport/flights/flight/company">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/airport/flights/flight/plane">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/airport/flights/flight/departureTime">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/airport/flights/flight/arrivalTime">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/airport/flights/flight/crew">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:transform >