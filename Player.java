
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
     * @param a dealer
     * @return 1 if had enough money to double down and 2 if the player didn't
     */
    public int doubleDown(Dealer dealer) {
        if(betAmount * 2 <= totalMoney) {
            Card c = dealer.dealToPlayer(this);
            this.cardTotal += c.getValue();
            hand.addCard(c);
            betAmount *= 2;
            System.out.println("You double down'd and you got a " + c.getValue() + " with a total bet of " + betAmount + " and your card total is " + cardTotal);
            return 1;
        } else {
            System.out.println("You don't have enough money to double down");
            return 2;
        }
    }

    public void hit(Dealer dealer) {
        Card c = dealer.dealToPlayer(this);
        this.cardTotal += c.getValue();
        hand.addCard(c);
        System.out.println("You hit and you got a " + c.getValue() + " with a total hand of " + cardTotal);
        if(cardTotal >= 21) {
            dealer.distributeMoney(this,betAmount);
        }
    }

    public void stand() {
        System.out.println("Stood");
    }

    public int getCardTotal() {
        return cardTotal;
    }

    public void addMoney(double money) {
        totalMoney += money;
    }

    public void addCard(Card c) {
        hand.addCard(c);
        cardTotal += c.getValue();
    }

    public int placeBet(double bet) {
        if(totalMoney <= bet) {
            betAmount = bet;
            System.out.println("You placed a $" + bet + " bet and have $" + totalMoney + " left!");
            return 1;
        }
        else {
            System.out.println("You don't have enough money for this bet! You have: " + totalMoney);
            return 2;
        }
    }

}
