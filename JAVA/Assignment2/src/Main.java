import java.io.*;

public class Main {
    public static BufferedWriter writer;
    public static void main(String[] args) throws IOException {
        PrintStream fileout = new PrintStream(new FileOutputStream(args[1]));
        System.setOut(fileout);
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        String firstNonNullLine = null;
        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                firstNonNullLine = line;
                break;
            }
        }
        if (firstNonNullLine != null && firstNonNullLine.split("\t")[0].equals("SetInitialTime")
        &&firstNonNullLine.split("\t").length == 2) {
            readFile(args[0]);
            reader.close();
        } else {
            System.out.println("COMMAND: "+String.join(" ", firstNonNullLine.split("\t")));
            System.out.println("ERROR: First command must be set initial time! Program is going to terminate!");
            reader.close();
        }
    }
    public static void readFile(String dosya){
        try {
            String line;
            Boolean initialTime = true;
            BufferedReader reader = new BufferedReader(new FileReader(dosya));
            String lastline = null;
            boolean lastlineb = true;
                emre:
                while ((line = reader.readLine()) != null) {
                    lastline = line;
                    String[] elements = line.split("\t");
                        switch (elements[0]) {
                            case "SetInitialTime":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                if (initialTime == true) {
                                    try {
                                    TimeCont time = new TimeCont();
                                    time.setInitalTime(elements[1]);
                                    initialTime = false;
                                    }
                                    catch (Exception a){
                                        System.out.println("ERROR: Format of the " +
                                                "initial date is wrong! Program is going to terminate!");
                                        lastlineb = false;
                                        {break emre;}
                                    }
                                }
                                else{System.out.println("ERROR: Erroneous command!");}
                                break;

                            case "Add":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                if (elements[1].equals("SmartPlug")) {
                                    Add.addPlug(elements);
                                }
                                else if (elements[1].equals("SmartLamp")) {
                                    Add.addLamp(elements);
                                }
                                else if (elements[1].equals("SmartCamera")) {
                                    Add.addCamera(elements);
                                }
                                else if (elements[1].equals("SmartColorLamp")) {
                                    Add.addCLamp(elements);
                                }
                                else{System.out.println("ERROR: Erroneous command!");}
                                break;
                            case "PlugIn":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                PlugInOut.plugIn(elements[1],elements[2]);
                                break;
                            case "PlugOut":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                PlugInOut.plugOut(elements[1]);
                                break;
                            case "Remove":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                SettingsDevice.remove(elements[1]);
                                break;
                            case "Switch":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                TimeCont switchD = new TimeCont();
                                switchD.switchDevice(elements[1],elements[2]);
                                break;
                            case "SetSwitchTime":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                TimeCont time = new TimeCont();
                                time.switchedTime(elements[1],elements[2]);
                                break;
                            case "ChangeName":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                try {
                                    SettingsDevice.changeName(elements[1],elements[2]);
                                }catch (Exception e){
                                    System.out.println("ERROR: Erroneous command!");
                                }
                                break;
                            case "SetKelvin":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                SettingsDevice.setKelvinTwo(elements[1],elements[2]);
                                break;
                            case "SetBrightness":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                SettingsDevice.setBrightnessTwo(elements[1],elements[2]);
                                break;
                            case "SetColorCode":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                SettingsDevice.setColorCodeTwo(elements[1],elements[2]);
                                break;
                            case "SetWhite":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                SettingsDevice.setWhiteTwo(elements[1],elements[2],elements[3]);
                                break;
                            case "SetColor":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                SettingsDevice.setColorTwo(elements[1],elements[2],elements[3]);
                                break;
                            case "ZReport":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                SmartDevices.zReport();
                                break;
                            case "Nop":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                TimeCont c = new TimeCont();
                                c.nop();
                                break;
                            case "SetTime":
                                System.out.println("COMMAND: "+ String.join(" ", elements));
                                TimeCont a = new TimeCont();
                                a.setTime(elements[1]);
                                break;
                            case "SkipMinutes":
                                if (elements.length > 2){
                                    System.out.println("COMMAND: "+ String.join(" ", elements));
                                    System.out.println("ERROR: Erroneous command!");
                                }
                                else {
                                    try {
                                        System.out.println("COMMAND: "+ String.join(" ", elements));
                                        TimeCont skip = new TimeCont();
                                        skip.skipTime(Long.parseLong(elements[1]));
                                    } catch (Exception e) {
                                        System.out.println("ERROR: Erroneous command!");
                                    }
                                }
                                break;
                            case "":
                                break;
                            default:
                                System.out.println("ERROR: Erroneous command!");
                                break;
                        }
                }
                if (!lastline.equals("ZReport")&&lastlineb){
                    System.out.println("ZReport:");
                    SmartDevices.zReport();
                }
        }catch (IOException e){e.printStackTrace();}
    }
}
