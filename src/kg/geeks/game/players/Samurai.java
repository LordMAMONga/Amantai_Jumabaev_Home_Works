package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Samurai extends Hero {
    private int shuriken;

    public Samurai(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SHURIKEN);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        this.shuriken = RPG_Game.random.nextInt(2);
        int shurikenDamage = RPG_Game.random.nextInt(4, 16);
        if (this.shuriken == 0) {
            System.out.println("The Samurai used ability shuriken which dealt " + shurikenDamage +
                    " damage to the boss");
            boss.setHealth(boss.getHealth() - shurikenDamage);
        } else if (this.shuriken == 1) {
            System.out.println("The Samurai used ability shuriken which dealt " + shurikenDamage +
                    " healing to the boss");
            boss.setHealth(boss.getHealth() + shurikenDamage);
        }
    }
}
