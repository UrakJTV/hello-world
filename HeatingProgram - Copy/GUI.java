import java.text.NumberFormat;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI extends JFrame
{    
    private Furnace furn = new Furnace();
    private String str1, str2, str3, furnaceType, str4, str5, str6, str7, str8, str9, str10, heating;
    private double in = 0, initTemp = 0, out = 0, set = 0; 
    private double cap = 0, eff = 0, size = 0, overheat = 0, freq = 0, length = 0;
    private int yearBuilt = 0;
    private boolean Input1 = false, Input2 = false, Input3 = false, Input4 = false, Input5 = false, Input6 = false; 
    private boolean Input7 = false, Input8 = false, Input9 = false, Input10 = false, Input11 = false;
    private boolean heat = true;
    private JPanel panel; 
    private JButton button1,button2;    
    private JLabel Label1, Label2,Label3,Label4,Label5,Label6;    
    private JLabel Label7, Label8,Label9,Label10,Label11,Label12;
    private JLabel Label13, Label14,Label15,Label16,Label17,Label18;
    private JTextField Text1, Text2, Text3,Text4,Text5,Text6;
    private JTextField Text7, Text8, Text9,Text10,Text11,Text12;
    private JTextField Text13, Text14, Text15,Text16,Text17,Text18;
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;
    //default 350 , 250
       public GUI()
    {
        
        setSize(WIDTH,HEIGHT);//int, int
        setTitle("Report");//string
        setDefaultCloseOperation(EXIT_ON_CLOSE);//int
        setLocation(500, 500); //int, int
        buildPanel();//call the buildpanel method
        add(panel);//add the panel
        
        //displays the window
        setVisible(true); //boolean
        
      
    }
   
    private void buildPanel()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(6,4));
        
        button1= new JButton("Calculate");
        button2= new JButton("Exit");
        
        //format the labels and textboxes
        
        Label1 = new JLabel( "Room Temperature(celsius): ", JLabel.RIGHT);
        Label2 = new JLabel( "Environment Temperature(celius): ", JLabel.RIGHT);
        Label3 = new JLabel( "Thermostat Setting(celsius): ", JLabel.RIGHT);
        Label4 = new JLabel( "Furnace Type(gas or electric): ", JLabel.RIGHT);
        Label5 = new JLabel( "Furnace Capacity(BTUs/hour): ", JLabel.RIGHT);
        Label6 = new JLabel( "Furnace Efficiency: ", JLabel.RIGHT);
        Label7 = new JLabel( "Living Area(Sq Ft): ", JLabel.RIGHT);
        Label8 = new JLabel( "Thermostat Overheat(celsius): ", JLabel.RIGHT);
        Label9 = new JLabel( "Display Frequency(secs): ", JLabel.RIGHT);
        Label10 = new JLabel( "Runtime(secs): ", JLabel.RIGHT);  
        Label11 = new JLabel( "Year Built: ", JLabel.RIGHT);
    
        Text1 = new JTextField (7);
        Text2 = new JTextField (7);
        Text3 = new JTextField (7);
        Text4 = new JTextField (7);
        Text5 = new JTextField (7);
        Text6 = new JTextField (7);
        Text7 = new JTextField (7);
        Text8 = new JTextField (7);
        Text9 = new JTextField (7);
        Text10 = new JTextField (7);
        Text11 = new JTextField (7);
        
        panel.add(Label1);
        panel.add(Text1);   
        panel.add(Label2);
        panel.add(Text2);
        panel.add(Label3);
        panel.add(Text3);
        panel.add(Label4);
        panel.add(Text4);
        panel.add(Label5);
        panel.add(Text5);
        panel.add(Label6);
        panel.add(Text6);        
        panel.add(Label7);
        panel.add(Text7);   
        panel.add(Label8);
        panel.add(Text8);
        panel.add(Label9);
        panel.add(Text9);
        panel.add(Label10);
        panel.add(Text10);
        panel.add(Label11);
        panel.add(Text11);

        button1.addActionListener(new CalculateButtonListener());
        button2.addActionListener( new ExitButtonListener());
        
        panel.add(button1);
        panel.add(button2);
        
    }
        
    private class CalculateButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {                      
           TimerTest tim = new TimerTest(); 
           // get input
           str1 = Text1.getText();
           str2 = Text2.getText();
           str3 = Text3.getText();
           furnaceType = Text4.getText();
           str4 = Text5.getText();
           str5 = Text6.getText();
           str6 = Text7.getText();
           str7 = Text8.getText();
           str8 = Text9.getText();
           str9 = Text10.getText();
           str10 = Text11.getText();
           
           NumberFormat percentFormat = NumberFormat.getPercentInstance();
           percentFormat.setMaximumFractionDigits(1);
                                            
           //This section code handles incorrect input that is entered by the user
           if(furnaceType.equals(""))
           {
               furnaceType = "gas";
               Input11 = true;
            }
           else if(furnaceType.equals("gas") || furnaceType.equals("electric"))
           {               
               Input11 = true;               
            }
           else
           {
               System.out.println("Enter the furnace type you have (gas or electric). \n");
               Text4.setText("");
               Input11 = false;
            }
            
           try{               
               in = Double.parseDouble(str1);
               Input1 = true;
               }
           catch(NumberFormatException inExc){ 
               // default value for empty parameters
               if(str1.equals("")){
                   in = 22.00;
                   Input1 = true;}
               else{
                   System.out.println("Please enter a valid room temperature value. \n");
                   Text1.setText("");
                   Input1 = false;
                   }
              
            }
            
           try{
               out = Double.parseDouble(str2);
               Input2 = true;}
           catch(NumberFormatException outExc){
               if(str2.equals("")){
                   out = 10.0;
                   Input2 = true;}
               else{
                   System.out.println("Please enter a valid environment temperature value. \n");
                   Text2.setText("");
                   Input2 = false;
                }
            }
               
            try{
                set = Double.parseDouble(str3);
                Input3 = true;}
           catch(NumberFormatException setExc){               
               if(str3.equals("")){
               set = 22.0;
               Input3 = true;}
               else{
                   System.out.println("Please enter a valid thermostat value. \n");
                   Text3.setText("");
                   Input3 = false;
                }
            }
               
           try{
               cap = Double.parseDouble(str4);
               Input4 = true;
            }
           catch(NumberFormatException capExc){
               if(str4.equals("")){
                   cap = 50000.0;
                   Input4 = true;}
               else{
                   System.out.println("Please enter a valid capicity for the furnace (40000-150000). \n");
                   Text5.setText("");
                   Input4 = false;
                   }
            }
               
           try{
               eff = Double.parseDouble(str5);
               Input5 = true;
               if(furnaceType.equals("gas") && eff != 0.9) {
                   System.out.println("Please enter an efficiency value of 0.9 for your gas furnace. \n");
                   Text6.setText("");
                   Input5 = false;
                   }
               else if(furnaceType.equals("electric") && eff != 0.92){
                   System.out.println("Please enter an efficiency value of 0.92 for your electric furnace. \n");
                   Text6.setText("");
                   Input5 = false;
                }
            }
           catch(NumberFormatException effExc){
               if(str5.equals("")){
                eff = 0.9;
                Input5 = true;}
               else {
                   System.out.println("Please enter a valid efficiency value (gas = 0.90 electric = 0.92). \n");
                   Text6.setText("");
                   Input5 = false;
                   }
            } 
            
           try{    
               size = Double.parseDouble(str6);
               Input6 = true;}
           catch(NumberFormatException sizeExc){
               if(str6.equals("")){
                   size = 2000.0;
                   Input6 = true;}
               else{
                   System.out.println("Please enter a valid room area (0-4500). \n");
                   Text7.setText("");
                   Input6 = false;
                   }    
            } 
            
           try{    
               overheat = Double.parseDouble(str7);
               Input7 = true;}
           catch(NumberFormatException overheatExc){
               if(str7.equals("")){
                   overheat = 2.0;
                   Input7 = true;}
               else{
                   System.out.println("Please enter a postive overheat. \n");
                   Text8.setText("");
                   Input7 = false;
                   }    
            } 
            
           try{
               freq = Double.parseDouble(str8);
               Input8 = true;}
           catch(NumberFormatException freqExc){
               if(str8.equals("")){
                   freq = 5;
                   Input8 = true;}
               else{
                   System.out.println("Please enter a postive frequency value. \n");
                   Text9.setText("");
                   Input8 = false;
                   }    
            }  
            
           try{
               length = Double.parseDouble(str9);
               Input9 = true;}
           catch(NumberFormatException lengthExc){
               if(str9.equals("")){
                   length = 7200;
                   Input9 = true;}
               else{
                   System.out.println("Please enter a positive runtime value. \n");
                   Text10.setText("");
                   Input9 = false;
                   }    
            }   
            
           try{
               yearBuilt = Integer.parseInt(str10);
               Input10 = true;}
           catch(NumberFormatException yearBuiltExc){
               if(str10.equals("")){
                   yearBuilt = 2005;
                   Input10 = true;}
               else{
                   System.out.println("Please enter a valid year value. \n");
                   Text11.setText("");
                   Input10 = false;
                   }
            }
        
           // If there is no incorrect input the program will run and display input onto the screen and file 
           if(Input1 && Input2 && Input3 && Input4 && Input5 && Input6 && Input7 && Input8 && Input9 && Input10 && Input11){
              
               if(in < set)
               {
                   heating = "true";
               }
               else
               {
                   heating = "false";
               }
               // Format starting settings in text window 
               System.out.printf("%s %-20.1f %s %-10s %s %-7s %s %-7s %s %-7s %n", "Furnace: capacity =", cap, "Efficiency =", percentFormat.format(eff), "pilot on =", "true", "heating =", heating, "type = ", furnaceType);
               System.out.printf("%s %-5d %s %-6.1f %s %-9.1f %s %-12.1f %s %-7.1f %n", "Room  Year Built:", yearBuilt, "Temperature =", in, "Area (Sq ft)=", size, "SHC =", 4.0, "BLC =", 1.0);
               System.out.println("Environment:   Temperature = " + out);
               System.out.println("Thermostat:    Setting = " + set + "   Overheat = " + overheat);
               System.out.println("Starting simulation:       Display frequency (secs) = " + freq + "   Runtime (sec): " + length + "\n");
               System.out.printf("%-18s %-18s %-18s %-18s %n", "Time", "Inside", "Outside", "Furnace Status");
               System.out.printf("%-18s %-18s %-18s %-18s %n", "----------", "----------", "----------", "---------------");
               //System.out.printf("%-18d %-18.2f %-18.2f %-18s %n", 0, in, out, "off");
               //initTemp = in;
               cap = furn.calcHeatOut(size, cap, yearBuilt);
               cap *= eff;
               tim.timerStart();
               
               //Call all the methods 
           // calculate and print into the forms
           // print into a textfile
           }
        }
    }    

    private class ExitButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // Exit the application.
          System.exit(0);
      }
   }
   public class TimerTest 
   {
    private Timer timer1;
    private int time = 0;
    private  final int TIMER_DELAY = 300;
     
    public void timerStart()
    {
        timer1 = new Timer(TIMER_DELAY * (int)freq, new TimerTestListener());       
        timer1.start();           
    }
    
    private class TimerTestListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {                           
            if (time <= length) // to control the number of times the action is performed
            {
            // determines when to heat the room
            if(in >= set && in <= (set + overheat) && heat != false)
            {                 
                System.out.printf("%-18d %-18.2f %-18.2f %-18s %n", time, in, out, "On");
                in = furn.heatRoom(in, out, size, cap, (double)TIMER_DELAY);
            }
            else if(in < set && heat == false)
            {
                System.out.printf("%-18d %-18.2f %-18.2f %-18s %n", time, in, out, "On");
                in = furn.heatRoom(in, out, size, cap, (double)TIMER_DELAY);
                heat = true; 
            }
            else
            {
                heat = false;
            }
            // determines when to stop heating the room
            if(heat == false)
            {                
                System.out.printf("%-18d %-18.2f %-18.2f %-18s %n", time, in, out, "Off");
                in = furn.stopHeat(in, out, size, (double)TIMER_DELAY);
                //heat = false;
            }
            // increment time
            time += TIMER_DELAY;    
            }
            else timer1.stop();  // stoping the timer if the condition is met
        }
    }
}   
}

   
   
   


