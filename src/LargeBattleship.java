public class LargeBattleship extends Battleship {
    private static int maxNumber = 1;
    public LargeBattleship(){
        this.health = 3;
        this.size = this.health;
        this.sunk = false;

    }

    public static int getMaxNumber() {
        return maxNumber;
    }
}




