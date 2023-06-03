import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

class SmartPlug extends SmartDevices {
    private String ampere;
    private String startTime;
    public Float watt = (float) 0;
    public SmartPlug(String type,String name, String status,String ampere,String starttime,String switchTime){
        super(type,name,status,switchTime);
        this.ampere = ampere;
        this.startTime = starttime;
    }
    public void setAmpere(String ampere) {
        this.ampere = ampere;
    }
    public String getAmpere() {
        return ampere;
    }
    public void setStartTime(String time){
            this.startTime = time;
    }
    public String getStartTime(){
        return startTime;
    }
    public void calculateWatt( LocalDateTime timefinish){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
            LocalDateTime timestart = LocalDateTime.parse(this.startTime, formatter);
            Duration duration = Duration.between(timestart, timefinish);
            Float minuteDifference = (float) duration.toMinutes();
            Float a = 220 * Float.parseFloat(getAmpere()) * minuteDifference / 60;
            watt = watt + a;
        }catch (Exception e){}
    }
    public Float getWatt(){
        return watt;
    }

    @Override
    public String toString() {
        return String.format("Smart Plug %s is %s and consumed %.2fW so " +
                "far (excluding current status), and its time to switch its status is %s."
                ,getName(),getStatus(),getWatt(),getSwitchTime());
    }
}