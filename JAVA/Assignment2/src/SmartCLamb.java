public class SmartCLamb extends SmartDevices{
    private String kelvin;
    private int brightness;
    public SmartCLamb(String type,String name, String status, String kelvin, int brightness,String switchtime){
        super(type, name, status, switchtime);
        this.kelvin = kelvin;
        this.brightness = brightness;
    }
    public void setKelvin(String kelvin){
        this.kelvin = kelvin;
    }
    public String getKelvin(){
        return kelvin;
    }
    public void setBrightness(int brightness){
        this.brightness = brightness;
    }
    public int getBrightness(){
        return brightness;
    }
    @Override
    public String toString() {
        return String.format("Smart Lamp %s is %s and its color value is %sK with %d%% brightness," +
                " and its time to switch its status is %s."
                ,getName(),getStatus(),getKelvin(),getBrightness(),getSwitchTime());
    }
}
