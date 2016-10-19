package by.it.snegurskiy.jd01.jd01_08;

/**
 * Created by user on 07.09.2016.
 */
abstract class NativyFilm implements Film {

    private boolean statePlay=false;
    private boolean statePause=true;
    public int sound=0;
    private boolean soundStatus=false;


    @Override
    public boolean play() {
        statePlay=true;
        statePause=false;
        return true;
    }

    @Override
    public boolean stop() {
        boolean result=statePlay;
        statePlay=false;
        statePause=false;
        return result;
    }

    @Override
    public void pause() {
        statePause=!statePause;
    }

    @Override
    public int soundUp() {
        sound=sound+10;
        return sound;
    }

    @Override
    public void soundDown() {
        if (sound>=10) sound=sound-10;

    }

    @Override
    public boolean soundOn() {

        soundStatus=true;
        return true;
    }

    @Override
    public boolean soundOff() {

        soundStatus=false;
        return true;
    }

    public abstract String showState();

    boolean isStatePlay() {
        return statePlay;
    }

    boolean isStatePause() {
        return statePause;
    }

    boolean isSoundStatus() {
        return soundStatus;
    }



}
