
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
    
    public void clear() {
        for(int x = 0; x < cards.size(); x ++)
            cards.remove(x);
    }

}
