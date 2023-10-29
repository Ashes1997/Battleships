public class Battleship {
    protected boolean sunk;
    protected int health;
    protected int size;
    private static int maxNumber = 5;

    public Battleship(){ //constructor for size two battleships
        this.sunk = false;
        this.health = 2;
        this.size = this.health;

    }

    public boolean hit(){ //method for reducing battleship health
        this.health-=1;
        System.out.println("Battleship has " + this.health + " health remaining." );
        if (this.health <= 0){
            System.out.println("Battleship has sunk");
            this.sunk = true;
            return true; //returns true value for sunk
        } else {
            return false; //ship has health remaining and isn't sunk
        }

    }



    public boolean getSunk(){
        return this.sunk;
    }

    public int getSize(){
        int returnSize = this.size;
        return returnSize;
    }

}
