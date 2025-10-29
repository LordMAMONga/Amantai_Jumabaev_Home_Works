package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Magic extends Hero {
    private int boost;
    private boolean boosting = false;

    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.boosting && this.boost > 0) {
            for (Hero hero : heroes) {
                hero.setDamage(hero.getDamage() - this.boost);
            }
            this.boost = 0;
        }
        if (getHealth() > 0 && RPG_Game.getRoundNumber() <= 4 && !this.boosting) {

            this.boost = RPG_Game.random.nextInt(1, 11);
            System.out.println("Mage is boosting ALL heroes by " + this.boost);
            for (Hero hero : heroes) {
                hero.setDamage(hero.getDamage() + this.boost);
            }
            this.boosting = true;
        }
    }

    @Override
    public int getBoost() {
        return boost;
    }
}