<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body>
                <h1>WebStore</h1>
                <table border="1" style="border-collapse: collapse">
                    <tr>
                        <th>Appliances</th>
                    </tr>
                    <tr>
                        <td>
                            <table border="1" style="border-collapse: collapse">
                                <tr>
                                    <th>FridgeList</th>
                                    <th>WasherList</th>
                                    <th>ToasterList</th>
                                </tr>
                                <tr>
                                    <td>
                                        <table border="1" style="border-collapse: collapse">
                                        <tr>
                                            <th>Brand</th>
                                            <th>Model</th>
                                            <th>Prise</th>
                                            <th>NoiseLevel</th>
                                            <th>Weight</th>
                                        </tr>
                                        <xsl:for-each select="WebStore/Appliances/FridgeList/Fridge">
                                            <tr>
                                                <td>
                                                    <xsl:value-of select="Brand" />
                                                </td>
                                                <td>
                                                    <xsl:value-of select="Model" />
                                                </td>
                                                <td>
                                                    <xsl:value-of select="Prise" />
                                                </td>
                                                <td>
                                                    <xsl:value-of select="NoiseLevel" />
                                                </td>
                                                <td>
                                                    <xsl:value-of select="Weight" />
                                                </td>
                                            </tr>
                                        </xsl:for-each>
                                        </table>
                                    </td>
                                    <td>
                                        <table border="1" style="border-collapse: collapse">
                                            <tr>
                                                <th>Brand</th>
                                                <th>Model</th>
                                                <th>Prise</th>
                                                <th>Loading</th>
                                                <th>NoiseLevel</th>
                                                <th>Weight</th>
                                            </tr>
                                            <xsl:for-each select="WebStore/Appliances/WasherList/Washer">
                                                <tr>
                                                    <td>
                                                        <xsl:value-of select="Brand" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Model" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Prise" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Loading" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="NoiseLevel" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Weight" />
                                                    </td>
                                                </tr>
                                            </xsl:for-each>
                                        </table>
                                    </td>
                                    <td>
                                        <table border="1" style="border-collapse: collapse">
                                            <tr>
                                                <th>Brand</th>
                                                <th>Model</th>
                                                <th>Prise</th>
                                                <th>Power</th>
                                            </tr>
                                            <xsl:for-each select="WebStore/Appliances/ToasterList/Toaster">
                                                <tr>
                                                    <td>
                                                        <xsl:value-of select="Brand" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Model" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Prise" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Power" />
                                                    </td>
                                                </tr>
                                            </xsl:for-each>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        </tr>
                    </table>
                <br></br>
                <table border="1">
                    <tr>
                        <th>Electronics</th>
                    </tr>
                    <tr>
                        <td>
                            <table border="1" style="border-collapse: collapse">
                                <tr>
                                    <th>TabletList</th>
                                    <th>TVList</th>
                                    <th>MobilePhoneList</th>
                                </tr>
                                <tr>
                                    <td>
                                        <table border="1" style="border-collapse: collapse">
                                            <tr>
                                                <th>Brand</th>
                                                <th>Model</th>
                                                <th>Prise</th>
                                                <th>ScreenDiagonal</th>
                                                <th>RAM</th>
                                                <th>Memory</th>
                                                <th>Weight</th>
                                            </tr>
                                            <xsl:for-each select="WebStore/Electronics/TabletList/Tablet">
                                                <tr>
                                                    <td>
                                                        <xsl:value-of select="Brand" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Model" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Prise" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="ScreenDiagonal" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="RAM" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Memory" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Weight" />
                                                    </td>
                                                </tr>
                                            </xsl:for-each>
                                        </table>
                                    </td>
                                    <td>
                                        <table border="1" height="283" style="border-collapse: collapse">
                                            <tr height="22">
                                                <th>Brand</th>
                                                <th>Model</th>
                                                <th>Prise</th>
                                                <th>Type</th>
                                                <th>Color</th>
                                                <th>ScreenDiagonal</th>
                                                <th>Weight</th>
                                            </tr>
                                            <xsl:for-each select="WebStore/Electronics/TVList/TV">
                                                <tr>
                                                    <td>
                                                        <xsl:value-of select="Brand" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Model" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Prise" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Type" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Color" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="ScreenDiagonal" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Weight" />
                                                    </td>
                                                </tr>
                                            </xsl:for-each>
                                        </table>
                                    </td>
                                    <td>
                                        <table border="1" height="283" style="border-collapse: collapse">
                                            <tr height="22">
                                                <th>Brand</th>
                                                <th>Model</th>
                                                <th>Prise</th>
                                                <th>ScreenDiagonal</th>
                                                <th>RAM</th>
                                                <th>Memory</th>
                                                <th>TypeBattery</th>
                                                <th>Weight</th>
                                            </tr>
                                            <xsl:for-each select="WebStore/Electronics/MobilePhoneList/MobilePhone">
                                                <tr>
                                                    <td>
                                                        <xsl:value-of select="Brand" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Model" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Prise" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="ScreenDiagonal" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="RAM" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Memory" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="TypeBattery" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Weight" />
                                                    </td>
                                                </tr>
                                            </xsl:for-each>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
                <br></br>
                <table border="1" style="border-collapse: collapse">
                    <tr>
                        <th>Computers</th>
                    </tr>
                    <tr>
                        <td>
                            <table border="1" style="border-collapse: collapse">
                                <tr>
                                    <th>PCList</th>
                                    <th>LaptopList</th>
                                    <th>MonitorList</th>
                                </tr>
                                <tr>
                                    <td>
                                        <table border="1" style="border-collapse: collapse">
                                            <tr height="22">
                                                <th>Brand</th>
                                                <th>Model</th>
                                                <th>Prise</th>
                                                <th>RAM</th>
                                                <th>HDD</th>
                                            </tr>
                                            <xsl:for-each select="WebStore/Computers/PCList/PC">
                                                <tr>
                                                    <td>
                                                        <xsl:value-of select="Brand" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Model" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Prise" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="RAM" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="HDD" />
                                                    </td>
                                                </tr>
                                            </xsl:for-each>
                                        </table>
                                    </td>
                                    <td>
                                        <table border="1" style="border-collapse: collapse">
                                            <tr height="22">
                                                <th>Brand</th>
                                                <th>Model</th>
                                                <th>Prise</th>
                                                <th>RAM</th>
                                                <th>HDD</th>
                                                <th>Weight</th>
                                            </tr>
                                            <xsl:for-each select="WebStore/Computers/LaptopList/Laptop">
                                                <tr>
                                                    <td>
                                                        <xsl:value-of select="Brand" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Model" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Prise" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="RAM" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="HDD" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Weight" />
                                                    </td>
                                                </tr>
                                            </xsl:for-each>
                                        </table>
                                    </td>
                                    <td>
                                        <table border="1" style="border-collapse: collapse">
                                            <tr height="22">
                                                <th>Brand</th>
                                                <th>Model</th>
                                                <th>Prise</th>
                                                <th>ScreenDiagonal</th>
                                            </tr>
                                            <xsl:for-each select="WebStore/Computers/MonitorList/Monitor">
                                                <tr>
                                                    <td>
                                                        <xsl:value-of select="Brand" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Model" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="Prise" />
                                                    </td>
                                                    <td>
                                                        <xsl:value-of select="ScreenDiagonal" />
                                                    </td>
                                                </tr>
                                            </xsl:for-each>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>