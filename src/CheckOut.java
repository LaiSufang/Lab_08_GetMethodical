import java.util.Scanner;

public class CheckOut {
    public static void main(String[] args) {
     //At the 10$ store nothing is more than $10.00.  Prompt the user for the price of their item (.50 cents to $10.00 dollars) using the getRangedDouble method and continue to input items as long as they indicate that they have more using your getYNConfirm method.  Display the total cost of the item(s) to 2 decimal places with printf.
        double itemPrice = 0;
        double totalCost = 0;
        boolean moreItems = false;
        Scanner in = new Scanner(System.in);
        do {
            itemPrice = SafeInput.getRangedDouble(in, "Enter the price of your item: ", 0.50, 10.00);
            totalCost += itemPrice;
            in.nextLine();
            moreItems = SafeInput.getYNConfirm(in, "Do you have more items? (y/n): ");
        } while (moreItems);
        System.out.printf("The total cost of your items is $%.2f\n", totalCost);
    }
}
