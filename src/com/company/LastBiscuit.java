package com.company;

import java.util.Scanner;

public class LastBiscuit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int barrelOne = 6; // These variables store the amount of biscuits Left
        int barrelTwo = 8;
        int currentPlayer = 1;

        int playerAmountChoice; // Variable used for amount of biscuits taken
        String playerBarrelChoice = ""; // Which barrel is chosen
        final String TOO_MANY_BISCUITS = "You can't take more biscuits than are in the barrel!";
        boolean gameFinished = false;

        while (!gameFinished){
            boolean barrelConfirmed = false;

            System.out.println("Biscuits Left - Barrel 1: " + barrelOne);
            System.out.println("Biscuits Left - Barrel 2: " + barrelTwo);

            // Check that the user enters a positive integer for the biscuits taken
            do{
                System.out.print("Biscuits taken by player " + currentPlayer + ": ");
                while (!in.hasNextInt()) {
                    System.out.println("Please enter a positive integer.");
                    in.next();
                }
                playerAmountChoice = in.nextInt();
            } while (playerAmountChoice <= 0);

            in.nextLine();

            // Make sure the user enters a correct choice for which barrel.
            while (barrelConfirmed == false) {
                System.out.print("From barrel1 (one), barrel2 (two), or both (both)? ");
                playerBarrelChoice = in.nextLine();

                switch (playerBarrelChoice) {
                    case "one":
//                        System.out.println("You chose one");
                        barrelConfirmed = true;
                        break;
                    case "two":
//                        System.out.println("You chose two");
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
            if (playerBarrelChoice.equals("one")) {
                if (playerAmountChoice <= barrelOne){
                    barrelOne -= playerAmountChoice;
                } else{
                    System.out.println(TOO_MANY_BISCUITS);
                }
            } else if (playerBarrelChoice.equals("two")) {
                if (playerAmountChoice <= barrelTwo){
                    barrelTwo -= playerAmountChoice;
                } else{
                    System.out.println(TOO_MANY_BISCUITS);
                }
            }else{ // If the user chooses both
                if ((playerAmountChoice <= barrelOne) && (playerAmountChoice <= barrelTwo)){
                    barrelOne -= playerAmountChoice;
                    barrelTwo -= playerAmountChoice;
                } else{
                    System.out.println(TOO_MANY_BISCUITS);
                }
            }

            if ((barrelOne == 0) && (barrelTwo == 0)){
                System.out.println("Biscuits Left - Barrel 1: " + barrelOne);
                System.out.println("Biscuits Left - Barrel 2: " + barrelTwo);
                System.out.println("Winner is player " + currentPlayer);
                gameFinished = true;
            } else{
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

}
