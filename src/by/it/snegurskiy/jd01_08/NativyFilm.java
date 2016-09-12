package by.it.snegurskiy.jd01_08;

/**
 * Created by user on 07.09.2016.
 */
abstract class NativyFilm implements Film {

    private boolean statePlay=false;
    private boolean statePause=true;


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
    public boolean subtitlesOn() {
        return false;
    }

    @Override
    public boolean subtitlesOff() {
        return false;
    }

    @Override
    public boolean soundOn() {
        return false;
    }

    @Override
    public boolean soundOff() {
        return false;
    }

    public abstract String showState();

    boolean isStatePlay() {
        return statePlay;
    }

    boolean isStatePause() {
        return statePause;
    }



}
