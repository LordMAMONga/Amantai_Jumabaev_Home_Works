package Practical_Works;

import java.util.Random;

public class task {

    public static int bossHealth = 1500;
    public static int bossDamage = 70;
    public static String bossDefence;
    // НОВАЯ ПЕРЕМЕННАЯ: Для управления станом Тора
    public static boolean bossIsStunned = false;

    public static int[] heroesHealth = {290, 270, 250, 241, 180, 350, 400, 280};
    public static int[] heroesDamage = {20, 15, 15, 0, 25, 5, 0, 10};
    public static String[] heroesName = {"Warrior", "Mage", "Kinetic", "Medic", "Lucky", "Golem",
            "Witcher", "Thor"};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Magical", "Physical",
            "Physical", "Kinetic", "Physical"};
    public static int roundNumber;
    public static String message;
    public static boolean healHeroes;
    public static int medicIndex = 3;
    public static int golemIndex = 5;
    public static int luckyIndex = 4;
    public static int witcherIndex = 6;
    public static int thorIndex = 7;

    public static void playRound() {
        roundNumber++;
        // СБРОС СТАНА: Сбрасываем эффект стана в начале раунда
        bossIsStunned = false;

        witcherAbility();
        chooseBossDefence();

        // ПРИМЕНЕНИЕ СТАНА: Тор пытается оглушить Босса
        thorAbility();

        bossAttacks();
        heroesAttack();
        medicAbility();
        printStatistics();
    }

    // НОВЫЙ ИСПРАВЛЕННЫЙ МЕТОД THOR
    public static void thorAbility(){
        // Тор действует, только если он ЖИВ
        if(heroesHealth[thorIndex] > 0){
            Random random = new Random();
            // 50% шанс (true)
            bossIsStunned = random.nextBoolean();

            if(bossIsStunned){
                System.out.println("⚡ THOR stunned the Boss! Boss misses this round.");
            }
        }
    }

    public static void witcherAbility() {
        if (heroesHealth[witcherIndex] > 0) {
            int heroToReviveIndex = -1;

            for (int i = 0; i < heroesHealth.length; i++) {
                if (i != witcherIndex && heroesHealth[i] <= 0) {
                    heroToReviveIndex = i;
                    break;
                }
            }

            if (heroToReviveIndex != -1) {
                heroesHealth[heroToReviveIndex] = heroesHealth[witcherIndex];
                heroesHealth[witcherIndex] = 0;
                System.out.println("Witcher revived " + heroesName[heroToReviveIndex] +
                        " with " + heroesHealth[heroToReviveIndex] + " HP and sacrificed himself.");
            }
        }
    }


    public static void medicAbility() {
        if (heroesHealth[medicIndex] > 0) {
            int heroHealIndex = -1;
            int minHealth = 101;
            for (int i = 0; i < heroesHealth.length; i++) {
                if (i != medicIndex && heroesHealth[i] > 0 && heroesHealth[i] < minHealth) {
                    minHealth = heroesHealth[i];
                    heroHealIndex = i;
                }
            }
            if (heroHealIndex != -1) {
                Random random = new Random();
                int heal = random.nextInt(11, 21);
                heroesHealth[heroHealIndex] += heal;
                System.out.println("Medic healed " + heroesName[heroHealIndex] + " on " + heal);
            }
        }
    }

    public static void main(String[] args) {
        printStatistics();
        while (!isGameOver()) {
            playRound();
        }
    }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    public static void chooseBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefence = heroesAttackType[randomIndex];
    }

    public static void heroesAttack() {
        healHeroes = false;
        message = null;
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                int damage = heroesDamage[i];
                // КРИТИЧЕСКОЕ ИСПРАВЛЕНИЕ: Сравнение строк
                if (bossDefence.equals(heroesAttackType[i])) {
                    Random random = new Random();
                    int coefficient = random.nextInt(2, 11);
                    damage = damage * coefficient;
                    message = heroesName[i] + " applied critical damage: " + damage;
                }
                bossHealth = bossHealth - damage;
                if (bossHealth < 0) {
                    bossHealth = 0;
                }
            }
        }
    }

    public static int getReducedDamage() {
        if (heroesHealth[golemIndex] <= 0) {
            return bossDamage;
        }
        return bossDamage - (bossDamage / 5);
    }

    public static void bossAttacks() {
        // ПРОВЕРКА СТАНА: Если Босс оглушен, пропускаем его атаку.
        if (bossIsStunned) {
            return;
        }

        int totalTransferredDamage = 0;
        int damageFraction = bossDamage / 5;
        int reducedDamage = getReducedDamage();

        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (i == luckyIndex) {
                    Random random = new Random();
                    if (random.nextInt(4) == 0) {
                        System.out.println(heroesName[luckyIndex] + " dodged the attack!");
                        continue;
                    }
                }
                if (i != golemIndex) {
                    heroesHealth[i] -= reducedDamage;
                    if (heroesHealth[golemIndex] > 0) {
                        totalTransferredDamage += damageFraction;
                    }
                }
            }
        }
        if (heroesHealth[golemIndex] > 0) {
            heroesHealth[golemIndex] -= totalTransferredDamage;
        }
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] < 0) {
                heroesHealth[i] = 0;
            }
        }
    }

    // ИСПРАВЛЕННАЯ СТРУКТУРА: printStatistics() находится здесь, вне bossAttacks()
    public static void printStatistics() {
        System.out.println("ROUND " + roundNumber + " ------------------");
        System.out.println("Boss health: " + bossHealth + " damage: " + bossDamage +
                " defence: " + (bossDefence == null ? "No defence" : bossDefence));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesName[i] +
                    " health: " + heroesHealth[i] +
                    " damage: " + heroesDamage[i]);
        }
        if (message != null) {
            System.out.println(message);
        }
    }
}
