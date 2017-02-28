
/**
 * Shoe.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
import java.util.ArrayList;
public class Shoe
{
    int amountOfDecks;
    ArrayList<Card> shoe = new ArrayList<Card>();
    
    public Shoe(int amountOfDecks) {
        this.amountOfDecks = amountOfDecks;
        int ctr = 1;
        for(int y = 0; y < amountOfDecks; y ++) {
            for(int x = 1; x < 53; x ++) {
                if(ctr > 10) {
                    shoe.add(new Card(10));
                } else
                shoe.add(new Card(ctr));
                if(x%13 == 0)
                    ctr = 1;
                else
                    ctr++;
            }
        }
    }
    
    public void shuffle() {
        System.out.println("Shuffled Shoe");
    }
    
    public Card randomCard() {
        int k = (int)(Math.random()*shoe.size() + 0);
        Card i = shoe.get(k);
        return i;
    }

}
