// Level 3 attempted

import java.util.Scanner;

public class LastBiscuit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final String TOO_MANY_BISCUITS = "You can't take more biscuits than are in the barrel!";
        final String INVALID_INPUT = "Invalid input, please enter a valid input.";

        int barrelOne = 6; // These variables store the amount of biscuits left in each barrel
        int barrelTwo = 8;

        int currentPlayer = 1; // This value tracks who is the current player
        int playerAmountChoice;
        String playerBarrelChoice;
        boolean roundFinished;
        // Used for validation so the user is forced to enter a correct value before switching players

        while (barrelOne > 0 || barrelTwo > 0) {
            roundFinished = false;
            biscuitsLeft(barrelOne, barrelTwo); // Calls method that outputs the biscuits left in each barrel

            while (!roundFinished) {
                boolean barrelConfirmed = false;
                playerBarrelChoice = "";
                // Check that the user enters a positive integer for the biscuits taken
                do {
                    System.out.print("Biscuits taken by player " + currentPlayer + ": ");
                    while (!in.hasNextInt()) { // Check that the user enters an integer
                        System.out.println(INVALID_INPUT);
                        in.next();
                    }
                    playerAmountChoice = in.nextInt();
                    in.nextLine(); // Clear the buffer for the next user input
                } while (playerAmountChoice <= 0);

                // Take user input for barrel choice and make sure it's valid
                while (!barrelConfirmed) {
                    System.out.print("From barrel1 (one), barrel2 (two), or both (both)? ");
                    playerBarrelChoice = in.nextLine();
                    switch (playerBarrelChoice.toLowerCase()) {
                        case "one":
                            barrelConfirmed = true;
                            break;
                        case "two":
                            barrelConfirmed = true;
                            break;
                        case "both":
                            barrelConfirmed = true;
                            break;
                        default:
                            System.out.println(INVALID_INPUT);
                            break;
                    }
                }
                // Checks the chosen barrel to see if there are enough biscuits to take from it
                switch (playerBarrelChoice) {
                    case "one":
                        if (playerAmountChoice <= barrelOne) {
                            barrelOne -= playerAmountChoice;
                            roundFinished = true;
                        } else {
                            System.out.println(TOO_MANY_BISCUITS);
                        }
                        break;
                    case "two":
                        if (playerAmountChoice <= barrelTwo) {
                            barrelTwo -= playerAmountChoice;
                            roundFinished = true;
                        } else {
                            System.out.println(TOO_MANY_BISCUITS);
                        }
                        break;
                    case "both":
                        if ((playerAmountChoice <= barrelOne) && (playerAmountChoice <= barrelTwo)) {
                            barrelOne -= playerAmountChoice;
                            barrelTwo -= playerAmountChoice;
                            roundFinished = true; // The player has made a valid choice and the game can move on
                        } else {
                            System.out.println(TOO_MANY_BISCUITS);
                        }
                        break;
                }
            }

            if ((barrelOne == 0) && (barrelTwo == 0)) { // If the game has been won
                biscuitsLeft(barrelOne, barrelTwo);
                System.out.println("Winner is player " + currentPlayer);
            } else { // If the game is still going, switch player
                switch (currentPlayer) {
                    case 1:
                        currentPlayer = 2;
                        break;
                    case 2:
                        currentPlayer = 1;
                        break;
                }
            }
        }
    }

    // Method for biscuits left output instead of using a final string because of the barrel variables
    static void biscuitsLeft(int barrelOne, int barrelTwo) {
        System.out.println("Biscuits Left - Barrel 1: " + barrelOne);
        System.out.println("Biscuits Left - Barrel 2: " + barrelTwo);
    }

}
