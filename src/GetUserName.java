import java.util.Scanner;

public class GetUserName {
    public static void main(String[] args) {
        String name = "";
        Scanner in = new Scanner(System.in);
        name = SafeInput.getNonZeroLenString(in,"Please enter your name: ");
        System.out.println("Your name is: " + name);
    }
}
