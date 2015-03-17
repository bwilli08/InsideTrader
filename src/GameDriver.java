/*
 * Notes for next time
 * -----------------------------
 * Round/Turn isn't finished yet
 * Confusing mix of class usages
 * Try to simplify/clean up code. Really messy and hard to keep track of class priorities and access.
 * Might need to put a turn method in Game, instead of keeping track in GameDriver
 * Implement the Augmentation cards 
 * This will include keeping track of the top card of the pile and nullifying it's effect (make an unPlayCard method in game)
 */

import java.util.*;

public class GameDriver 
{
	public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); //Creates a scanner to read user's input
        System.out.println("Enter the amount of players: ");
        int numPlayers = scan.nextInt(); //Scans the next integer to initialize the size of the heap
        Game game = new Game(numPlayers); //Initializes a game with the number of players
        scan.nextLine();
        System.out.println("Shuffling Deck.");
        //game.printDeck();
        System.out.println("Printing player hands...\n");
        for(int i=0; i<numPlayers; i++)
        {
        	System.out.println("Player " + (i+1));
        	System.out.println(game.returnPlayer(i).printHand());
        }
        
        int playerTurn = 0;
        int played = 0;
        boolean continueTurn;
        boolean continueRound = true;
        
        while(continueRound)
        {
        	continueTurn = true;
        	while(continueTurn)
        	{
        		if(played!=0)
        		{
        			System.out.println("Top of the Pile:");
        			game.printTop();
            		System.out.println("");
        		}
        		System.out.println("Player " + (playerTurn+1) + ": It's your turn!");
        		char turnChoice;
        		System.out.println("Choose a card to play. (Enter the number corresponding to each card)");
        		System.out.println(game.returnPlayer(playerTurn).printHand());
        		turnChoice = scan.nextLine().charAt(0);
        		switch(turnChoice)
        		{
        			case '1':
        				game.playCard(game.returnPlayer(playerTurn).playCard(1));
        				game.dealTo(playerTurn);
        				played++;
        				continueTurn = false;
        				break;
        			case '2':
        				game.playCard(game.returnPlayer(playerTurn).playCard(2));
        				game.dealTo(playerTurn);
        				played++;
        				continueTurn = false;
        				break;
        			case '3':
        				game.playCard(game.returnPlayer(playerTurn).playCard(3));
        				game.dealTo(playerTurn);
        				played++;
        				continueTurn = false;
        				break;
        			case '4':
        				game.playCard(game.returnPlayer(playerTurn).playCard(4));
        				game.dealTo(playerTurn);
        				played++;
        				continueTurn = false;
        				break;
        			case '5':
        				game.playCard(game.returnPlayer(playerTurn).playCard(5));
        				game.dealTo(playerTurn);
        				played++;
        				continueTurn = false;
        				break;
        			case 'q':
        				continueTurn = false;
        				continueRound = false;
        				break;
        			default:
        				System.out.println("Invalid card choice, try again.");
        				break;
        		}
        	}
        	playerTurn++;
        	if(playerTurn==numPlayers)
        		playerTurn=0;
        	/*System.out.println("Deck:");
        	game.printDeck();
        	System.out.println("\n\nPile:");
        	game.printPile();
        	System.out.println("\n\n");*/
        }
        scan.close();
    }
}