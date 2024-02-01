//must be able to do at least 4 different conversions (the more the better). 
//For example, kg to lb, gram to ounces, km to mile, mm to inch, etc.
//should continue accepting user inputs until the user inputs something like "exit" 
//If a user input something that is not handled, you should print something to remind the user the valid input format, e.g.,

// km to miles  cm to inches kg to lbs 

import java.util.Scanner;

public class Conversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the metric conversion program!");

        while (true) {
            System.out.println("\nEnter the conversion you would like to make (km, cm, mm, kg, exit): ");

            
            String choice = scanner.next();

            switch (choice) {
                case "km":
                    System.out.print("Enter kilometers: ");
                    double km = scanner.nextDouble();
                    double miles = km * 0.62137119;
                    System.out.println(km + " km is equal to " + miles + " miles.");
                    break;
                case "cm":
                    System.out.print("Enter centimeters: ");
                    double cm = scanner.nextDouble();
                    double inches = cm * 0.39370;
                    System.out.println(cm + " cm is equal to " + inches + " inches.");
                    break;
                case "kg":
                    System.out.print("Enter kilograms: ");
                    double kg = scanner.nextDouble();
                    double lbs = kg * 2.20462;
                    System.out.println(kg + " kg is equal to " + lbs + " lbs.");
                    break;
                case "mm":
                    System.out.print("Enter millimeters: ");
                    double mm = scanner.nextDouble();
                    double inch = mm * 0.03937008;
                    System.out.println(mm + " mm is equal to " + inch + " inches.");
                    break;
                case "exit" :
                    System.out.println("Goodbye.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}