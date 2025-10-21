package Amantai_Jumabaev_HW_5;

public class Hero {
    private int life;
    private int damage;
    private String ability;

    public Hero (int life, int damage, String ability){
        this.life = life;
        this.damage = damage;
        this.ability = ability;
    }
    public Hero (int life, int damage){
        this.life = life;
        this.damage = damage;
    }

    public int getLife() {
        return life;
    }

    public int getDamage() {
        return damage;
    }

    public String getAbility() {
        return ability;
    }
}
