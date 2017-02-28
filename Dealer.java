
/**
 * Dealer.java  
 *
 * @author: Tim Spaeth
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Dealer
{
    Shoe shoe;
    Hand hand;
    int cardTotal;
    
    /**
     * @param amount of decks the shoe needs
     */
    public Dealer(int amountOfDecks) {
        shoe = new Shoe(amountOfDecks);
        hand = new Hand();
    }
    
    public Card dealToPlayer(Player player) {
        return shoe.randomCard();
    }
    
    public void dealToHouse() {
        Card c = shoe.randomCard();
        hand.addCard(c);
        cardTotal += c.getValue();
    }
    
    /**
     * @param player card total, house card total, bet total
     * @return string saying who won and how much they won
     */
    public String distributeMoney(Player player, double bet) {
        if(player.getCardTotal() > cardTotal && player.getCardTotal() <= 21) {
            player.addMoney(bet*2);
            return "You won $" + (bet*2) + "!";
        }
        else if(player.getCardTotal() == cardTotal) {
            player.addMoney(bet);
            return "It was a tie, you got your money back!";
        } else
            return "You lost $" + bet + ".";
    }
    
}
