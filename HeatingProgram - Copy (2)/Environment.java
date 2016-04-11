//------------------------------------------------
// This class contains the functions required to
// set and retrieve the environment temperature
//------------------------------------------------
public class Environment
{
    private double outTemp = 10.0;       
    //---------------------------------------
    // Set temperature for environment
    //---------------------------------------    
    public void setTemp(double temp)
    {
        outTemp = temp;
    }
    //---------------------------------------
    // get temperature of environment
    //---------------------------------------        
    public double getTemp(double temp)
    {
        return temp;
    }
}
