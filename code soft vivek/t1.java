import java.util.Scanner;
import java.util.Random;

public class t1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 7; // Set maximum attempts
            boolean numberGuessed = false;

            System.out.println("\nI have generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");

                // Validate input to ensure it's an integer
                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // Discard invalid input
                }
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                    score++;
                    numberGuessed = true;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            if (!numberGuessed) {
                System.out.println("Sorry! You've used all attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("\nYour current score: " + score);

            System.out.print("\nWould you like to play another round? (yes/no): ");
            scanner.nextLine(); // Consume newline left after nextInt()
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nThanks for playing! Your final score is: " + score);
        scanner.close();
    }
}
