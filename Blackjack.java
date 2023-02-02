import java.util.Scanner;

public class Blackjack {
    public static void main(String args[]) throws InterruptedException {
        Scanner scnr = new Scanner(System.in);
        Deck deck = new Deck();
        boolean playerBust = false;
        boolean houseBust = false;
        boolean playAgain = true;
        int houseWins = 0;
        int playerWins = 0;
        int ties = 0;

        // keeps playing until user inputs to stop
        while (playAgain) {

            int houseTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);
            int playerTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);
            
            // Player's turn

            System.out.println("The house is showing: " + houseTotal);

            while (playerTotal <= 21) {
                System.out.println("The player is showing: " + playerTotal);

                System.err.println("Would you like to hit or stand? \nEnter 1 for hit or 0 for stand.");

                int choice = scnr.nextInt();

                if (choice == 0)
                    break;
                else if (choice == 1) {
                    Card nextCard = deck.drawCard();
                    nextCard = deck.drawCard();
                    System.out.println("Player draws the " + nextCard.declareCard());
                    playerTotal += nextCard.getValue(true);
                } else 
                    System.out.println("Ivalid option, try again");
                
            }

            if (playerTotal > 21) {
                System.out.println("The player has bust with " + playerTotal);
                playerBust = true;
            } else {
                System.out.println("\nThe player stands with " + playerTotal + " points.");
                System.out.println("The house will play next.");
            }

            // House's turn
            
            while (houseTotal < 17) {
                Thread.sleep(500);
                System.out.println("The house is showing: " + houseTotal);
                Card nextCard = deck.drawCard();
                houseTotal += nextCard.getValue(true);
                Thread.sleep(500);
                System.out.println("After drawing, the house is showing: " + houseTotal + " points.");
            }

            if (houseTotal >= 17 && houseTotal <= 21 && !playerBust) {
                Thread.sleep(500);
                System.out.println("The house stands at " + houseTotal + " points.");
            } else if (houseTotal > 21) {
                Thread.sleep(500);
                System.out.println("The house has bust with " + houseTotal);
                houseBust = true;
            }
            
            // Game result

            if (((houseTotal > playerTotal) && houseTotal <= 21) || (playerBust && !houseBust)) {
                Thread.sleep(500);
                System.out.println("The house has won.");
                houseWins++;
            }

            else if (((playerTotal > houseTotal) && playerTotal <= 21) || (houseBust && !playerBust)) {
                Thread.sleep(500);
                System.out.println("Congraulations! You have won!");
                playerWins++;
            }

            else if (playerBust && houseBust) {
                Thread.sleep(500);
                System.out.println("Oops! Both the house and player have busted!");
                ties++;
            }

            else if (playerTotal == houseTotal) {
                Thread.sleep(500);
                System.out.println("The house and player have the same total. It's a tie!");
                ties++;
            }

            System.out.println("\nWould you like to play again? \nTrue or false");
            playAgain = scnr.nextBoolean();

            houseBust = false;
            playerBust = false;
        }
        
        // Player chose to quit

        System.out.println("\nThank you for playing!");
        System.out.println("The player won " + playerWins + " times");
        System.out.println("The house won " + houseWins + " times");
        System.out.println("There were " + ties + " ties");
    }

}
