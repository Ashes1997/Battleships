public class SmallBattleship extends Battleship {
    private static int maxNumber = 3;
    public SmallBattleship(){
        this.health = 1;
        this.size = this.health;
        this.sunk = false;

    }

    public static int getMaxNumber() {
        return maxNumber;
    }
}




