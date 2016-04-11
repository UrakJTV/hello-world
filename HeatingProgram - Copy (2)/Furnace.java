//-------------------------------------------------------------
// This class contains the functions required to heat the room 
// and set the furnace attributes
//-------------------------------------------------------------
public class Furnace
{
    private String furnaceType;
    private double yearBuilt;
    private double capacity;
    private double efficiency;
    private boolean pilotLight;
    private boolean heating;

    //---------------------------------------------
    // Sets the heat output produced by the furnace
    //---------------------------------------------    
    public double calcHeatOut(double area, double cap, int year)
    {
        yearBuilt = year;
        // Compare the year and area in order to set output capacity
        if(yearBuilt > 1980 && (area >= 0 && area < 1300.00))
        {
            capacity = 40000.00;
        }
        else if(yearBuilt > 1980 && (area >= 1300.00 && area < 1700.00))
        {
            capacity = 45000.00;
        }
        else if(yearBuilt > 1980 && (area >= 1700.00 && area < 2500.00))
        {
            capacity = 50000.00;
        }
        else if(yearBuilt > 1980 && (area >= 2500.00 && area < 3500.00))
        {
            capacity = 60000.00;
        }
        else if(yearBuilt > 1980 && (area >= 3500.00 && area < 4500.00))
        {
            capacity = 70000.00;
        }        
        else if(yearBuilt <= 1980 && (area >= 0 && area < 1300.00))
        {
            capacity = 50000.00;
        }
        else if(yearBuilt <= 1980 && (area >= 1300.00 && area < 1700.00))
        {
            capacity = 55000.00;
        }
        else if(yearBuilt <= 1980 && (area >= 1700.00 && area < 2500.00))
        {
            capacity = 65000.00;
        }
        else if(yearBuilt <= 1980 && (area >= 2500.00 && area < 3500.00))
        {
            capacity = 80000.00;
        }
        else if(yearBuilt <= 1980 && (area >= 3500.00 && area < 4500.00))
        {
            capacity = 100000.00;
        }
        
        return capacity;
    }
    //--------------------------------------------
    // heat the room an return the new temperature
    //--------------------------------------------    
    public double heatRoom(double in, double out, double area, double cap, double time)
    {
        LivingArea room = new LivingArea(); 
        double roomTemp = 0;
        double heatGain;
        double heatLoss;
        double SHC = room.getSHC();
        
        heatGain = cap * (time / 3600); // calculate heat gain
        heatLoss = area * (in - out) * (time / 3600); // calculate heat lost
        roomTemp = (heatGain - heatLoss) / (SHC * area) + in; // compute new room temperature

        return roomTemp;
    }
    //---------------------------------------------------------------
    // decrease the temperature of the room when the furnce turns off
    //---------------------------------------------------------------    
    public double stopHeat(double in, double out, double area, double time)
    {
        LivingArea room = new LivingArea(); 
        double roomTemp = 0;
        double heatLoss;
        double SHC = room.getSHC();
        
        heatLoss = area * (in - out) * (time / 3600); // calculate heat loss
        roomTemp = in - (heatLoss / (SHC * area));    // compute new room temperature
        
        return roomTemp;
    }

    public void setFurnaceType(String type)
    {
        furnaceType = type;
    }

    public void furnaceOn()
    {
        pilotLight = true;
    }
  
    public void furnaceOff()
    {
        pilotLight = false;
    }
 
    public void setEfficiency(String type)
    {
        if(type.equals("gas")){
            efficiency = 0.9;
        }
        else if(type.equals("electric")){
            efficiency = 0.92;
        }
    }
 
    public double getEfficiency()
    {
        return efficiency;
    }
 
    public String getFurnaceType()
    {
        return furnaceType;
    }
}
