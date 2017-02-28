
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
     * @param Amount of decks the shoe needs
     */
    public Dealer(int amountOfDecks) {
        shoe = new Shoe(amountOfDecks);
        hand = new Hand();
    }
    
    /**
     * Gives the player a randomly drawn card from the shoe
     * @param The player that is recieving the card
     * @return The card drawn from the shoe
     */
    public Card dealToPlayer(Player player) {
        Card c = shoe.randomCard();
        System.out.println(c.getValue() + " " + c.getSuit());
        player.addCard(c);
        return c;
    }
    
    /**
     * Deals a card to the house's hand
     */
    public void dealToHouse() {
        Card c = shoe.randomCard();
        System.out.println(c.getValue() + " " + c.getSuit());
        hand.addCard(c);
        cardTotal += c.getValue();
    }
    
    /**
     * Compares the card totals for the player and the house and distributes money accordingly
     * @param player card total, house card total, bet total
     */
    public void distributeMoney(Player player, double bet) {
        System.out.println("The house had a card total of " + cardTotal + " and you had a card total of " + player.getCardTotal());
        if(player.getCardTotal() > cardTotal && player.getCardTotal() <= 21) {
            player.addMoney(bet*2);
            System.out.println("You won $" + (bet*2) + "!");
        }
        else if(player.getCardTotal() == cardTotal) {
            player.addMoney(bet);
            System.out.println("It was a tie, you got your money back!");
        } else
            System.out.println("You lost $" + bet + ".");
    }
    
    /**
     * Clears the house's hand and shuffles the shoe
     */
    public void resetGame() {
        hand.clear();
        cardTotal = 0;
        shoe.shuffle();
    }
    
    /**
     * @return The sum of cards in the house's hand
     */
    public int getCardTotal() {
        return cardTotal;
    }
}
