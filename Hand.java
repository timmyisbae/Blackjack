
/**
 * Hand.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
import java.util.ArrayList;
public class Hand
{
    
    ArrayList<Card> cards = new ArrayList<Card>();
    int value;
    
    public void addCard(Card c) {
        cards.add(c);
        value += c.getValue();
    }

}
