import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {
        String text = "";
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("input text: ");
        text = in.nextLine();

        in.close();
        
        
        StringBuilder reverseText = new StringBuilder(text);
        reverseText.reverse();
        
        System.out.println(reverseText);
    }
}