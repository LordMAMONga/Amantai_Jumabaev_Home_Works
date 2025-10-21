package Amantai_Jumabaev_HW_6;

public class Weapon {
    private WeaponType weaponType;
    private String weaponName;

    public Weapon(WeaponType weaponType,String weaponName) {
        this.weaponType = weaponType;
        this.weaponName = weaponName;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
}
