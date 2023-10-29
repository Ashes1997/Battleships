import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board boardOne = new Board(4, 4);//creates board object with squares and battleships
        System.out.println("Player 1, please enter your name below:");
        String player1Name = scanner.nextLine();
        System.out.println("Player 2, please enter your name below");
        String player2Name = scanner.nextLine();


        Player player1 = new Player(player1Name, boardOne);
        Player player2 = new Player(player2Name, boardOne);
        boolean endGame = false; //variable used to end while loop containing repeat of game.
        while (true) { //players take turns until all ships sank
            endGame = player1.takeTurn();
                if (endGame){
                    break;
                }
            endGame = player2.takeTurn();
                if (endGame){
                    break;
                }
        }
        System.out.println(boardOne);
        System.out.println("Game over! All the ships are sunk.");
        System.out.println(player1);
        System.out.println(player2);
        if (player1.getScore()> player2.getScore()){ //player 1 has a higher score
            System.out.println(player1.getName() + " has won!");
        } else if (player1.getScore() < player2.getScore()) { //player 2 has a higher score
            System.out.println(player2.getName() + " has won!");
        } else { //it's a draw
            System.out.println("It's a draw!");
        }
    }


}






