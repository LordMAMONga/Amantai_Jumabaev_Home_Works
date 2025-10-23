package Amantai__Jumabaev_HW_7;

public class Main {
    static void main() {
        Magic magic = new Magic();
        Medic medic = new Medic();
        Warrior warrior = new Warrior();
        HavingSuperAbility[] heroes = {magic,medic,warrior};
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].applySuperAbility();
            if(heroes[i] instanceof Medic){
                medic.increaseExperience();
            }
        }
    }
}
