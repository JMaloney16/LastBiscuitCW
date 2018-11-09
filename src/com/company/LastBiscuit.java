// Level 3 attempted

import java.util.Scanner;

public class LastBiscuit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String TOO_MANY_BISCUITS = "You can't take more biscuits than are in the barrel!";
        int barrelOne = 6; // These variables store the amount of biscuits left in each barrel
        int barrelTwo = 8;

        int currentPlayer = 1; // This value tracks who is the current player
        int playerAmountChoice; // Variable used for amount of biscuits taken
        String playerBarrelChoice; // Which barrel is chosen by the player

        boolean gameFinished = false;
        boolean roundFinished;

        while (!gameFinished){
            roundFinished = false;
            biscuitsLeft(barrelOne, barrelTwo);

            while (!roundFinished) {
                boolean barrelConfirmed = false;
                playerBarrelChoice = "";
                // Check that the user enters a positive integer for the biscuits taken
                do{
                    System.out.print("Biscuits taken by player " + currentPlayer + ": ");
                    while (!in.hasNextInt()) {
                        System.out.println("Please enter a positive integer.");
                        in.next();
                    }
                    playerAmountChoice = in.nextInt();
                    in.nextLine();
                } while (playerAmountChoice <= 0);

                // Make sure the user enters a correct choice for which barrel.
                while (!barrelConfirmed) {

                    System.out.print("From barrel1 (one), barrel2 (two), or both (both)? ");
                    playerBarrelChoice = in.nextLine();

                    switch (playerBarrelChoice) {
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
                            System.out.println("Please choose one of the three options");
                            break;
                    }
                }

                // Checks the chosen barrel to be seen if there are enough biscuits to take from it
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
                    default:  // If the user chooses both barrels
                        if ((playerAmountChoice <= barrelOne) && (playerAmountChoice <= barrelTwo)) {
                            barrelOne -= playerAmountChoice;
                            barrelTwo -= playerAmountChoice;
                            roundFinished = true;
                        } else {
                            System.out.println(TOO_MANY_BISCUITS);
                        }
                        break;
                }
            }

            if ((barrelOne == 0) && (barrelTwo == 0)){ // If the game has been won
                biscuitsLeft(barrelOne, barrelTwo);
                System.out.println("Winner is player " + currentPlayer);
                gameFinished = true;
            } else{ // If the game is still going, switch player
                switch (currentPlayer){
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
    static void biscuitsLeft(int barrelOne,int barrelTwo){
        System.out.println("Biscuits Left - Barrel 1: " + barrelOne);
        System.out.println("Biscuits Left - Barrel 2: " + barrelTwo);
    }

}
