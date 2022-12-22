package Gofish;

import static java.lang.System.out;

import java.util.Scanner;

public class GofishGame {

    static Scanner in = new Scanner(System.in);

    private static final int NUM_SUITS = 4;
    private static final int NUM_VALUES = 13;
    private static final String JACK = "J";
    private static final String ACE = "A";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final String HEARTS = "1";
    private static final String SPADES = "2";
    private static final String CLUBS = "3";
    private static final String DIAMONDS = "4";

    private static final int PLAYER = 1;
    private static final int COMPUTER1 = 2;
    private static final int COMPUTER2 = 3;
    private static final int COMPUTER3 = 4;

   static boolean gameEnded = false;

    /**
    * @param args
    */


    public static void main(String[] args) {
      gameEnded = false;
      String player1 = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
      String comp1 = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
      String comp2 = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
      String comp3 = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

      displayHand(player1, false, "P1: ");
      displayHand(comp1, false, "P2: ");
      displayHand(comp2, false, "P3: ");
      displayHand(comp3, false, "P4: ");

      checkpairs(player1, PLAYER);
      checkpairs(comp1, COMPUTER1);
      checkpairs(comp2, COMPUTER2);
      checkpairs(comp3, COMPUTER3);

      while(!gameEnded) {
         displayHand(player1, false, "P1: ");
         displayHand(comp1, false, "P2: ");
         displayHand(comp2, false, "P3: ");
         displayHand(comp3, false, "P4: ");
         
         p1turn(player1);
         computerTurn(COMPUTER1);
         computerTurn(COMPUTER2);
         computerTurn(COMPUTER3);
      }

      getScore(player1, comp1, comp2, comp3);

      System.out.println("Hands: " + getScore(player1, comp1, comp2, comp3));
      
      removepairs(player1);

   
      
  }


   private static void p1turn(String player1) {
      System.out.println("what do you want to do [1] Ask for a card [2] check hand [3] check score");
      int choice = 0;
      int playerchoice = choice;
      if (in.nextInt() > 3 || in.nextInt() < 1){
         System.out.println("enter a valid choice [1,2,3]");
         p1turn(player1);
      }else {
         choice = in.nextInt();
      }
      if (choice == 1) {
         requestcard();

      }else if (choice == 2) {
         displayHand(player1, false, "Your Hand: ");
      }
      else (choice == 3){
         getScore(player1, comp1, comp2, comp3);
      }
   }


   private static void computerTurn(int d) {  
      int playerchosen = 0;
      if(!gameEnded)
          playerchosen = 0;
         while(true){
            playerchosen = (int)(Math.random()*4) + 1;
         }

   }


   private static void checkpairs(String player1, int player2) {
   }


   private static void gameEnd(int d) {
   System.out.println();

   String winner = "";
   if(d == PLAYER)
      winner = "Player";
   if(d == COMPUTER1)
      winner = "Computer1";
   if(d == COMPUTER2)
      winner = "Computer2";
   if(d == COMPUTER3)
      winner = "Computer3";

      System.out.println(winner + " has 10 points and won the game");

      gameEnded = true;
  }



   private static String removepairs(String hand1) {
      int count = 0;
      String found = " nothing found ";
      for (int i = 0; i < hand1.length(); i++) {
         String c = hand1.charAt(i) + " ";
         String temp = hand1.substring(hand1.indexOf(c) + 2);
         if (temp.contains(c)){
            count++;
            found = count + " pairs found.";
            hand1 = hand1.substring(0,i) + temp.substring(0,temp.indexOf(c)) + temp.substring(temp.indexOf(c) + 2);
         }
      }
      return hand1;
      }







   private static String getScore(String player1, String player2, String player3, String player4) {
      String hand1 = player1;
      String hand2 = player2;
      String hand3 = player3;
      String hand4 = player4;
            
      String values = "12345678910AJQK";
      int P1score = 0;
      int P2score = 0;
      int P3score = 0;
      int P4score = 0;

      String result1 = "";
      String result2 = "";
      String result3 = "";
      String result4 = "";


        for (int i = 0; i < hand1.length(); i++) {
         String hand = hand1.substring(i, (i+1));
         String restOfHand = hand1.substring(i + 1);
         String sub1 = hand1.substring(i,i+1);
         String newhand1 = hand1.substring(0,hand1.indexOf(sub1)) + hand1.substring(hand1.indexOf(sub1));
         if(values.indexOf(hand) >= 1){
            if(restOfHand.indexOf(hand) >= 1){
               P1score++;
               result1 += newhand1;
            }
         }  else{
            result1 = hand1;
         }
      }
      for (int i = 0; i < hand2.length(); i++) {
         String hand = hand2.substring(i, (i+1));
         String restOfHand = hand2.substring(i + 1);
         String sub2 = hand2.substring(i,i+1);
         String newhand2 = hand2.substring(0,hand2.indexOf(sub2)) + hand1.substring(hand2.indexOf(sub2));
         if(values.indexOf(hand) >= 1){
            if(restOfHand.indexOf(hand) >= 1){
               P2score++;
               result2 += newhand2;
            }
         }  else{
            result2 = hand2;
         }
      }
      for (int i = 0; i < hand3.length(); i++) {
         String hand = hand3.substring(i, (i+1));
         String restOfHand = hand3.substring(i + 1);
         String sub3 = hand3.substring(i,i+1);
         String newhand3 = hand3.substring(0,hand3.indexOf(sub3)) + hand3.substring(hand3.indexOf(sub3));
         if(values.indexOf(hand) >= 1){
            if(restOfHand.indexOf(hand) >= 1){
               P3score++;
               result3 += newhand3;
            }
         }  else{
            result3 = hand3;
         }
      }
      for (int i = 0; i < hand4.length(); i++) {
         String hand = hand4.substring(i, (i+1));
         String restOfHand = hand4.substring(i + 1);
         String sub4 = hand4.substring(i,i+1);
         String newhand4 = hand4.substring(0,hand4.indexOf(sub4)) + hand4.substring(hand4.indexOf(sub4));
         if(values.indexOf(hand) >= 1){
            if(restOfHand.indexOf(hand) >= 1){
               P4score++;
               result4 += newhand4;
            }else{
               result4 = hand4;
            }
         }  
      }
      return " Player1hand: " + result1 + " Player2hand: " + result2 + " Player3hand: " + result3 + " Player4hand " + result4 + " Scores(P1,P2,P3,P4): " + P1score + " " + P2score + " " + P3score + " " + P4score;
      
   }




   private static void displayHand(String cards, boolean isHidden, String label) {
      String result = "";
      if (isHidden)
         result += label + "XX " + cards;
      else
         result += label + cards;

      System.out.println(result);
   }


    private static String getCard() {
        return getValue() + getSuit();
     }
       
    
    private static String getSuit() {
        int iSuit = (int) (Math.random() * NUM_SUITS) + 1;
  
        if (iSuit == 1)
           return HEARTS;
        else if (iSuit == 2)
           return SPADES;
        else if (iSuit == 3)
           return CLUBS;
        else
           return DIAMONDS;
  
     }




     private static String getValue() {
      int iValue = (int) (Math.random() * NUM_VALUES) + 1;

      if (iValue == 1) 
         return ACE;
      else if (iValue == 11)
         return JACK;
      else if (iValue == 12)
         return QUEEN;
      else if (iValue == 13)
         return KING;
      else
         return "" + iValue;
   }

  
   
    }
    
    

