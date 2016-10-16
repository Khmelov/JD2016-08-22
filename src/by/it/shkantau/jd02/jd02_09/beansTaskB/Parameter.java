package by.it.shkantau.jd02.jd02_09.beansTaskB;

import javax.xml.bind.annotation.XmlElement;


class Parameter implements Comparable {
     static final String UINT32  = "uint32_t";
    private static final String FLOAT32 = "float32_t";
     static final String UINT16  = "uint16_t";
    private String name;
    private int address;
    private String paramType;
    private int paramLengthReg;
    private String paramDescription = "";

    public Parameter() {
    }

    private Parameter(String name, int address) {
        this.name = name;
        this.address = address;
    }

    Parameter(String name, int address, int paramLengthReg, String paramDescription) {
        this(name,address);
        this.paramType = FLOAT32;
        this.paramLengthReg = paramLengthReg;
        this.paramDescription = paramDescription;
    }

    @Override
    public String toString() {
        return name + "@0x" + Integer.toHexString(address) + " " + paramType + " " + paramLengthReg + " " + paramDescription;
    }

    @XmlElement(name = "parameterAddress")
    int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @XmlElement(name = "parameterName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "paramDescription")
    String getParamDescription() {
        return paramDescription;
    }

    public void setParamDescription(String paramDescription) {
        this.paramDescription = paramDescription;
    }

    @XmlElement(name = "paramLengthReg")
    int getParamLengthReg() {
        return paramLengthReg;
    }

    public void setParamLengthReg(int paramLengthReg) {
        this.paramLengthReg = paramLengthReg;
    }

    @XmlElement(name = "paramType")
    String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    @Override
    public int compareTo(Object o) {
        int compareAddress = this.getAddress();
        /* For Ascending order*/
        return this.getAddress() - compareAddress;
    }
}
