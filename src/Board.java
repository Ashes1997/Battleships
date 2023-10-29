import java.util.Random;
public class Board {
    private int rows;
    private int columns;
    private Square[][] boardArray;
    private Battleship[] battleshipArray = new Battleship[6];

    public Board(int rows, int columns) { //constructor for board
        this.rows = rows;
        this.columns = columns;
        this.boardArray = new Square[this.rows][this.columns]; //creates array of squares
        this.generateBoard(); //generates board squares when constructor is called
        this.generateBattleships2(); //generates battleships when constructor is called

    }

    public void generateBoard() {
        for (int currentColumn = 0; currentColumn < this.columns; currentColumn++) { //loop to cycle through columns 0 to 9 (assuming this.columns = 10)
            for (int currentRow = 0; currentRow < this.rows; currentRow++) { //loop to cycle throw rows 0 to 9 (assuming this.rows = 10)
                this.boardArray[currentRow][currentColumn] = new Square(currentRow, currentColumn); //creates a new square and assigns it to that position within the array


            }
        }
    }

    public void generateBattleships2() {
        Random r = new Random();
        int i; //keeps track of position on battleship array
        int mediumCount = MediumBattleship.getMaxNumber(); //sets max medium battleships to 2
        for (i = 0 ; i < mediumCount; i++) { //loop to generate 2 medium battleships
            this.battleshipArray[i] = new MediumBattleship();
            int suitableRow;
            int suitableColumn;
            boolean suitableOrientation;
            int size = this.battleshipArray[i].getSize();

            while (true) { //loop for generating positions
                int randRow = r.nextInt(this.rows);
                int randColumn = r.nextInt(this.columns);
                boolean randOrientation = r.nextBoolean(); //if true vertical, if false horizontal
                if (checkPositions(randRow, randColumn, size, randOrientation)){
                    suitableRow = randRow;
                    suitableColumn = randColumn;
                    suitableOrientation = randOrientation;
                    break;
                }
            }
            //positions are correct so now must assign battleship to squares
            setPositions(suitableRow,suitableColumn, size, suitableOrientation, this.battleshipArray[i]);
            //sets all squares to IsShipPresence = true and assigns battleships to them
        }
        int j;
        int smallCount = SmallBattleship.getMaxNumber();
        for (j = i; j<(i+smallCount); j++){ //to ensure previously written indices don't get overwritten
            //generates 3 small battleships
            this.battleshipArray[j] = new SmallBattleship();
            int suitableRow;
            int suitableColumn;
            boolean suitableOrientation;
            int size = this.battleshipArray[j].getSize();

            while (true) { //loop for generating positions
                int randRow = r.nextInt(this.rows);
                int randColumn = r.nextInt(this.columns);
                boolean randOrientation = r.nextBoolean(); //if true vertical, if false horizontal
                if (checkPositions(randRow, randColumn, size, randOrientation)){
                    suitableRow = randRow;
                    suitableColumn = randColumn;
                    suitableOrientation = randOrientation;
                    break;
                }
            }
            //positions are correct so now must assign battleship to squares
            setPositions(suitableRow,suitableColumn, size, suitableOrientation, this.battleshipArray[j]);
            //sets all squares to IsShipPresence = true and assigns battleships to them

        }
        int k;
        int largeCount = LargeBattleship.getMaxNumber();
        for(k = j; k<(j+largeCount); k++){
            this.battleshipArray[k] = new LargeBattleship();
            int suitableRow;
            int suitableColumn;
            boolean suitableOrientation;
            int size = this.battleshipArray[k].getSize();

            while (true) { //loop for generating positions
                int randRow = r.nextInt(this.rows);
                int randColumn = r.nextInt(this.columns);
                boolean randOrientation = r.nextBoolean(); //if true vertical, if false horizontal
                if (checkPositions(randRow, randColumn, size, randOrientation)){
                    suitableRow = randRow;
                    suitableColumn = randColumn;
                    suitableOrientation = randOrientation;
                    break;
                }
            }
            //positions are correct so now must assign battleship to squares
            setPositions(suitableRow,suitableColumn, size, suitableOrientation, this.battleshipArray[k]);
            //sets all squares to IsShipPresence = true and assigns battleships to them
        }




    }

