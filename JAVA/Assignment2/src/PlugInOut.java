import java.time.format.DateTimeFormatter;

public class PlugInOut extends Add {
    public static void plugIn(String plugName,String amper){
        boolean found = false;
        boolean full = false;
        boolean range = false;
        try {
        for (SmartDevices s : akilli_alet){
                if (s.getName().equals(plugName) && s.getType().equals("SmartPlug")) {
                    found = true;
                    if (((SmartPlug) s).getAmpere() == null) {
                        full = true;
                    }
                    if (Float.parseFloat(amper) > 0) {
                        range = true;
                        if (found && full && range) {
                            if(s.getStatus().equals("On")){
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
                                String formattedTime = formatter.format(TimeCont.initialTime);
                                ((SmartPlug) s).setAmpere(amper);
                                ((SmartPlug) s).setStartTime(formattedTime);
                            } else if (s.getStatus().equals("Off")) {
                                ((SmartPlug) s).setAmpere(amper);
                            }
                        }
                    }
                }
        }

    if (!found){
        System.out.println("ERROR: This device is not a smart plug!");
    } else if (!full) {
        System.out.println("ERROR: There is already an item plugged in to that plug!");
    } else if (full && !range) {
        System.out.println("ERROR: Ampere value must be a positive number!");
    }
        }catch (Exception e){System.out.println("ERROR: Erroneous command!");}
    }
    public static void plugOut(String plugName){
        boolean found = false;
        boolean full = false;
        for (SmartDevices s : akilli_alet) {
            if (s.getName().equals(plugName) && s.getType().equals("SmartPlug")) {
                found = true;
                if (((SmartPlug) s).getAmpere() != null) {
                    full = true;
                }
                if (found && full && s.getStatus().equals("On")){
                    ((SmartPlug) s).calculateWatt(TimeCont.initialTime);
                    ((SmartPlug) s).setAmpere(null);
                } else if (found && full && s.getStatus().equals("On")) {
                    ((SmartPlug) s).setAmpere(null);
                }
            }
        }
        if (!found){
            System.out.println("ERROR: This device is not a smart plug!");
        } else if (found && !full) {
            System.out.println("ERROR: This plug has no item to plug out from that plug!");
        }
    }
}
