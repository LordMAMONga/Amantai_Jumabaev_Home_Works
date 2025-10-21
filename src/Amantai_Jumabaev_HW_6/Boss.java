package Amantai_Jumabaev_HW_6;

public class Boss extends GameEntity{
    private Weapon bossWeapon;

    public Boss(int health, int damage, Weapon bossWeapon) {
        super(health,damage);
        this.bossWeapon = bossWeapon;
    }

    public Weapon getBossWeapon() {
        return bossWeapon;
    }

    public void setBossWeapon(Weapon bossWeapon) {
        this.bossWeapon = bossWeapon;
    }
    public void printInfo(){
        System.out.println("================================");
        System.out.println("          Boss hot bar");
        System.out.println("================================");
        System.out.println("Boss HP: "+getHealth());
        System.out.println("Boss damage: "+getDamage());
        System.out.println("---Boss equipment---");
        System.out.println("Boss weapon: " + getBossWeapon().getWeaponName());
        System.out.println("Boss style: " + getBossWeapon().getWeaponType());
    }
}
