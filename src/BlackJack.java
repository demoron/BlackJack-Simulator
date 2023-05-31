import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Collections;



public class BlackJack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Coins = 1000;

        for (int round = 0; round < 1; round--) {
            for (int game = 0; game < 1; game++) {




                System.out.println("Your coin balance is: "+ Coins);
                List<Object> Deck = new ArrayList<Object>(52);
                int count = 0;
                for (int outer = 2; outer < 11; outer++) {
                    for (int i = 0; i < 4; i++) {
                        Deck.add(count, outer);
                        count += 1;
                    }
                }
                for (int i = 0; i < 5; i++) {
                    Deck.add("Jack");
                }
                for (int i = 0; i < 5; i++) {
                    Deck.add("Queen");
                }
                for (int i = 0; i < 5; i++) {
                    Deck.add("King");
                }
                for (int i = 0; i < 5; i++) {
                    Deck.add("Ace");
                }


                ArrayList<Object> myHand = new ArrayList<Object>(2);
                ArrayList<Object> DealerHand = new ArrayList<Object>(2);
                myHand.add(Functions.drawCard(Deck));
                myHand.add(Functions.drawCard(Deck));
                DealerHand.add(Functions.drawCard(Deck));
                DealerHand.add(Functions.drawCard(Deck));
                System.out.println("My hand is:           " + myHand);
                System.out.println("The Dealer's hand is: " + "[*, " + DealerHand.get(1) + " ]");
                System.out.println("Do you want to Hit or Stand? Press 0 for stand and 1 for hit: ");
                int myTotal = Functions.getTotal(myHand);
                int dealerTotal = Functions.getTotal(DealerHand);
                int softTotal = myTotal;
                int AceCount = 0;
                int shouldBreak = 0;


                for (int i = 0; i < 10; i--) {
                    if (myTotal > 21) {
                        AceCount = Collections.frequency(myHand, "Ace");
                        softTotal = myTotal;
                        softTotal = myTotal - (9 * AceCount);


                    }


                    if (softTotal > 21) {
                        System.out.println("You Bust! \n\n\n" );
                        Coins-=50;
                        i = 100;
                        shouldBreak = 1;
                        break;

                    } else if (input.nextInt() == 0) {
                        i = 10000;
                    } else {
                        myHand.add(Functions.drawCard(Deck));
                        System.out.println("My hand is now: " + myHand);
                        myTotal = Functions.getTotal(myHand);
                    }


                }
                if (shouldBreak == 1) {
                    break;
                }


                Functions.dealerTurn(DealerHand, Deck);

                myTotal = Functions.getTotal(myHand);
                dealerTotal = Functions.getTotal(DealerHand);
                System.out.println("My final total is: " + myTotal);
                System.out.println("The dealer's final total is: " + dealerTotal);

                if (dealerTotal > 21) {

                    System.out.println("The dealer's hand was a bust, I WIN!\n\n\n");
                    Coins+=50;

                    break;

                }

                if (myTotal > dealerTotal) {
                    System.out.println("I WON!\n\n\n");
                    Coins+=50;
                }
                if (myTotal == dealerTotal) {
                    System.out.println("WE TIED \n\n\n");

                }
                if (myTotal < dealerTotal) {
                    System.out.println("I LOST! \n \n \n" );
                    Coins-=50;
                }


            }

            }

        }
    }








