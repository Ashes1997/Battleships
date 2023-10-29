
import java.util.Scanner;
public class Player {
    private Board board;
    private String name;
    private int score;

    public Player(String name, Board board) { //Player constructor
        this.name = name;
        this.board = board;
        this.score = 0;
    }

    public boolean takeTurn() { //method for taking turn (to be called in main) NEED TO RETURN BOOLEAN
        Scanner scan = new Scanner(System.in);
        System.out.println(this.board);
        System.out.println(); //adds line break before go to improve readability
        System.out.println(this.name + ", take your turn \n" +
                "input your guess in the following format of: row column \n" +
                "e.g. 6 5 = row 6, column 5 ");


        String guess = scan.nextLine();
        String[] guessArray = guess.split(" "); //splits input of row and column up by space and inputs into array
        
        int rowGuess = Integer.valueOf(guessArray[0]);
        if (rowGuess < 0 || rowGuess > 9) {
            System.out.println("Guess out of bounds, turn lost.");
            return false;
        }
        int columnGuess = Integer.valueOf(guessArray[1]);
        if (columnGuess < 0 || columnGuess > 9) {
            System.out.println("Guess out of bounds, turn lost."); //prevents improper guess
            return false;
        }

        Square squareGuess = this.board.getBoardSquare(rowGuess, columnGuess); /* create square reference and point
         to square object on board */
        if (squareGuess.isShot()) { // if guess has already been made before, make another guess
            System.out.println("Guess has been made before, turn is lost."); //prevents improper guess
            return false;

            }
        squareGuess.setShot(true); //updates square to shot
        if (squareGuess.isShipPresence()) {
            System.out.println("Hit!");
            Battleship battleshipGuess = squareGuess.getBattleship();
            boolean sunk = battleshipGuess.hit();
            if (sunk) {
                this.score += 1;
                }

        } else {
            System.out.println("Miss!");
        }
        if (this.board.checkForShips()) {
            return false; //still ships remaining so game continues
        } else {
            return true; //last ship removed from board
        }



    }

    public String toString() {

        return name + " has a score of " + score; //need to complete
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}

