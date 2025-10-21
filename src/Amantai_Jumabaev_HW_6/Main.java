import Amantai_Jumabaev_HW_6.Boss;
import Amantai_Jumabaev_HW_6.Skeleton;
import Amantai_Jumabaev_HW_6.Weapon;
import Amantai_Jumabaev_HW_6.WeaponType;
//Hi sensei
public static void main(){
    //Задание 5
    Weapon bossWeapon = new Weapon(WeaponType.MELEE,"Sword");
    Boss firstBoss = new Boss(1500,50,bossWeapon);

    //Задание 10
    Weapon skeletonArcherWeapon = new Weapon(WeaponType.RANGED,"Bow");
    Skeleton noviceArcher = new Skeleton(700,40,skeletonArcherWeapon,100);
    Skeleton experiencedArcher = new Skeleton(800,100,skeletonArcherWeapon,50);


    noviceArcher.printInfo();
    experiencedArcher.printInfo();
    firstBoss.printInfo();
}
