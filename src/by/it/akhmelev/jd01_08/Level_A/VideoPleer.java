package by.it.akhmelev.jd01_08.Level_A;

class VideoPleer extends Pleer implements ITechnic{
    @Override
    public String showState() {
        String state="Плеер остановлен";
        if (this.isStatePlay()) {
            state = "Воспроизведение видео";
            if (this.isStatePause())
                state = "Плеер на паузе";
        }
        return state;
    }

}
