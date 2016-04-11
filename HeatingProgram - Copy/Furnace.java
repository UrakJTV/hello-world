
public class Furnace
{
    private String furnaceType;
    private double yearBuilt;
    private double capacity;
    private double efficiency;
    private boolean pilotLight;
    private boolean heating;
    private double SHC = 4.0;
    private double BLC = 1.0;
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
        double roomTemp = 0;
        double heatGain;
        double heatLoss;
        
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
        double roomTemp = 0;
        double heatLoss;
        
        heatLoss = area * (in - out) * (time / 3600); // calculate heat loss
        roomTemp = in - (heatLoss / (SHC * area));    // compute new room temperature
        
        return roomTemp;
    }
}
