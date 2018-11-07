package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int bagOne = 6;
        int bagTwo = 8;
        int playerAmountChoice;
        String playerBagChoice = "";
        final String TOO_MANY_BISCUITS = "You can't take more biscuits than are in the bag!";
        boolean gameFinished = false;

        while (gameFinished == false){
            boolean bagConfirmed = false;

            System.out.println("Biscuits left - Bag 1: " + bagOne);
            System.out.println("Biscuits left - Bag 2: " + bagTwo);

            System.out.print("Biscuits taken by player 1: ");
            while(!in.hasNextInt() || (in.nextInt() < 0)){
                System.out.println("Please enter an integer greater than 0.");
                in.next();
            }

            playerAmountChoice = in.nextInt();
            in.nextLine();

            while (bagConfirmed == false) {
                System.out.print("From bag1 (one), bag2 (two) or (both)?: ");
                playerBagChoice = in.nextLine();

                switch (playerBagChoice) {
                    case "one":
//                        System.out.println("You chose one");
                        bagConfirmed = true;
                        break;
                    case "two":
//                        System.out.println("You chose two");
                        bagConfirmed = true;
                        break;
                    case "both":
                        bagConfirmed = true;
                        break;
                    default:
                        System.out.println("Please choose one of the three options");
                        break;
                }
            }

            if (playerBagChoice.equals("one")) {
                if (playerAmountChoice <= bagOne){
                    bagOne -= playerAmountChoice;
                } else{
                    System.out.println(TOO_MANY_BISCUITS);                }
            } else if (playerBagChoice.equals("two")) {
                if (playerAmountChoice <= bagTwo){
                   bagTwo -= playerAmountChoice;
                } else{
                    System.out.println(TOO_MANY_BISCUITS);
                }
            }else{ // If the user chooses both
                if ((playerAmountChoice <= bagOne) && (playerAmountChoice <= bagTwo)){
                    bagOne -= playerAmountChoice;
                    bagTwo -= playerAmountChoice;
                } else{
                    System.out.println(TOO_MANY_BISCUITS);
                }
            }

        }
    }
}
