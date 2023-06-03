public class SettingsDevice {
    public static void remove(String name){
        boolean deviceFound = false;
        for (SmartDevices s: Add.akilli_alet ){
            if(s.getName().equals(name)){
                System.out.print("SUCCESS: Information about removed smart device is as follows:\n");
                TimeCont timel = new TimeCont();
                timel.switchDevice(name,"Off");
                System.out.println(s);
                Add.akilli_alet.remove(s);
                deviceFound = true;
                break;
            }
        }

        if (!deviceFound) {
            System.out.println("ERROR: There is not such a device!");
        }
    }
    public static void changeName(String oldName, String newName){
        if (oldName.equals(newName)) {
            System.out.println("ERROR: Both of the names are the same, nothing changed!");
        }
        else {
            boolean found = Add.akilli_alet.stream().anyMatch(name -> name.getName().equals(newName));
            if (found){
                System.out.println("ERROR: There is already a smart device with same name!");
            }else{
                Add.akilli_alet.forEach(name -> {
                    if (name.getName().equals(oldName)) {
                        name.setName(newName);
                    }
                });
            }
        }
    }
    public static void setKelvinTwo(String name,String kelvin){
        boolean type = false;
        boolean range = false;
       for (SmartDevices s : Add.akilli_alet){
           if (s.getName().equals(name) && s.getType().equals("SmartLamp")) {
               type = true;
               if (Integer.parseInt(kelvin) >= 2000 && Integer.parseInt(kelvin) <= 6500) {
                   ((SmartLamb) s).setKelvin(Integer.parseInt(kelvin));
                   range = true;
               }
           }
       }
           if (type && !range) {
               System.out.println("ERROR: Kelvin value must be in range of 2000K-6500K!");
           } else if (!type) {
               System.out.println("ERROR: This device is not a smart lamp!");
           }

    }
    public static void setBrightnessTwo(String name, String brightness) {
        boolean type = false;
        boolean range = false;
        for (SmartDevices s : Add.akilli_alet) {
            if (s.getName().equals(name) && s.getType().equals("SmartLamp")) {
                type = true;
                if (Integer.parseInt(brightness) >= 0 && Integer.parseInt(brightness) <= 100) {
                    ((SmartLamb) s).setBrightness(Integer.parseInt(brightness));
                    range = true;
                }
            }
        }
        if (type && !range) {
            System.out.println("ERROR: Brightness must be in range of 0%-100%!");
        } else if (!type) {
            System.out.println("ERROR: This device is not a smart lamp!");
        }
    }
    public static void setColorCodeTwo(String name, String color){
        String regex = "^0x[0-9A-Fa-f]+$";
        boolean type = false;
        boolean range = false;
        for (SmartDevices s : Add.akilli_alet) {
            if (s.getName().equals(name) && s.getType().equals("SmartColorLamp")) {
                type = true;
                if (color.matches(regex) && color.length()<9) {
                    ((SmartCLamb) s).setKelvin(color);
                    range = true;
                }
            }
        }
        if (type && !range) {
            System.out.println("ERROR: Color code value must be in range of 0x0-0xFFFFFF!");
        } else if (!type) {
            System.out.println("ERROR: This device is not a smart color lamp!");
        }
    }
    public static void setWhiteTwo(String name, String kelvin, String brightness){
        boolean type = false;
        boolean range = false;
        boolean tukendim = false;
        for (SmartDevices s : Add.akilli_alet) {
            boolean b = Integer.parseInt(kelvin) >= 2000 && Integer.parseInt(kelvin) <= 6500;
            boolean b1 = Integer.parseInt(brightness) >= 0 && Integer.parseInt(brightness) <= 100;
            if (s.getName().equals(name) && s.getType().equals("SmartColorLamp")){
                type = true;
                if (b) {
                    range = true;
                    if (b1) {
                        ((SmartCLamb) s).setKelvin(kelvin);
                        ((SmartCLamb) s).setBrightness(Integer.parseInt(brightness));
                        tukendim = true;
                        break;
                    }
                }
            } else if (s.getName().equals(name) && s.getType().equals("SmartLamp")) {
                type = true;
                if (b) {
                    range = true;
                    if (b1) {
                        ((SmartLamb) s).setKelvin(Integer.parseInt(kelvin));
                        ((SmartLamb) s).setBrightness(Integer.parseInt(brightness));
                        tukendim = true;
                        break;
                    }
                }
            }
        }
        if (type && !range) {
            System.out.println("ERROR: Kelvin value must be in range of 2000K-6500K!");
        } else if (range && !tukendim ) {
            System.out.println("ERROR: Brightness must be in range of 0%-100%!");
        } else if (!type) {
            System.out.println("ERROR: This device is not a smart lamp!");
        }
    }
    public static void setColorTwo(String name, String color, String brightness){
        String regex = "^0x[0-9A-Fa-f]+$";
        boolean type = false;
        boolean range = false;
        boolean tukendim = false;
        for (SmartDevices s : Add.akilli_alet) {
            boolean b =color.matches(regex) && color.length() < 9 ;
            boolean b1 = Integer.parseInt(brightness) >= 0 && Integer.parseInt(brightness) <= 100;
            if (s.getName().equals(name) && s.getType().equals("SmartColorLamp")){
                type = true;
                if (b) {
                    range = true;
                    if (b1) {
                        ((SmartCLamb) s).setKelvin(color);
                        ((SmartCLamb) s).setBrightness(Integer.parseInt(brightness));
                        tukendim = true;
                        break;
                    }
                }
            }
        }
        if (type && !range) {
            System.out.println("ERROR: Erroneous command!");
        } else if (range && !tukendim ) {
            System.out.println("ERROR: Brightness must be in range of 0%-100%!");
        } else if (!type) {
            System.out.println("ERROR: This device is not a smart color lamp!");
        }
    }
}
