package Amantai_Jumabaev_HW_5;

public class Main {
    public static void main(String[] args){
        Boss finalBoss = new Boss();

        finalBoss.setLife(700);
        finalBoss.setDamage(50);
        finalBoss.setDefence("no defence");
        System.out.println("-------Boss's hot bar-------");
        System.out.println("Boss health:" + finalBoss.getLife() +
                "\nBoss damage:" + finalBoss.getDamage()  +
                "\nBoss defence:" + finalBoss.getDefence());
        System.out.println("-------Heroes information-------");
        Hero[] party = createHeroes();
        String[] heroNames = {"Warrior", "Mage", "Healer"};
        for(int i = 0; i < party.length; i++){
            Hero hero = party[i];
            String name = heroNames[i];
            System.out.println("-------" + name + "-------"  +
                    "\nHero health: " + hero.getLife() +
                    "\nHero damage: " + hero.getDamage() +
                    "\nHero ability: " + hero.getAbility());
        }

        }
    public static Hero[] createHeroes(){
        Hero warrior = new Hero(300,25);
        Hero mage = new Hero(250,30,"Flame shot");
        Hero healer = new Hero(240,15,"Heal");
        return new Hero[]{warrior,mage,healer};
    }
}

