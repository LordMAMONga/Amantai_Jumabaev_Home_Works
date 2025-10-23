package Amantai__Jumabaev_HW_7;

public class Medic extends Hero{
    private int healPoints = 10;
    @Override
    public void applySuperAbility() {
        int healPoints = 10;
        System.out.println("The medic used the healing ability and healing " + healPoints);
    }
    public void  increaseExperience(){
        double percentGet = healPoints * 0.1;
        healPoints = healPoints + (int)percentGet;
        System.out.println("The medic has become more experienced and his healing has been increased by " + healPoints);
    }


    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }
}
