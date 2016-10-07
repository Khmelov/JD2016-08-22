package by.it.akhmelev.jd02_06.p11_mediator;

abstract class Mediator {
    public abstract void send(String message, Colleague colleague);
}
