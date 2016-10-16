<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xls="http://www.w3.org/1999/XSL/Transform">
    <xls:output method="html"/>
    <xls:template match="/ticket">
        <table border="1">
            <tr><td> </td><td>Name</td><td>Surnmame</td><td>Post</td><td>Category</td><td>Cabinet</td></tr>
            <xsl:apply-templates/>
        </table>
    </xls:template>

    <xls:template match="/ticket/policlinic/doctor/doctorName">
        <td>Doctor:</td>>
        <td><xls:apply-templates/></td>
    </xls:template>

    <xls:template match="/ticket/policlinic/doctor/doctorSurname">
        <td><xls:apply-templates/></td>
    </xls:template>

    <xls:template match="/ticket/policlinic/doctor/post">
        <td><xls:apply-templates/></td>
    </xls:template>

    <xls:template match="/ticket/policlinic/doctor/category">
        <td><xls:apply-templates/></td>
    </xls:template>

    <xls:template match="/ticket/policlinic/doctor/cabinet">
        <td><xls:apply-templates/></td>
    </xls:template>

    <xls:template match="/ticket/patient/patientName">
        <tr><td> </td><td>Name</td><td>Surnmame</td><td>BirthDay</td><td>Address</td><td>-</td></tr>
        <td>Patient:</td>
        <td><xls:apply-templates/></td>
    </xls:template>

    <xls:template match="/ticket/patient/patientSurname">
        <td><xls:apply-templates/></td>
    </xls:template>

    <xls:template match="/ticket/patient/birthDay">
        <td><xls:apply-templates/></td>
    </xls:template>

    <xls:template match="/ticket/patient/address">
        <td><xls:apply-templates/></td>
        <td>-</td>
    </xls:template>

    <xls:template match="/ticket/visitDate/date">
        <tr><td> </td><td>Date</td><td>Time</td><td>-</td><td>-</td><td>-</td></tr>
        <td>VisitDate</td>
        <td><xls:apply-templates/></td>
    </xls:template>

    <xls:template match="/ticket/visitDate/time">
        <td><xls:apply-templates/></td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
    </xls:template>

</xsl:stylesheet>