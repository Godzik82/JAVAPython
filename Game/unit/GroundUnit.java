package unit;
import items.armour.*;
import items.weapon.Sword;
import items.weapon.Weapon;
import engine.Dictionary;

public class GroundUnit extends Unit{

    public GroundUnit(String name, int hp, int selfAttack, int maxWeigth, Armour[] armour, Sword weapon, int money) {
        super(name, hp, selfAttack, maxWeigth);
        this.armour = armour;
        this.weapon = weapon;
        this.money = money;
    }

    public static Unit createUnit(){
        String[] paramUnit = Dictionary.groundUnits[Unit.rnd(Dictionary.groundUnits.length)];
        String[] paramArmourBody = Dictionary.armoursBody[Unit.rnd(Dictionary.armoursBody.length)];
        String[] paramArmourHelmet = Dictionary.armoursHelmet[Unit.rnd(Dictionary.armoursHelmet.length)];
        String[] paramArmourBoots = Dictionary.armoursBoots[Unit.rnd(Dictionary.armoursBoots.length)];
        String[] paramArmourGoloves = Dictionary.armoursGloves[Unit.rnd(Dictionary.armoursGloves.length)];
        String[] paramWeapon = Dictionary.weaponsGround[Unit.rnd(Dictionary.weaponsGround.length)];
        Armour[] armour = new Armour[] {
            new Helmet(
                paramArmourHelmet[0],
                Integer.parseInt(paramArmourHelmet[1]),
                Integer.parseInt(paramArmourHelmet[2]),
                Integer.parseInt(paramArmourHelmet[3])
            ),
            new Body(
                paramArmourBody[0],
                Integer.parseInt(paramArmourBody[1]),
                Integer.parseInt(paramArmourBody[2]),
                Integer.parseInt(paramArmourBody[3])
            ),
            new Gloves(
                paramArmourGoloves[0],
                Integer.parseInt(paramArmourGoloves[1]),
                Integer.parseInt(paramArmourGoloves[2]),
                Integer.parseInt(paramArmourGoloves[3])
            ),
            new Boots(
                paramArmourBoots[0],
                Integer.parseInt(paramArmourBoots[1]),
                Integer.parseInt(paramArmourBoots[2]),
                Integer.parseInt(paramArmourBoots[3])
            )
        };
        Sword weapon = new Sword(
            paramWeapon[0],
            Float.parseFloat(paramWeapon[1]),
            Integer.parseInt(paramWeapon[2]),
            Integer.parseInt(paramWeapon[3])
        );

        return new GroundUnit(paramUnit[0],
                                Integer.parseInt(paramUnit[1]),
                                Integer.parseInt(paramUnit[2]),
                                Integer.parseInt(paramUnit[3]),
                                armour,
                                weapon,
                                100
                                );
    }
}