    public Square getBoardSquare (int rowGuess, int columnGuess){

        return this.boardArray [rowGuess][columnGuess];
    }





    public boolean checkForShips(){
        for (int i=0; i<6;i++){
            if(!this.battleshipArray[i].getSunk()){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String boardPrint="   0  1  2  3  4  5  6  7  8  9\n";
        for (int printRow = 0; printRow < this.rows;printRow++){ //prints one row at a time
            boardPrint += printRow;
            for (int printColumn = 0; printColumn < this.rows;printColumn++){ //prints all columns within row

                boardPrint+= this.boardArray[printRow][printColumn].toString(); //uses toString of square

                }
            boardPrint +="\n"; //line break at the end of a row.
            }
        return boardPrint;
    }



    public boolean checkPositions(int row, int column, int size, boolean orientation){
        //method for checking validity of random position, true = viable position(s)
        if(row+size>this.rows){ //initially was (row + size - 1> this.rows - 1 but simplified for clarity
            return false; //row coordinates will be out of bounds
        }
        if (column+size>this.columns){
            return false; // column coordinates will be out of bounds

        }
        if (orientation){
            //for vertical orientations
            for (int i=0;i<size;i++){ //loop checking positions up to max
                if (this.boardArray[row][column+i].isShipPresence()){
                    return false; //one of the positions suggested has a ship in it
                }
            }
            return true;
        }else{ // for horizontal orientations
            //for vertical orientations
            for (int j=0;j<size;j++){ //loop checking positions up to max
                if (this.boardArray[row+j][column].isShipPresence()){
                    return false; //one of the positions suggested has a ship in it
                }
            }
            return true;
        }


    }

    public void setPositions(int row, int column, int size, boolean orientation, Battleship battleship){
        for (int i = 0; i<size; i++){ //loops through all applicable squares of suggested starting coordinate
            if (orientation){ //if vertical orientation

                this.boardArray[row][column+i].setBattleship(battleship); //assigns battleship to square and sets ship to true
            }else{ //if horizontal

                this.boardArray[row+i][column].setBattleship(battleship);  //assigns battleship to square and sets ship to true
            }
        }
    }


    public void generateBattleships() {
        Random r = new Random();
        for (int i = 0; i < 5; i++) { //loop to generate 5 battleships
            this.battleshipArray[i] = new Battleship();


            while (true) { //loop for generating positions
                int firstRow = r.nextInt(this.rows);
                int firstColumn = r.nextInt(this.columns);
                boolean orientation = r.nextBoolean(); //if true vertical, if false horizontal

                if (orientation && (firstColumn + 1) > 9)
                    continue; //returns to beginning of loop if the suggested second position of ship is out of bounds
                if (!orientation && (firstRow + 1) > 9)
                    continue; //returns to beginning of loop if the suggested second position of ship is out of bounds

                if (this.boardArray[firstRow][firstColumn].isShipPresence()) {
                    continue; //goes to beginning of while loop if a ship is present at the randomly assigned coordinate
                } else { // now checking second position for presence of ship adjacent to first
                    if (orientation && this.boardArray[firstRow][firstColumn + 1].isShipPresence()) {
                        continue; /* goes to beginning of loop since second position is already occupied by a ship so
                        new position must be generated */
                    } else if (!orientation && this.boardArray[firstRow + 1][firstColumn].isShipPresence()) {
                        continue; /* goes to beginning of loop since second position is already occupied by a ship so
                         new position must be generated */
                    } else { //both positions are valid so now the battleship position can be set
                        this.boardArray[firstRow][firstColumn].setShipPresence(true); //sets first position
                        this.boardArray[firstRow][firstColumn].setBattleship(this.battleshipArray[i]);
                        if (orientation) { //if vertical
                            this.boardArray[firstRow][firstColumn + 1].setShipPresence(true); //sets second position
                            this.boardArray[firstRow][firstColumn + 1].setBattleship(this.battleshipArray[i]);
                            break;
                        } else { //if horizontal
                            this.boardArray[firstRow + 1][firstColumn].setShipPresence(true); //sets second position
                            this.boardArray[firstRow + 1][firstColumn].setBattleship(this.battleshipArray[i]);
                            break;
                        }
                    }


                }

            }

        }
    }
}










