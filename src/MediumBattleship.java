public class MediumBattleship extends Battleship {
    private static int maxNumber = 2;
    public MediumBattleship(){
        this.health = 2;
        this.size = this.health;
        this.sunk = false;

    }

    public static int getMaxNumber() {
        return maxNumber;
    }
}




