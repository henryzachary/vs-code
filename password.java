import java.util.Scanner;

public class PasswordValidator { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter password: "); 
        String password = scanner.nextLine(); 
        
        if (isValidPassword(password)) { // check if password is valid using isValidPassword method
            System.out.println("User password is valid"); 
        } else { // if password is not valid
            System.out.println("User password is invalid"); 
        }
        
        scanner.close(); 
    }
    
    public static boolean isValidPassword(String password) { // method to validate password
        // check if password length is between 8 and 16, inclusive
        if (password.length() < 8 || password.length() > 16) { // if password length is out of range
            return false; // return false if password is invalid
        }
        
        // check if the password contains at least three out of four categories
        int NumOfCategories = 0; // count number of categories
        if (password.matches("*[a-z]*")) { // if password contains lowercase letters
            NumOfCategories++; // increment NumOfCategories
        }
        if (password.matches(".*[A-Z].*")) { // if password contains uppercase letters
            NumOfCategories++; // increment NumOfCategories
        }
        if (password.matches(".*[0-9].*")) { // if password contains numbers
            NumOfCategories++; // increment NumOfCategories
        }
        if (password.matches(".*[~!@#$%^&*()-=+_].*")) { // if password contains special symbols
            NumOfCategories++; // increment NumOfCategories
        }
        
        return NumOfCategories >= 3; // return true if at least three categories are present, false otherwise
    }
}
