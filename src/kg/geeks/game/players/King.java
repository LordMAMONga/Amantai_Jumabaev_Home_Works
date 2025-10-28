package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class King extends Hero {
    private int onePunch;
    public King(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.ONE_PUNCH);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        onePunch = RPG_Game.random.nextInt(11);
        if(onePunch == 3){
            System.out.println("Saitama just run past and accidentally killed the boss with one hit");
            boss.setHealth(boss.getHealth()-999999999);
        }
    }
}