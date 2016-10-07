package by.it.shkantau.jd01.jd01_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class VideoPlayer extends Player {

    private  int supplyVoltage;
    private double demand;
    private List <String> supportedVideoFormatList = new ArrayList<>();
    private List <String> videoInputTypeList = new ArrayList<>();

    VideoPlayer(String name, double weight, String type, int supplyVoltage, double demand) {
        super(name, weight, type);
        this.supplyVoltage = supplyVoltage;
        this.demand = demand;
        this.supportedVideoFormatList  = Arrays.asList("mp3", "mp4");
        this.videoInputTypeList = Arrays.asList("internalFlash","USB");
    }

    public VideoPlayer(String name, double weight, String type, List<String> supportedVideoFormatList, List<String> videoInputTypeList) {
        super(name, weight, type);
        this.supplyVoltage = 220;
        this.demand = 5.0;
        this.supportedVideoFormatList = supportedVideoFormatList;
        this.videoInputTypeList = videoInputTypeList;
    }

    VideoPlayer(String name, double weight, String type, int supplyVoltage, double demand, List<String> supportedVideoFormatList, List<String> videoInputTypeList) {
        super(name, weight, type);
        this.supplyVoltage = supplyVoltage;
        this.demand = demand;
        this.supportedVideoFormatList = supportedVideoFormatList;
        this.videoInputTypeList = videoInputTypeList;
    }

    @Override
    public void switchOn() {
        System.out.println("VideoPlayer is switch On");
    }

    @Override
    public void switchOf() {
        System.out.println("VideoPlayer is switch Off");
    }

    @Override
    public void plugPower(int voltage) {
        System.out.println("Plugin " + voltage + "V to VideoPlayer "+ name);
    }

    @Override
    public void repair() {
        System.out.println("VideoPlayer is repairing");
    }

    @Override
    public int getSupplyVoltage() {
        return supplyVoltage;
    }

    @Override
    public double getDemand() {
        return demand;
    }

    @Override
    void play() {
        System.out.println("Simple play!");
    }

    void play(String source) {
        System.out.println("Play from "+source);
    }

    @Override
    void stop() {
        System.out.println("Stop");
    }

    @Override
    void pause() {
        System.out.println("Pause");
    }

    @Override
    public String toString(){
        return super.toString() + ", supplyVoltage = " + supplyVoltage + "V, " + "demand = "+ demand+ "W\n"+
                "supportedVideoFormatList: " + supportedVideoFormatList + "\n"+
                "videoInputTypeList: "+ videoInputTypeList;

    }
}
