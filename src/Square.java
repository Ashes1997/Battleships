public class Square { //square class that makes up the board;
    private int row;
    private int column;
    private boolean shipPresence;
    private Battleship battleship;
    private boolean shot;

    public Square (int row, int column){ //constructor for square
        this.row = row;
        this.column = column;
        this.shipPresence = false;
        this.shot = false;

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isShipPresence() {
        return shipPresence;
    }

    public void setShipPresence(boolean shipPresence) {
        this.shipPresence = shipPresence;
    }

    public Battleship getBattleship() {
        return battleship;
    }

    public void setBattleship(Battleship battleship) { //sets Battleship and also sets ship presence to true
        this.battleship = battleship;
        this.shipPresence = true;
    }

    public boolean isShot() {

        return this.shot;
    }

    public void setShot(boolean shot) {

        this.shot = shot;
    }

    public String toString(){
        String string;
        if(this.battleship != null && this.shot){
            //if there is battleship associated with this square and it's been shot
            string = "x";
        } else if (this.shot) {
            //if the square has been shot but no battleship
            string = "o";
        } else {
            //if no player interaction
            string = "-";
        }
        return String.format("%3s", string);

    }
    }


