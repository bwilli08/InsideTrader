/*
 * Class to create and keep track of the types of cards
 * To keep track of the type of card, an integer is used
 * Type = 1 are Directional cards
 * Type = 2 are Situational cards
 * Type = 3 are Augmentation cards
 */

public class Cards
{
	public final int type;
	public final int cardEffect;
	
	/*
	 * Default Constructor, creates an invalid card
	 */
	public Cards()
	{
		type = 0;
		cardEffect = 0;
	}
	
	/*
	 * Creates a card with an integer to specify the type and an integer to specify the effect
	 */
	public Cards(int type, int cardEffect)
	{
		this.type = type;
		this.cardEffect = cardEffect;
	}
	
	/*
	 * Returns the integer 'type' of the card 
	 */
	public int getType()
	{
		return type;
	}
	
	/* 
	 * Returns the integer 'effect' of the card
	 */
	public int getEffect()
	{
		return cardEffect;
	}
	
	/*
	 * Exception class for when an invalid card is used.
	 * Might not be needed
	 */
	public static class InvalidCardTypeException extends RuntimeException
	{
		public InvalidCardTypeException() { super(); }
		public InvalidCardTypeException(String message) { super(message); }
	}
	
	/*
	 * Returns the card's value and effect as a String
	 */
	public String toString()
	{
		if(type==1)
		{
			return "Directional: " + cardEffect;
		}
		else if(type==2)
		{
			if(cardEffect==0)
			{
				return "Situational: Stock Change to Zero";
			}
			else if(cardEffect==1)
			{
				return "Situational: Stock Change Sign Switch"; 
			}
			else 
			{
				return "Situational: Double Stock Change"; 
			}
		}
		else
		{
			if(cardEffect==0)
			{
				return "Augmentation: SEC"; 
			}
			else if(cardEffect==1)
			{
				return "Augmentation: Play Two";
			}
			else 
			{
				return "Augmentation: Play Last";
			}
		}
	}
	
}
