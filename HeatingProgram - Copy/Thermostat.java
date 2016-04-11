public class Thermostat
{
    private double thermosetting;
    private double overheat;
    //---------------------------------------
    // Set temperature for thermostat
    //---------------------------------------
    public void setTemp(double temp)
    {
        thermosetting = temp;
    }
    //---------------------------------------
    // Set overheat temperature
    //---------------------------------------    
    public void setOverheat(double heat)
    {
        overheat = heat;
    }
    //---------------------------------------
    // Get thermostat temperature
    //---------------------------------------    
    public double getTemp()
    {
        return thermosetting;
    }
    //---------------------------------------
    // Get overheat temperature
    //---------------------------------------    
    public double getOverheat()
    {
        return overheat;
    }
}
