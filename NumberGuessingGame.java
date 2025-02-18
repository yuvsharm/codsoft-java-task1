import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess;

                // Validate user input
                try {
                    userGuess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please guess a number within the range of 1 to 100.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1); // More points for fewer attempts
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've run out of attempts! The correct number was: " + randomNumber);
            }

            System.out.println("Your current score: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            playAgain = response.equals("yes");
        }

        System.out.println("Thank you for playing! Your final score: " + totalScore);
        scanner.close();
    }
}
