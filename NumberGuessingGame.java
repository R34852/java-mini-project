import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        // Game Setup
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = random.nextInt(100) + 1;  // Random number between 1 and 100
        int maxAttempts = 10;
        int[] guesses = new int[maxAttempts];  // Array to store guesses
        int guessCount = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        // Game Loop
        while (guessCount < maxAttempts && !hasGuessedCorrectly) {
            System.out.print("Enter your guess (Attempt " + (guessCount + 1) + " of " + maxAttempts + "): ");
            int playerGuess = scanner.nextInt();

            // Store the guess in the array
            guesses[guessCount] = playerGuess;
            guessCount++;

            // Check if the guess is correct
            if (playerGuess == numberToGuess) {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You guessed the correct number.");
            } else if (playerGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            // Provide feedback on previous guesses
            System.out.print("Previous guesses: ");
            for (int i = 0; i < guessCount; i++) {
                System.out.print(guesses[i] + " ");
            }
            System.out.println();
        }

        // End of Game
        if (!hasGuessedCorrectly) {
            System.out.println("Sorry! You've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess + ".");
        }

        scanner.close();
    }
}
