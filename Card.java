
/**
 * Card.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Card
{
    
    int value;
    String suit;
    boolean facing;
    
    public Card(int value) {
        this.value = value;
        if(value % 2 == 0)
            suit = "red";
        else
            suit = "black";
        facing = true;
    }
    
    public int getValue() {
        return value;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public void flip() {
        this.facing = !this.facing;
    }

}
