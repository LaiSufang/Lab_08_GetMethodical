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

        // get a string using a pattern
        Reggie(in);

        // get a header in a certain format:
        GetPrettyHeader(in);

        // display c to f temp table:
        System.out.println("Celsius     Fahrenheit");
        for (double tempC = -100; tempC <= 100; tempC += 1) {
            System.out.printf("%-8.2f\t%-8.2f\n", tempC,  CtoF(tempC));
        }

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
        int birthYear, birthMonth, birthDay, birthHour, birthMinute;
        birthYear = SafeInput.getRangedInt(in, "Enter the year of your birth [1950-2015]: ", 1950, 2015);
        birthMonth = SafeInput.getRangedInt(in, "Enter the month of your birth [1-12]: ", 1, 12);
        // get the birthDay based on the birthMonth
        birthDay = switch (birthMonth) {
            case 2 -> SafeInput.getRangedInt(in, "Enter the day of your birth [1-29]: ", 1, 29);
            case 4, 6, 9, 11 -> SafeInput.getRangedInt(in, "Enter the day of your birth [1-30]: ", 1, 30);
            // the rest of the months would have 31 days: case 1, 3, 5, 7, 8, 10, 12
            default -> SafeInput.getRangedInt(in, "Enter the day of your birth [1-31]: ", 1, 31);
        };
        birthHour = SafeInput.getRangedInt(in, "Enter the hour of your birth [1-24]: ", 1, 24);
        birthMinute = SafeInput.getRangedInt(in, "Enter the minute of your birth [1-59]: ", 1, 59);
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

    public static void Reggie(Scanner in) {
        String ssn, mNumber, menuChoice;

        ssn = SafeInput.getRegExString(in, "Enter your SSN using this pattern [123-12-1234]: ", "^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println("Your SSN is: " + ssn);

        mNumber = SafeInput.getRegExString(in, "Enter your UC Student M number in this pattern [M12345]: ", "^(M|m)\\d{5}$");
        System.out.printf("Your M number is: %s\n", mNumber);

        menuChoice = SafeInput.getRegExString(in, "Enter a menu choice [OoSsVvQq]: ", "^[OoSsVvQq]$");
        System.out.println("You choice: " + menuChoice);
    }

    private static void GetPrettyHeader(Scanner in) {
        String prettyHeader;
        do {
            prettyHeader = SafeInput.getNonZeroLenString(in, "Please enter your Pretty Header within 30 characters: ");
        } while (prettyHeader.length() > 30);

        SafeInput.prettyHeader(prettyHeader);
    }

    public static double CtoF(double tempC) {
        return (tempC * 9/5) + 32;
    }
}
