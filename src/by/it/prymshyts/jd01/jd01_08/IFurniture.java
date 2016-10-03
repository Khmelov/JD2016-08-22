package by.it.prymshyts.jd01.jd01_08;

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
