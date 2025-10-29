package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Hacker extends Hero {
    private int stealHealth = 20;
    //Забирать нное количество хп босса и переводить в одному герою хп героев через раунд
    public Hacker(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.HACK);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
      if(RPG_Game.getRoundNumber() % 2 != 0){
          int getHealth = RPG_Game.random.nextInt(heroes.length);
          for (int i = 0; i <heroes.length ; i++) {
              if(heroes[i] == heroes[getHealth] && heroes[i].getHealth()!= 0){
                  System.out.println("HACKER takes the boss's health and gives it to one of the heroes named " +
                          heroes[i].getName()+" by " + stealHealth+ " units");
                  boss.setHealth(boss.getHealth() - stealHealth);
                  heroes[i].setHealth(heroes[i].getHealth() + stealHealth);
              }
          }
      }
    }
}