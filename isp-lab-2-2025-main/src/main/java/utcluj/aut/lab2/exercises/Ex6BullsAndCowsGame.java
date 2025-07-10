package utcluj.aut.lab2.exercises;
import java.util.Random;
import java.util.Scanner;

/**
 * Class implementing the Bulls and Cows number guessing game.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex6BullsAndCowsGame {
    private final String secretNumber;

    /**
     * Creates a new game with a random secret number.
     */
    public Ex6BullsAndCowsGame() {
        this.secretNumber = generateSecretNumber();
    }

    /**
     * Creates a new game with the specified secret number (for testing).
     *
     * @param secretNumber the secret number to use
     */
    public Ex6BullsAndCowsGame(String secretNumber) {
        this.secretNumber = secretNumber;
    }

    public static boolean contains(int[] array, int size, int value) {
        for(int i = 0; i < size; i++) {
            if(array[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generates a random 4-digit number with no repeated digits.
     *
     * @return a string representing the 4-digit number
     */
    public static String generateSecretNumber() {
        Random random = new Random();
        int[] digits = new int[4];
        int count = 0, number = 0;
        while (count < 4) {
            int digit = random.nextInt(10);
            if (!contains(digits, count, digit)) {
                digits[count] = digit;
                number = number * 10 + digit;
                count++;
            }
        }
        return Integer.toString(number);
    }

    /**
     * Evaluates a guess against the secret number.
     *
     * @param guess the guess to evaluate
     * @return an array with [bulls, cows]
     * @throws IllegalArgumentException if the guess is invalid
     */
    public int[] evaluateGuess(String guess) {
        for(int i = 0; i < guess.length(); i++) {
            if(guess.charAt(i) < 48 || guess.charAt(i) > 57) {
                throw new IllegalArgumentException("Guess should contain only numeric characters!");
            }
        }
        if(guess.length() < 4) {
            throw new IllegalArgumentException("Guess is too short! (Should consist of 4 digits)");
        } else if(guess.length() > 4) {
            throw new IllegalArgumentException("Guess is too long! (Should consist of 4 digits)");
        }
        for(int i = 0; i < guess.length(); i++) {
            for(int j = i + 1; j < guess.length(); j++) {
                if(guess.charAt(i) == guess.charAt(j)) {
                    throw new IllegalArgumentException("Guess should contain non repeating digits!");
                }
            }
        }

        int[] bullsAndCows = new int[2];
        for(int i = 0; i < guess.length(); i++) {
            if(secretNumber.charAt(i) == guess.charAt(i)) {
                bullsAndCows[0]++;
            } else {
                for(int j = 0; j < guess.length(); j++) {
                    if(guess.charAt(i) == secretNumber.charAt(j)) {
                        bullsAndCows[1]++;
                        break;
                    }
                }
            }
        }
        return bullsAndCows;
    }

    /**
     * Plays the game with a predetermined list of guesses (for testing).
     *
     * @param guesses the list of guesses to try
     * @return the number of attempts needed to guess correctly
     */
    public int playTestGame(String[] guesses) {
        int attempts = 0;
        for(String guess : guesses) {
            attempts++;
            if(evaluateGuess(guess)[0] == 4) {
                return attempts;
            }
        }
        return guesses.length;
    }

    /**
     * Plays an interactive game with user input.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your guess (4 digits number, all different): ");
        int attempts = 0;
        while(true) {
            attempts++;
            String guess = scanner.nextLine();
            int[] evaluation = evaluateGuess(guess);
            if(evaluation[0] == 4) {
                break;
            }
            System.out.println("Bulls: " + evaluation[0] + " Cows: " + evaluation[1] + " Attempts: " + attempts);
        }
        System.out.println("Good job! You guessed it in '" + attempts + "' attempts - Secret number: " + this.secretNumber);
    }
    public static void main(String[] args) {
        Ex6BullsAndCowsGame game = new Ex6BullsAndCowsGame();
        System.out.println("* JUST FOR TESTING (Secret Number) : " + game.secretNumber + " *");
        game.play();
    }
}
