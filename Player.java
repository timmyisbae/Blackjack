
/**
 * Player.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Player
{
    double betAmount, totalMoney;
    int cardTotal;
    Hand hand;

    public Player(double totalMoney) {
        this.totalMoney = totalMoney;
        hand = new Hand();
    }

    /**
     * Makes sure the player has enough money to double down and multiplies the bet amount by 2 and also adds a card to the players hand
     * @param The dealer object
     * @return 1 if the player had enough money to double down and 2 if the player didn't and 3 if the player is 21 or over
     */
    public int doubleDown(Dealer dealer) {
        if(betAmount * 2 <= totalMoney) {
            Card c = dealer.dealToPlayer(this);
            betAmount *= 2;
            System.out.println("You double down'd and you got a " + c.getValue() + " with a total bet of $" + betAmount + " and your card total is " + cardTotal);
            if(cardTotal >= 21) {
            dealer.distributeMoney(this,betAmount);
            return 3;
        } else
            return 1;
        } else {
            System.out.println("You don't have enough money to double down");
            return 2;
        }
    }

    /**
     * Player gets dealt a card
     * @param The dealer object
     * @return @return 3 if the player is 21 or over otherwise it returns 1 to show that the player can keep going
     */
    public int hit(Dealer dealer) {
        Card c = dealer.dealToPlayer(this);
        System.out.println("You hit and you got a " + c.getValue() + " with a total hand of " + cardTotal);
        if(cardTotal >= 21) {
            dealer.distributeMoney(this,betAmount);
            return 3;
        } else
            return 1;
    }

    /**
     * The dealer deals to the house until the house's card total is over 13 and then calls the distribute money method
     * @param The dealer object
     * @return 3 to show that the player can't do anything else
     */
    public int stand(Dealer dealer) {
        System.out.println("Stood");
        while(dealer.getCardTotal() < 13)
            dealer.dealToHouse();
        dealer.distributeMoney(this,betAmount);
        return 3;
    }
    
    /**
     * @return The sum of the cards in the players hand
     */
    public int getCardTotal() {
        return cardTotal;
    }

    /**
     * Adds money to the player's balance
     */
    public void addMoney(double money) {
        totalMoney += money;
    }
    
    /**
     * Adds a card to the players hand
     * @param The card to add to the players hand
     */
    public void addCard(Card c) {
        hand.addCard(c);
        cardTotal += c.getValue();
    }
    
    /**
     * Makes sure the player has enough money to place the bet and sets the bet amount to the paramater amount
     * @param Amount player want's to bet
     */
    public int placeBet(double bet) {
        if(totalMoney >= bet) {
            betAmount = bet;
            totalMoney -= bet;
            System.out.println("You placed a $" + bet + " bet and have $" + totalMoney + " left!");
            return 1;
        }
        else {
            System.out.println("You don't have enough money for this bet! You have: $" + totalMoney);
            return 2;
        }
    }
    
    /**
     * Clears the players hand and bet amount and card total
     */
    public void resetGame() {
        hand.clear();
        betAmount = 0;
        cardTotal = 0;
    }
}
