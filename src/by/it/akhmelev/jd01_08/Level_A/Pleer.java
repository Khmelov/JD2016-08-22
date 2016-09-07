package by.it.akhmelev.jd01_08.Level_A;

abstract class Pleer implements ITechnic{
    //теперь нужно два состояния, общие для любых возможных реализаций плеера
    //первое - играет он или не играет
    private boolean statePlay=false;
    //второе стоит ли плеер на паузе
    private boolean statePause=true;
    //теперь реализуем интерфейсы


    @Override
    public boolean play() {
        //при воспроизведении флаг паузы получает значение false а флаг воспроизведения true
        statePlay=true;
        statePause=false;
        return true;
    }

    @Override
    public boolean stop() {
        //при остановке флаг воспроизведения и паузы переходит в состояние false
        boolean result=statePlay;
        statePlay=false;
        statePause=false;
        return result;
    }

    @Override
    public void pause() {
        // при паузе флаг инвертирует свое состояние
        statePause=!statePause;

    }

    public abstract String showState();

    boolean isStatePlay() {
        return statePlay;
    }

    boolean isStatePause() {
        return statePause;
    }
}
