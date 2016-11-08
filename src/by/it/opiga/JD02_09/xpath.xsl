<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/orders/order">
        <table border="1">

            <tr>
                <td>FIO</td>
                <td>passport</td>
                <td>adress</td>
                <td>phone</td>
                <td>category</td>
                <td>arrive</td>
                <td>leave</td>
                <td>payment</td>
            </tr>
        </table>
    </xsl:template>

    <xsl:template match="/orders/order">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="/orders/order/client">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/orders/order/discription">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/orders/order/client/FIO">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/orders/order/client/passport">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/orders/order/client/adress">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/orders/order/client/phone">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/orders/order/discription/category">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/orders/order/discription/arrive">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/orders/order/discription/leave">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/orders/order/discription/payment">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>