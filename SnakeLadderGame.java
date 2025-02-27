import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeLadderGame {
    static final int WINNING_POSITION = 100;
    static Map<Integer, Integer> snakes = new HashMap<>();
    static Map<Integer, Integer> ladders = new HashMap<>();
    static Random rand = new Random();

    static {
        // Snakes 🐍
        snakes.put(99, 7);
        snakes.put(92, 35);
        snakes.put(70, 50);
        snakes.put(52, 29);
        snakes.put(25, 2);

        // Ladders 🪜
        ladders.put(3, 22);
        ladders.put(6, 25);
        ladders.put(11, 40);
        ladders.put(60, 85);
        ladders.put(80, 99);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int player1Pos = 0, player2Pos = 0;
        boolean player1Turn = true;

        System.out.println("Welcome to Snake & Ladder Game! 🎲");
        System.out.println("Press ENTER to roll the dice...");
        
        while (player1Pos < WINNING_POSITION && player2Pos < WINNING_POSITION) {
            System.out.println("\n" + (player1Turn ? "Player 1's Turn" : "Player 2's Turn"));
            scanner.nextLine(); // Wait for player to press Enter
            
            int diceRoll = rollDice();
            System.out.println("Rolled: " + diceRoll);
            
            if (player1Turn) {
                player1Pos = movePlayer(player1Pos, diceRoll);
                System.out.println("Player 1 is at position: " + player1Pos);
                if (player1Pos == WINNING_POSITION) {
                    System.out.println("🎉 Player 1 Wins! 🎉");
                    break;
                }
            } else {
                player2Pos = movePlayer(player2Pos, diceRoll);
                System.out.println("Player 2 is at position: " + player2Pos);
                if (player2Pos == WINNING_POSITION) {
                    System.out.println("🎉 Player 2 Wins! 🎉");
                    break;
                }
            }
            
            player1Turn = !player1Turn; // Switch turns
        }
        scanner.close();
    }

    static int rollDice() {
        return rand.nextInt(6) + 1; // Random number between 1 and 6
    }

    static int movePlayer(int position, int diceRoll) {
        int newPosition = position + diceRoll;
        if (newPosition > WINNING_POSITION) return position; // Prevent moving beyond 100
        
        if (snakes.containsKey(newPosition)) {
            System.out.println("🐍 Oh no! A snake bit you! Down to " + snakes.get(newPosition));
            return snakes.get(newPosition);
        }
        
        if (ladders.containsKey(newPosition)) {
            System.out.println("🪜 Hooray! You climbed a ladder to " + ladders.get(newPosition));
            return ladders.get(newPosition);
        }
        
        return newPosition;
    }
}