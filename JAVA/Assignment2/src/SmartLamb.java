public class SmartLamb extends SmartDevices{
    private int kelvin;
    private int brightness;
    public SmartLamb(String type,String name, String status,int kelvin, int brightness, String switchtime){
        super(type,name,status,switchtime);
        this.kelvin = kelvin;
        this.brightness = brightness;
    }
    public void setKelvin(int kelvin){
        this.kelvin = kelvin;
    }
    public int getKelvin(){
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
        return String.format("Smart Lamp %s is %s and its kelvin value is %sK with %d%% brightness," +
                " and its time to switch its status is %s."
                ,getName(),getStatus(),getKelvin(),getBrightness(),getSwitchTime());
    }
}
