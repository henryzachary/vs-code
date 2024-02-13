import java.util.Scanner; 

public class Fibonacci {
    public static void main(String[] args) {
        int userNum;  
        int num1 = 0; 
        int num2 = 1; 

        Scanner in = new Scanner(System.in); 

        System.out.print("input number: ");
        userNum = in.nextInt(); 

        for (int i = 0; i < userNum; i++) { 
            System.out.print(num1 + " "); 
            int num3 = num1 + num2; 
            num1 = num2; 
            num2 = num3;
        }
    }
}
