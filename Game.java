
/**
 * game.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Game
{
    
    public static void main(String args[]) {
        Dealer dealer = new Dealer(2);
        Player player = new Player(40000);
        player.placeBet(10000);
        for(int x = 0; x < 2; x ++) {
            Card c = dealer.dealToPlayer(player);
            System.out.println(c.getValue() + " " + c.getSuit());
            player.addCard(c);
        }
        player.hit(dealer);
        
    }

}
