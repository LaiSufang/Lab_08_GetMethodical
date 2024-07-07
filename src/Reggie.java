import java.util.Scanner;

public class Reggie {
    public static void main(String[] args) {
//Use your getRegExString method several times.
//- get a SSN from the user using this pattern: ^\\d{3}-\\d{2}-\\d{4}$
//- get a UC Student M number using this pattern ^(M|m)\\d{5}$
//-get a menu choice using this pattern ^[OoSsVvQq]$
//these letters are mnemonics for the menu choices Open Save View Quit
//
//Do several test runs FOR EACH PATTERN with strings that match and fail.
        Scanner in = new Scanner(System.in);
        SafeInput.getRegExString(in, "Enter your ssn [000-00-0000]: ", "^\\d{3}-\\d{2}-\\d{4}$");
        SafeInput.getRegExString(in, "Enter your UC Student M number [M00000]: ", "^(M|m)\\d{5}$");
        SafeInput.getRegExString(in, "Enter a menu choice [OoSsVvQq]: ", "^[OoSsVvQq]$");



    }
}
