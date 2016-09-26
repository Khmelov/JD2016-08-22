package by.it.kisel.JD01_08d;

public class Runner {
    public static void main(String[] args) {
        Neurosurgeon neurosurgeon = new Neurosurgeon();
        neurosurgeon.operate();
        neurosurgeon.showState();
        neurosurgeon.giveMedicines(50);
        neurosurgeon.showState();
        neurosurgeon.cantOperate();
        neurosurgeon.showState();
        neurosurgeon.cantOperate();
        neurosurgeon.giveMedicines(10);
        neurosurgeon.showState();
        neurosurgeon.operate();
        neurosurgeon.giveMedicines(80);
        neurosurgeon.showState();

    }
}
