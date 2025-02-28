import java.util.Random;
import java.util.Scanner;
public class SnakeLadder {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();


            System.out.print("Enter 1st player name: ");
            String player1Name = scanner.nextLine();
            System.out.print("Enter 2nd player name: ");
            String player2Name = scanner.nextLine();

            int player1 = 0, player2 = 0;
            boolean player1Turn = true;

            while (true) {
                System.out.println("\n your current position ");
                System.out.println(player1Name + ": " + player1);
                System.out.println(player2Name + ": " + player2);

                String currentPlayer = player1Turn ? player1Name : player2Name;
                System.out.println("\n" + currentPlayer + "'s turn. Press Enter to roll the dice...");
                scanner.nextLine();

                int dice = random.nextInt(6) + 1;
                System.out.println(currentPlayer + " rolled: " + dice);

                if (player1Turn) {
                    if (player1 + dice <= 100) {
                        player1 += dice;
                        player1 = checkPosition(player1);
                    } else {
                        System.out.println("Roll exceeds 100, try again next turn!");
                    }
                    if (player1 == 100) {
                        System.out.println("\n " + player1Name + " wins the game! ");
                        break;
                    }
                } else {
                    if (player2 + dice <= 100) {
                        player2 += dice;
                        player2 = checkPosition(player2);
                    } else {
                        System.out.println("Roll exceeds 100, try again next turn!");
                    }
                    if (player2 == 100) {
                        System.out.println("\n " + player2Name + " wins the game! ");
                        break;
                    }
                }
                player1Turn = !player1Turn; // Switch turn
            }
            scanner.close();
        }

        private static int checkPosition(int position) {
            int[] laddersStart = {3, 5, 11, 20, 27, 36, 51, 71, 80};
            int[] laddersEnd = {22, 8, 26, 29, 84, 44, 67, 91, 99};

            int[] snakesStart = {17, 19, 21, 43, 56, 61, 64, 87, 93, 95, 98};
            int[] snakesEnd = {4, 7, 9, 23, 53, 18, 60, 24, 73, 75, 78};

           
            for (int i = 0; i < laddersStart.length; i++) {
                if (position == laddersStart[i]) {
                    System.out.println("Ladder found! Climbing up to " + laddersEnd[i]);
                    return laddersEnd[i];
                }
            }


            for (int i = 0; i < snakesStart.length; i++) {
                if (position == snakesStart[i]) {
                    System.out.println("Oh no! Bitten by a snake. Sliding down to " + snakesEnd[i]);
                    return snakesEnd[i];
                }
            }

            return position;
        }
    }
