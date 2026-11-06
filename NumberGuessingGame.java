import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Pick a secret number from 1 to 100.
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;

        System.out.println("I'm thinking of a number from 1 to 100.");

        while (true) {
            System.out.print("Enter your guess: ");

            // Make sure the player entered a whole number.
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a whole number.");
                scanner.next(); // Discard the invalid input.
                continue;
            }

            int guess = scanner.nextInt();

            // Keep guesses within the allowed range.
            if (guess < 1 || guess > 100) {
                System.out.println("Choose a number between 1 and 100.");
                continue;
            }

            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Correct! You guessed it in " + attempts + " tries.");
                break;
            }
        }

        scanner.close();
    }
}