package by.it.prymshyts.jd01_13.VariantC;

interface IFurniture {

    void assemble();
    void disassemble();

    void moveTo(String to);

    void ignite();
    void extinguish();

    void damage();
    void repair();
    void checkState();
}
