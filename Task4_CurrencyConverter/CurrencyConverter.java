import java.util.Scanner;

// Task 4 - Currency Converter
// Converts between a few currencies using fixed (predefined) exchange rates.
public class CurrencyConverter {

    static final String[] CODES = {"USD", "INR", "EUR", "GBP", "JPY"};

    // How much of each currency you get for 1 USD (approximate, fixed rates)
    static final double[] RATE_PER_USD = {1.0, 83.0, 0.92, 0.79, 150.0};

    static void showCurrencies() {
        System.out.println("Available currencies:");
        for (int i = 0; i < CODES.length; i++) {
            System.out.println((i + 1) + ". " + CODES[i]);
        }
    }

    static int chooseCurrency(Scanner sc, String label) {
        while (true) {
            System.out.print("Select " + label + " currency (1-" + CODES.length + "): ");
            String text = sc.next();
            try {
                int choice = Integer.parseInt(text);
                if (choice >= 1 && choice <= CODES.length) {
                    return choice - 1;
                }
            } catch (NumberFormatException e) {
                // fall through to the message below
            }
            System.out.println("Invalid choice, try again.");
        }
    }

    static double convert(double amount, int from, int to) {
        double inUsd = amount / RATE_PER_USD[from];   // first convert to USD
        return inUsd * RATE_PER_USD[to];              // then to the target currency
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Currency Converter ===");
        showCurrencies();

        int from = chooseCurrency(sc, "base");
        int to = chooseCurrency(sc, "target");

        double amount;
        while (true) {
            System.out.print("Enter amount in " + CODES[from] + ": ");
            String text = sc.next();
            try {
                amount = Double.parseDouble(text);
                if (amount >= 0) break;
                System.out.println("Amount cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
            }
        }

        double result = convert(amount, from, to);
        System.out.printf("%.2f %s = %.2f %s%n", amount, CODES[from], result, CODES[to]);
        sc.close();
    }
}
