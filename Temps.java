// ************************************************************ // Temps.java // // This program reads in a sequence of hourly temperature // readings (beginning with midnight) and prints the maximum // temperature (along with the hour, on a 24-hour clock, it // occurred) and the minimum temperature (along with the hour // it occurred). // ************************************************************ 
import java.util.Scanner; 
public class Temps 
{ 
    // -------------------------------------------------- 
    // Reads in a sequence of temperatures and finds the
    // maximum and minimum read in. 
    // -------------------------------------------------- 
    public static void main (String[] args) 
    { 
        final int HOURS_PER_DAY = 4; 
        int temp;
        int maxTemp = -1000;
        int timeOfMax = 0;
        int minTemp = 1000;
        int timeOfMin = 0;
        // a temperature reading 
        Scanner scan = new Scanner(System.in); 
        // print program heading 
        System.out.println ();
        System.out.println ("Temperature Readings for 24 Hour Period"); System.out.println ();
        for (int hour = 0; hour < HOURS_PER_DAY; hour++) 
        { 
            System.out.print ("Enter the temperature reading at " + hour + " hours: "); 
            temp = scan.nextInt(); 
            
            if(temp > maxTemp)
            {
                maxTemp = temp;
                timeOfMax = hour;
            }
            if(temp < minTemp)
            {
                minTemp = temp;
                timeOfMin = hour;
            }
        }
        // Print the results
        System.out.println ();
        System.out.println("The maximum temperature for the day was: " + maxTemp);
        System.out.println("The maximum temperature occurred during hour: " + timeOfMax);
        
        System.out.println ();
        System.out.println("The minimum temperature for the day was: " + minTemp);
        System.out.println("The minimum temperature occurred during hour: " + timeOfMin);
    } 
}
