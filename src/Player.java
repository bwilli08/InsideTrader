import java.util.*;

public class Player 
{
	private Cards[] hand;
	private int numCards;
	
	/*
	 * Creates a player with a hand size of 5 but no cards
	 */
	public Player()
	{
		hand = new Cards[5];
		numCards = 0;
	}
	
	/*
	 * Exception class for possible Exceptions thrown
	 * Might not be needed
	 */
	@SuppressWarnings("serial")
	public static class InvalidHandException extends RuntimeException
	{
		public InvalidHandException() { super(); }
		public InvalidHandException(String message) { super(message); }
	}
	
	/*
	 * If the player's hand isn't full, adds the card to their hand
	 */
	public void receiveCard(Cards card)
	{
		if(numCards>4)
			throw new InvalidHandException("Hand already full.");
		else
			hand[numCards++] = card;
	}
	
	/*
	 * Plays a card from the players hand, granted that index is between 0 and 4
	 * Deletes the card from the player's hand after playing it
	 */
	public Cards playCard(int index)
	{
		if(index>5 || index<0)
			throw new InvalidHandException("Cannot play a card outside of your hand.");
		else
		{
			Cards cardPlayed = hand[index-1];
			hand[index-1] = hand[4];
			numCards--;
			return cardPlayed;
		}
	}
	
	/*
	 * Simple roll method to determine who goes first
	 */
	public int rollSimple()
	{
		Random roll = new Random();
		return (roll.nextInt(6) + 1);
	}
	
	/* 
	 * Complex roll method (from -6 to -1 and 1 to 6)
	 */
	public int rollComplex()
	{
		Random roll = new Random();
		int temp = roll.nextInt(12);
		if(temp<6)
			return temp - 6;
		else
			return temp - 5;
	}
	
	/*
	 * Returns the player's hand as a String
	 */
	public String printHand()
	{
		String temp = new String();
		for(int i=0; i<numCards; i++)
		{
			temp = temp + (i+1) + " " + hand[i] + "\n";
		}
		return temp;
	}
	
	/* 
	 * Returns the size of the player's hand
	 */
	public int handSize()
	{
		return numCards;
	}
}