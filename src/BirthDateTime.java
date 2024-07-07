import java.util.Scanner;

public class BirthDateTime {
    public static void main(String[] args) {
    //Use the getRangedInt method to input the year (1950-2015), month (1-12), Day*, hours (1 – 24), Minutes (1-59) of a person’s birth. Note: use a switch() conditional selector structure to limit the user to the correct number of days for the month they were born in. For instance if they were born in Feb [1-29], Oct [1-31].  HINT: there are only 3 groups here not 12 different ones!
        Scanner in = new Scanner(System.in);
        int birthYear = 0;
        int birthMonth = 0;
        int birthDay = 0;
        int birthHour = 0;
        int birthMinute = 0;
        birthYear = SafeInput.getRangedInt(in, "Enter the year of your birth [1950-2015]: ", 1950, 2015);
        birthMonth = SafeInput.getRangedInt(in, "Enter the month of your birth [1-12]: ", 1, 12);
        switch (birthMonth) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                birthDay = SafeInput.getRangedInt(in, "Enter the day of your birth [1-31]: ", 1, 31);
                break;
            case 4: case 6: case 9: case 11:
                birthDay = SafeInput.getRangedInt(in, "Enter the day of your birth [1-30]: ", 1, 30);
                break;
            case 2:
                birthDay = SafeInput.getRangedInt(in, "Enter the day of your birth [1-29]: ", 1, 29);
                break;
        }
        birthHour = SafeInput.getRangedInt(in, "Enter the hour of your birth [1-24]: ", 1, 24);
        birthMinute = SafeInput.getRangedInt(in, "Enter the minute of your birth [1-59]: ", 1, 59);
        System.out.printf("You were born on %d/%d/%d at %d:%d.\n", birthMonth, birthDay, birthYear, birthHour, birthMinute);
    }
}
