package exercise1;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card.
 * To be used as starting code in Exercise
 *
 * @author dancye
 * @author Paul Bonenfant Jan 25, 2022
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] hand = new Card[7];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Generate a hand of 7 cards
        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            card.setValue(random.nextInt(10) + 1); // Random number between 1 and 10
            card.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit index between 0 and 3
            hand[i] = card;
        }

        // Print out generated cards (for debugging, comment out before pushing)
        // for (Card card : hand) {
        //     System.out.println(card.getSuit() + " " + card.getValue());
        // }

        // Ask the user to pick a card
        System.out.println("Pick a card!");
        System.out.print("Enter the value (1-10 for number cards, 11-13 for face cards): ");
        int userValue = scanner.nextInt();

        System.out.print("Enter the suit (0 for Hearts, 1 for Diamonds, 2 for Spades, 3 for Clubs): ");
        int userSuit = scanner.nextInt();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuit]);

        // Search the hand for a match
        boolean isMatch = false;
        for (Card card : hand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                isMatch = true;
                break;
            }
        }

        // If there's a match, invoke the printInfo() method
        if (isMatch) {
            printInfo();
        } else {
            System.out.println("Sorry, your card is not in the hand.");
        }
    }

    /**
     * A simple method to print out personal information. Follow the instructions to
     * replace this information with your own.
     *
     * @author Paul Bonenfant Jan 2022
     */
    private static void printInfo() {
        System.out.println("Congratulations, you guessed right!");
        System.out.println();

        System.out.println("My name is Paul, but you can call me prof, Paul or sir");
        System.out.println();

        System.out.println("My career ambitions:");
        System.out.println("-- Be more active on LinkedIn");
        System.out.println("-- Have a semester with no violations of academic integrity!");
        System.out.println();

        System.out.println("My hobbies");
        System.out.println("-- Investing");
        System.out.println("-- Cooking");
        System.out.println("-- Reading/Watching TV");
        System.out.println("-- Riding my motorcycle");

        System.out.println();
    }
}
