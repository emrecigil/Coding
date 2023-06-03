import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SmartCamera extends SmartDevices{
    private Float megabyte;
    private String starttime;
    public Float bellek = (float)0;
    public SmartCamera(String type, String name, Float megabyte,String status,String starttime,String switchtime){
        super(type,name,status,switchtime);
        this.megabyte = megabyte;
        this.starttime = starttime;
    }
    public void setMegabyte(Float megabyte){
        this.megabyte = megabyte;
    }
    public Float getMegabyte(){
        return megabyte;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
    public void calculateMgbyte(LocalDateTime timefinish){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
        LocalDateTime timestart = LocalDateTime.parse(this.starttime, formatter);
        Duration duration = Duration.between(timestart, timefinish);
        Float minuteDifference = (float) duration.toMinutes();
        Float a = minuteDifference * megabyte;
        bellek = bellek + a;
    }
    @Override
    public String toString() {
        return String.format("Smart Camera %s is %s and used %.2f MB of storage so " +
                "far (excluding current status), and its time to switch its status is %s."
                ,getName(),getStatus(),bellek,getSwitchTime());
    }
}
