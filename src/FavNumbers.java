import java.util.Scanner;

public class FavNumbers {

    public static void main(String[] args) {
        int favInt = 0;
        double favDouble = 0.0;
        Scanner in = new Scanner(System.in);

        favInt = SafeInput.getInt(in, "Enter your favorite integer: ");
        favDouble = SafeInput.getDouble(in, "Enter your favorite double: ");

        System.out.println("Your favorite integer is: " + favInt);
        System.out.println("Your favorite double is: " + favDouble);

    }
}
