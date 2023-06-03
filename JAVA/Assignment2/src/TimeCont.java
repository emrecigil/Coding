import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TimeCont {
    public static LocalDateTime initialTime;
    public static LocalDateTime switchedTime;
    public void setInitalTime(String initalTime) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
            this.initialTime = LocalDateTime.parse(initalTime, formatter);
            System.out.println("SUCCESS: Time has been set to " + initalTime);
        }
    public void setTime(String settedTime){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
            LocalDateTime time = LocalDateTime.parse(settedTime, formatter);
            boolean correcttime = false;
            System.out.println(initialTime);
            if (initialTime.isBefore(time)){
                initialTime = time;
                System.out.println(initialTime);
                correcttime = true;
            }else {
                throw new Exception();}
            for (SmartDevices s : Add.akilli_alet){
                try {
                    LocalDateTime switchTime = LocalDateTime.parse(s.getSwitchTime(), formatter);
                    if ((switchTime.isEqual(initialTime) || switchTime.isBefore(initialTime)) &&
                            s.getType().equals("SmartPlug")) {
                        if (s.getStatus().equals("Off")) {
                            s.setStatus("On");
                            if (((SmartPlug)s).getAmpere() != null) {
                                ((SmartPlug)s).setStartTime(s.getSwitchTime());
                            }
                            s.setSwitchTime(null);
                        } else if (s.getStatus().equals("On")) {
                            ((SmartPlug) s).calculateWatt(switchTime);
                            s.setStatus("Off");
                            s.setSwitchTime(null);
                        }
                    } else if ((switchTime.isEqual(initialTime) || switchTime.isBefore(initialTime)) &&
                            s.getType().equals("SmartCamera")) {
                        if (s.getStatus().equals("Off")) {
                            s.setStatus("On");
                            ((SmartCamera)s).setStarttime(s.getSwitchTime());
                            s.setSwitchTime(null);
                        }
                        else if (s.getStatus().equals("On")) {
                            ((SmartCamera) s).calculateMgbyte(switchTime);
                            s.setStatus("Off");
                            s.setSwitchTime(null);
                        }
                    } else if ((switchTime.isEqual(initialTime) || switchTime.isBefore(initialTime))) {
                        if (s.getStatus().equals("Off")) {
                            s.setStatus("On");
                            s.setSwitchTime(null);
                        } else if (s.getStatus().equals("On")) {
                            s.setStatus("Off");
                            s.setSwitchTime(null);
                        }

                    }
                }catch (Exception e){}
            }
    }catch (DateTimeException e){System.out.println("ERROR: Time format is not correct!");}
    catch (Exception b){System.out.println("ERROR: Time cannot be reversed!");
        }
}
    public void switchedTime(String name ,String switchedTime){
        try {
            boolean found = false;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
            this.switchedTime = LocalDateTime.parse(switchedTime, formatter);
            for (SmartDevices s : Add.akilli_alet){
                if(s.getName().equals(name)){
                    found = true;
                    s.setSwitchTime(switchedTime);
                }
            }
            if(!found){
                System.out.println("ERROR: There is no such a device!");
            }
        }catch (Exception e){System.out.println("ERROR: Time format is not correct!");}
    }
    public void skipTime(long minute){
        try {
            if (minute<0){System.out.println("ERROR: Time cannot be reversed!");}
            else if (minute==0) {System.out.println("ERROR: There is nothing to skip!");}
            else{
                this.initialTime = this.initialTime.plusMinutes(minute);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
                for (SmartDevices s : Add.akilli_alet){
                    try {
                        LocalDateTime switchTime = LocalDateTime.parse(s.getSwitchTime(), formatter);
                        if ((switchTime.isEqual(initialTime) || switchTime.isBefore(initialTime)) &&
                                s.getType().equals("SmartPlug")) {
                            if (s.getStatus().equals("On")){
                                ((SmartPlug) s).calculateWatt(switchTime);
                                s.setStatus("Off");
                            }else if(((SmartPlug) s).getAmpere() != null && s.getStatus().equals("Off")) {
                                ((SmartPlug) s).setStartTime(s.getSwitchTime());
                                s.setStatus("On");
                            }
                        } else if ((switchTime.isEqual(initialTime) || switchTime.isBefore(initialTime)) &&
                                s.getType().equals("SmartCamera")) {
                            if (s.getStatus().equals("On")){
                                ((SmartCamera) s).calculateMgbyte(switchTime);
                                s.setStatus("Off");
                            }else if(s.getStatus().equals("Off")) {
                                ((SmartCamera) s).setStarttime(s.getSwitchTime());
                                s.setStatus("On");
                            }

                        }
                    }catch (Exception e){}
                }
            }
        }catch (Exception e){System.out.println("ERROR: Time format is not correct!");}
    }

    public LocalDateTime getInitialTime() {
        return initialTime;
    }

    public LocalDateTime getSwitchedTime() {
        return switchedTime;
    }
    public void switchDevice(String name, String status){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
        String formattedTime = formatter.format(initialTime);
        boolean check = false;
        boolean found = false;
        for (SmartDevices s : Add.akilli_alet){
            if (s.getName().equals(name)){
                found = true;
                if (!s.getStatus().equals(status)){
                    check = true;
                    s.setStatus(status);
                }
            }
            if (check && status.equals("Off") && s.getType().equals("SmartPlug") &&
                    ((SmartPlug)s).getAmpere() != null){
                ((SmartPlug)s).calculateWatt(initialTime);
                break;
            }
            else if (check && status.equals("On") && s.getType().equals("SmartPlug") &&
                    ((SmartPlug)s).getAmpere() != null ) {
                ((SmartPlug)s).setStartTime(formattedTime);
                break;
            }
            else if (check && status.equals("Off") && s.getType().equals("SmartCamera")){
                ((SmartCamera)s).calculateMgbyte(initialTime);
            }
            else if (check && status.equals("On") && s.getType().equals("SmartCamera")){
                ((SmartCamera)s).setStarttime(formattedTime);
            }
        }
        if (!found) {
            System.out.println("ERROR: There is not such a device!");
        }
        else if (found && !check) {
            System.out.println("ERROR: This device is already switched " + status.toLowerCase());
        }
    }
    public void nop(){

        Collections.sort(Add.akilli_alet, Comparator.comparing(SmartDevices::getSwitchTime,
                Comparator.nullsLast(Comparator.naturalOrder())));

        try {
            if (Add.akilli_alet.get(0).getSwitchTime() != null) {
                setTime(Add.akilli_alet.get(0).getSwitchTime());
            } else {
                System.out.println("ERROR: There is nothing to switch!");
            }
        }catch (IndexOutOfBoundsException e){System.out.println("ERROR: There is nothing to switch!");}
    }
}
