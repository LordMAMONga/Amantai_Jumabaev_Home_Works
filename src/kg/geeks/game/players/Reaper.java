package kg.geeks.game.players;

public class Reaper extends Hero {

    private final double firstPercent = 0.30;
    private final double secondPercent = 0.15;
    private final int originalDamage;
    private final int originalHealth;

    public Reaper(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.REVENGE);
        this.originalDamage = damage;
        this.originalHealth = health;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        int firstStageHealth = (int) (this.originalHealth * firstPercent);
        int secondStageHealth = (int) (this.originalHealth * secondPercent);

        this.setDamage(this.originalDamage);
        int newDamage = this.originalDamage;

        if (this.getHealth() <= secondStageHealth) {
            newDamage = this.originalDamage * 3;
            System.out.println("The Reaper " + this.getName() + " damage is tripled!");
        }

        else if (this.getHealth() <= firstStageHealth) {
            newDamage = this.originalDamage * 2;
            System.out.println("The Reaper " + this.getName() + " damage is doubled (Health!");
        }

        this.setDamage(newDamage);
    }
}