//must be able to do at least 4 different conversions (the more the better). 
//For example, kg to lb, gram to ounces, km to mile, mm to inch, etc.
//should continue accepting user inputs until the user inputs something like "exit" 
//If a user input something that is not handled, you should print something to remind the user the valid input format, e.g.,

// km to miles  cm to inches kg to lbs 

import java.util.Scanner;
public class conversion {

    public static void main(String[] args) {
        double km, cm, m, mm;
        int convNum, i;
        String userinput = "";

        System.out.println("Welcome to metric distance converter!");        
        
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("How many conversions would you like to make?");
            
            convNum = in.nextInt();
            
            for(i = 0; i<=convNum; i++){
                System.out.println("Please input your query (km, m, cm, mm): ");
   
                userinput = in.nextLine();
            
                switch(userinput){

                case "km":
                System.out.println("Enter the amount you would like to convert: ");
                km = in.nextDouble();
                System.out.println(km + " km is equal to " + (km*0.62137119) + " mi.");       
                break;
                
                case "mm":
                System.out.println("Enter the amount you would like to convert: ");
                mm = in.nextDouble();
                System.out.println(mm + " mm is equal to " + (mm*0.03937008) + " inches.");       
                break;
                
                case "cm":
                System.out.println("Enter the amount you would like to convert: ");
                cm = in.nextDouble();
                System.out.println(cm + " cm is equal to " + (cm*0.39370) + " in.");        
                break;
                
                case "m":
                System.out.println("Enter the amount you would like to convert: ");
                m = in.nextDouble();
                System.out.println(m + " m is equal to " + (m*3.2808399) + " feet."); 
                break;
                
                case "exit":
                in.close();
                break;
                
     
                

            }}
        }
        
        
        



}}


