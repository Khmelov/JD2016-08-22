package by.it.snegurskiy.jd01.jd01_08;

/**
 * Created by user on 07.09.2016.
 */
class Comedy extends NativyFilm{

    @Override
    public String showState() {
        String state="Плеер остановлен";
        if (this.isStatePlay()) {
            state = "Воспроизведение видео";
            if (this.isStatePause())
                state = "Плеер на паузе";}
        String state2="Звук выключен";
            if (this.isSoundStatus()){
                state2="Громкость звука"+" "+sound;
            }

        return getClass()+" " +state+" и "+state2;
    }
}
