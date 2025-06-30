import java.util.Scanner;

public class UsingStaticMethods {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // get a user's name:
         GetName(in);

        // get a favorite number:
         GetFavNumber(in);

        // get birth time:
         GetBirthDateTime(in);

        // check out items:
         Checkout(in);

        SafeInput.prettyHeader("This is a pretty header!");

        SafeInput.getRegExString(in, "Enter your ssn [000-00-0000]: ", "^\\d{3}-\\d{2}-\\d{4}$");
        SafeInput.getRegExString(in, "Enter your UC Student M number [M00000]: ", "^(M|m)\\d{5}$");
        SafeInput.getRegExString(in, "Enter a menu choice [OoSsVvQq]: ", "^[OoSsVvQq]$");

    }

    public static void GetName(Scanner in) {
        String name = SafeInput.getNonZeroLenString(in,"Please enter your full name: ");
        System.out.println("Your name is: " + name);
    }

    public static void GetFavNumber(Scanner in) {
        int favInt = SafeInput.getInt(in, "Enter your favorite integer: ");
        double favDouble = SafeInput.getDouble(in, "Enter your favorite double: ");
        System.out.println("Your favorite integer is: " + favInt);
        System.out.println("Your favorite double is: " + favDouble);
    }

    public static void GetBirthDateTime(Scanner in) {

        //Use the getRangedInt method to input the year (1950-2015), month (1-12), Day*, hours (1 – 24), Minutes (1-59) of a person’s birth.
        // Note: use a switch() conditional selector structure to limit the user to the correct number of days for the month they were born in.
        // For instance if they were born in Feb [1-29], Oct [1-31].
        // HINT: there are only 3 groups here not 12 different ones!
        int birthDay = 0;
        int birthYear = SafeInput.getRangedInt(in, "Enter the year of your birth [1950-2015]: ", 1950, 2015);
        int birthMonth = SafeInput.getRangedInt(in, "Enter the month of your birth [1-12]: ", 1, 12);
        birthDay = switch (birthMonth) {
            case 1, 3, 5, 7, 8, 10, 12 -> SafeInput.getRangedInt(in, "Enter the day of your birth [1-31]: ", 1, 31);
            case 4, 6, 9, 11 -> SafeInput.getRangedInt(in, "Enter the day of your birth [1-30]: ", 1, 30);
            case 2 -> SafeInput.getRangedInt(in, "Enter the day of your birth [1-29]: ", 1, 29);
            default -> birthDay;
        };
        int birthHour = SafeInput.getRangedInt(in, "Enter the hour of your birth [1-24]: ", 1, 24);
        int birthMinute = SafeInput.getRangedInt(in, "Enter the minute of your birth [1-59]: ", 1, 59);
        System.out.printf("You were born on %d/%d/%d at %d:%d.\n", birthMonth, birthDay, birthYear, birthHour, birthMinute);
    }

    public static void Checkout(Scanner in) {
        //At the 10$ store nothing is more than $10.00.
        // Prompt the user for the price of their item (.50 cents to $10.00 dollars)
        // using the getRangedDouble method and continue to input items
        // as long as they indicate that they have more using your getYNConfirm method.
        // Display the total cost of the item(s) to 2 decimal places with printf.
        double itemPrice;
        double totalCost = 0;
        boolean hadMoreItems;

        do {
            itemPrice = SafeInput.getRangedDouble(in, "Enter the price of your item: ", 0.50, 10.00);
            totalCost += itemPrice;
            in.nextLine();
            hadMoreItems = SafeInput.getYNConfirm(in, "Do you have more items? (y/n): ");
        } while (hadMoreItems);
        System.out.printf("The total cost of your items is $%.2f\n", totalCost);
    }
}
