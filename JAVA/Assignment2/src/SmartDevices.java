import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

class SmartDevices {
    private String name;
    private String type;
    private String status;
    private String switchTime;
    public SmartDevices(String type,String name,String status,String switchTime) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.switchTime = switchTime;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getSwitchTime() {
        return switchTime;
    }

    public void setSwitchTime(String switchTime) {
        this.switchTime = switchTime;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public static void zReport(){
        Collections.sort(Add.akilli_alet, Comparator.comparing(SmartDevices::getSwitchTime,
                Comparator.nullsLast(Comparator.naturalOrder())));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
        String formattedTime = formatter.format(TimeCont.initialTime);
        System.out.println("Time is:\t"+formattedTime);
        for (SmartDevices s : Add.akilli_alet){
            System.out.println(s);
        }
    }
}

