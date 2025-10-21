package Amantai_Jumabaev_HW_6;

public class Skeleton extends Boss{
    private int numberOfArrows;
    public Skeleton(int health, int damage, Weapon bossWeapon,int numberOfArrows) {
        super(health, damage, bossWeapon);
        this.numberOfArrows = numberOfArrows;
    }

    public int getNumberOfArrows() {
        return numberOfArrows;
    }

    public void setNumberOfArrows(int numberOfArrows) {
        this.numberOfArrows = numberOfArrows;
    }

    @Override
    public void printInfo(){
        System.out.println("\n\n  ATTENTION RARE BOSS SKELETON");
        super.printInfo();
        System.out.println("Number of arrows: " + getNumberOfArrows());
    }
}
