import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Objects;

public class Add {
    static ArrayList<SmartDevices> akilli_alet = new ArrayList<>();

    public static void addPlug(String[] arr) {
        String type = arr[1];
        String name = arr[2];
        String status;
        String ampere;
        String starttime = null;
        String swicthTime = null;
        try {
            status = arr[3];
        } catch (Exception e) {
            status = "Off";
        }
        try {
            ampere = arr[4];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
            String formattedTime = formatter.format(TimeCont.initialTime);
            starttime = formattedTime;
        } catch (Exception e) {
            ampere = null;
        }
        boolean check = true;
        if ((status.equals("On") || (status.equals("Off")))) {
            try {
                if (ampere == null || Float.parseFloat(ampere) > 0) {
                    if (akilli_alet.size() == 0) {
                        akilli_alet.add(new SmartPlug(type, name, status, ampere,starttime,swicthTime));
                        check = false;
                    } else {
                        for (SmartDevices s : akilli_alet) {
                            if (s.getName().equals(name)) {
                                check = false;
                                System.out.println("ERROR: There is already a smart device with same name!");
                                break;
                            }
                        }
                    }
                } else if (Float.parseFloat(ampere) <= 0) {
                    System.out.println("ERROR: Ampere value must be a positive number!");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("ERROR: Erroneous command!");
                check = false;
            }
        } else {
            System.out.println("ERROR: Erroneous command!");
            check = false;
        }
        if (check == true) {
            akilli_alet.add(new SmartPlug(type, name, status, ampere,starttime,swicthTime));
        }
    }

    public static void addCamera(String[] arr) {
        String type = arr[1];
        String name = arr[2];
        String status;
        Float megabyte = 0f;
        String starttime = null;
        String switchtime = null;
        try {
            megabyte = Float.parseFloat(arr[3]);
            try {
                status = arr[4];
                if (status.equals("On")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
                    String formattedTime = formatter.format(TimeCont.initialTime);
                    starttime = formattedTime;
                }
            } catch (Exception e) {
                status = "Off";
            }
            boolean check = true;
                if ((status.equals("On") || (status.equals("Off")))) {
                    if (megabyte > 0) {
                    if (akilli_alet.size() == 0) {
                        akilli_alet.add(new SmartCamera(type, name, megabyte, status,starttime,switchtime));
                        check = false;
                    } else {
                        for (SmartDevices s : akilli_alet) {
                            if (s.getName().equals(name)) {
                                check = false;
                                System.out.println("ERROR: There is already a smart device with same name!");
                                break;
                            }
                        }
                    }
                }
                    else {
                        System.out.println("ERROR: Megabyte value must be a positive number!");
                        check = false;
                        }
                }
                else {
                    System.out.println("ERROR: Erroneous command!");
                    check = false;
                    }
            if (check == true) {
                akilli_alet.add(new SmartCamera(type, name, megabyte, status,starttime,switchtime));
            }
        }catch (Exception e) {
            System.out.println("ERROR: Erroneous command!");
        }
    }

    public static void addLamp(String[] arr) {
        String type = arr[1];
        String name = arr[2];
        String status;
        int kelvin;
        int brightness;
        String switchtime = null;
        try {
            status = arr[3];
        } catch (Exception e) {
            status = "Off";
        }
        try {
            kelvin = Integer.parseInt(arr[4]);
        } catch (Exception e) {
            kelvin = 4000;
        }
        try {
            brightness = Integer.parseInt(arr[5]);
        } catch (Exception e) {
            brightness = 100;
        }
        boolean check = true;
        if ((status.equals("On") || (status.equals("Off")))) {
            if (kelvin <= 6500 && kelvin >= 2000) {
                if (brightness >= 0 && brightness <= 100) {
                    if (akilli_alet.size() == 0) {
                        akilli_alet.add(new SmartLamb(type, name, status, kelvin, brightness,switchtime));
                        check = false;
                    } else {
                        for (SmartDevices s : akilli_alet) {
                            if (s.getName().equals(name)) {
                                check =false;
                                System.out.println("ERROR: There is already a smart device with same name!");
                                break;
                            }
                        }
                    }
                }
                else{
                    System.out.println("ERROR: Brightness must be in range of 0%-100%!");
                    check =false;
                    }
                }
            else {
                System.out.println("ERROR: Kelvin value must be in range of 2000K-6500K!");
                check =false;
                }
        }
        else {
            System.out.println("ERROR: Erroneous command!");
            check =false;
        }
        if (check == true){
            akilli_alet.add(new SmartLamb(type, name, status, kelvin, brightness,switchtime));
        }
    }
    public static void addCLamp(String[] arr) {
        String type = arr[1];
        String name = arr[2];
        String status;
        String kelvin = null;
        int brightness;
        boolean kelvincheck = false;
        String switchtime = null;
        try {
            status = arr[3];
        } catch (Exception e) {
            status = "Off";
        }
        if (arr.length == 3 || arr.length == 4){
            kelvin = "4000";
            kelvincheck = true;
        }else{
            try {
                String regex = "^0x[0-9A-Fa-f]+$";
                if (arr[4].matches(regex) && arr[4].length()<9){
                    kelvin = arr[4];
                    kelvincheck = true;
                }
                else if (arr[4].matches(regex) && arr[4].length()>8) {
                    System.out.println("ERROR: Color code value must be in range of 0x0-0xFFFFFF!");
                }
                else if(Integer.parseInt(arr[4])>=2000 && Integer.parseInt(arr[4])<=6500){
                    kelvin = arr[4];
                    kelvincheck = true;
                }
                else if (Integer.parseInt(arr[4])<2000 && Integer.parseInt(arr[4])>6500) {
                    System.out.println("ERROR: Kelvin value must be in range of 2000K-6500K");
                }
            } catch (Exception e) {
                System.out.println("ERROR: Erroneous command!");
            }
        }
        try {
            brightness = Integer.parseInt(arr[5]);
        } catch (Exception e) {
            System.out.println(name + name + name);
            brightness = 100;
            kelvincheck = true;
        }
        boolean check = true;
        if ((status.equals("On") || (status.equals("Off")))) {
            if (brightness >= 0 && brightness <= 100) {
                if (akilli_alet.size() == 0) {
                    akilli_alet.add(new SmartCLamb(type, name, status, kelvin, brightness,switchtime));
                    check = false;
                } else {
                    for (SmartDevices s : akilli_alet) {
                        if (s.getName().equals(name)) {
                            check = false;
                            System.out.println("ERROR: There is already a smart device with same name!");
                            break;
                        }
                    }
                }
            } else {
                System.out.println("ERROR: Brightness must be in range of 0%-100%!");
                check = false;
            }
        } else {
            System.out.println("ERROR: Erroneous command!");
            check = false;
        }
        if (check == true && kelvincheck == true) {
            akilli_alet.add(new SmartCLamb(type, name, status, kelvin, brightness,switchtime));
        }
    }
}