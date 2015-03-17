import java.util.*;

public class Game 
{
	private int stockPrice;
	private int dayChange;
	private int players;
	private ArrayList<Cards> deck;
	private ArrayList<Cards> pile;
	private Player[] playerList;
	
	/*
	 * Creates a game with input number of players
	 * Deals to each of the players.
	 * Sets the stock price to 100.
	 */
	public Game(int numPlayers)
	{
		stockPrice = 100;
		initializeDeck();
		pile = new ArrayList<Cards>();
		playerList = new Player[numPlayers];
		players = numPlayers;
		deal();
	}
	
	/*
	 * Private method for dealing to players
	 */
	private void deal()
	{
		for(int i=0; i<players; i++)
		{
			playerList[i] = new Player();
			for(int j=0; j<5; j++)
			{
				playerList[i].receiveCard(deck.remove(deck.size()-1));
			}
		}
	}
	
	/*
	 * Deals the top card of the deck to a specific player
	 */
	public void dealTo(int player)
	{
		if(deck.size()!=0)
			playerList[player].receiveCard(deck.remove(deck.size()-1));
		else
		{
			pileToDeck();
			playerList[player].receiveCard(deck.remove(deck.size()-1));
		}
	}
	
	/*
	 * Transfers all BUT THE TOP OF THE PILE to the deck
	 * Reshuffles after putting in deck
	 */
	private void pileToDeck()
	{
		int pileSize = pile.size();
		for(int i=0; i<pileSize-1; i++)
		{
			deck.add(pile.remove(0));
		}
		System.out.println("----Pile size: "+pile.size());
		shuffle();
	}
	
	/*
	 * Takes a card input and uses its effect.
	 * Precondition: Playing card is valid.
	 * Does this by calling private card effect methods
	 */
	public void playCard(Cards card)
	{
		if(card.getType()==1)
			directionalChange(card.getEffect());
		else if(card.getType()==2)
		{
			if(card.getEffect()==0)
				resetDayChange();
			else if(card.getEffect()==1)
				switchDayChange();
			else
				doubleDayChange();
		}
		else
		{
			if(card.getEffect()==0)
			{
				//implement SEC card
			}
			else if(card.getEffect()==1)
			{
				//implement PlayTwo card
			}
			else
			{
				//implement PlayLast Card
			}
		}
		pile.add(card);
	}
	
	/*
	 * Card Effect - Changes the day change by a fixed amount
	 */
	private void directionalChange(int value)
	{
		dayChange += value;
	}
	
	/*
	 * Card Effect - Nullifies all earlier day changes, sets to 0
	 */
	private void resetDayChange()
	{
		dayChange = 0;
	}
	
	/*
	 * Card Effect - Multiplies the day change by -1
	 */
	private void switchDayChange()
	{
		dayChange = dayChange * -1;
	}
	
	/* 
	 * Card Effect - Doubles the current day change
	 */
	private void doubleDayChange()
	{
		dayChange = dayChange * 2;
	}
	
	/*
	 * At the end of a 'day', changes the stock price by the day change.
	 */
	public void endOfDay()
	{
		stockPrice = stockPrice + dayChange;
	}
	
	/*
	 * Creates a deck with 5 of each Directional card, and three of each Situational/Augmentation card (58 cards)
	 */
	private void initializeDeck()
	{
		deck = new ArrayList<Cards>();
		for(int i=0; i<5; i++)
		{
			for(int j=-4; j<5; j++)
			{
				if(j!=0)
					deck.add(new Cards(1,j));
			}
		}
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				deck.add(new Cards(2,j));
			}
		}
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				deck.add(new Cards(3,j)); // Cards are useless for now
			}
		}
		
		//System.out.println("\nSize of Deck after Initialization - " + deck.size());
		//printDeck();
		shuffle();
	}
	
	/*
	 * Shuffles the current cards in the deck
	 */
	public void shuffle()
	{
		Random position = new Random();
		int cardsNotShuffled = deck.size();
		ArrayList<Cards> temp = new ArrayList<Cards>();
		
		while(cardsNotShuffled!=0)
		{
			temp.add(deck.remove(position.nextInt(cardsNotShuffled)));
			cardsNotShuffled--;
		}
		//System.out.println("Size of deck after shuffling - " + temp.size());
		deck = temp;
	}
	
	/*
	 * Prints the current deck to the user
	 */
	public void printDeck()
	{
		for(int i=0; i<deck.size(); i++)
		{
			System.out.println(deck.get(i).toString());
		}
	}
	
	/*
	 * Prints the current pile to the user
	 */
	public void printPile()
	{
		for(int i=0; i<pile.size(); i++)
		{
			System.out.println(pile.get(i).toString());
		}
	}
	
	/*
	 * Prints the top card of the pile to the user
	 */
	public void printTop()
	{
		System.out.println(pile.get(pile.size()-1).toString());
	}
	
	/*
	 * Returns the player at a specific index (from 0 to number of players - 1)
	 */
	public Player returnPlayer(int index)
	{
		return playerList[index];
	}
}
