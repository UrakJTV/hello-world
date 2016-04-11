//------------------------------------------------------
// This class contains the functions required to 
// initialize and retrieve the room attributes
//------------------------------------------------------
public class LivingArea
{
    Thermostat stat;
    private double area;
    private double SHC = 4.0;
    private double BLC = 1.0;
    private double inTemp;
    //---------------------------------------
    // Set temperature for room
    //---------------------------------------
    public void setTemp(double temp)
    {
        inTemp = temp;
    }
    //---------------------------------------
    // Set area for room
    //---------------------------------------    
    public void setArea(double roomArea)
    {
        area = roomArea;
    }
    //---------------------------------------
    // Get SHC
    //---------------------------------------      
    public double getSHC()
    {
        return SHC;
    }
    //---------------------------------------
    // Get BLC
    //---------------------------------------      
    public double getBLC()
    {
        return BLC;
    }
}
