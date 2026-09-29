import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Task 5 - Password Generator
// Makes a random password with uppercase, lowercase, digits and symbols.
public class PasswordGenerator {

    static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    static final String DIGITS = "0123456789";
    static final String SPECIAL = "!@#$%^&*()-_=+?";

    static final SecureRandom random = new SecureRandom();

    static char pick(String chars) {
        return chars.charAt(random.nextInt(chars.length()));
    }

    static String generate(int length) {
        ArrayList<Character> pass = new ArrayList<>();

        // make sure there's at least one of each type
        pass.add(pick(UPPER));
        pass.add(pick(LOWER));
        pass.add(pick(DIGITS));
        pass.add(pick(SPECIAL));

        // fill the remaining spots from all characters together
        String all = UPPER + LOWER + DIGITS + SPECIAL;
        while (pass.size() < length) {
            pass.add(pick(all));
        }

        // shuffle so the first 4 characters aren't always in the same pattern
        Collections.shuffle(pass, random);

        StringBuilder sb = new StringBuilder();
        for (char c : pass) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Password Generator ===");

        int length;
        while (true) {
            System.out.print("Enter password length (minimum 4): ");
            String text = sc.next();
            try {
                length = Integer.parseInt(text);
                if (length >= 4 && length <= 128) break;
                System.out.println("Length must be between 4 and 128.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        System.out.println("Your password: " + generate(length));
        sc.close();
    }
}
