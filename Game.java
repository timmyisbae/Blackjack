
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
import java.util.Scanner;
public class Game
{

    public static void main(String args[]) {
        
        System.out.println("---NEW GAME---");
        
        Scanner sc = new Scanner(System.in);

        Dealer dealer = new Dealer(2);
        Player player = new Player(40000);
        while(true) {
            System.out.println("Bet amount: ");
            int checker = 2;
            while(checker == 2)
                checker = player.placeBet(sc.nextDouble());

            for(int x = 0; x < 2; x ++) {
                dealer.dealToPlayer(player);
            }
            
            for(int x = 0; x < 2; x ++) {
                dealer.dealToHouse();
                
            }

            int end = 1;
            while(end != 3) {
                System.out.println("1-hit 2-double down 3-stand");
                int h = sc.nextInt();
                if(h == 1) {
                    end = player.hit(dealer);
                } else if(h == 2) {
                    end = player.doubleDown(dealer);
                } else if(h == 3) {
                    end = player.stand(dealer);
                }

            }
            
            player.resetGame();
            dealer.resetGame();
            
            System.out.println("---NEW GAME---");
            
        }
    }

}
