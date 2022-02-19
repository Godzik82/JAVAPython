package unit;

import engine.Dictionary;
import items.Bag;
import items.armour.*;
import items.weapon.MagicTorch;

public class MagicUnit extends Unit{

    public MagicUnit(String name,
                    int hp,
                    int selfAttack,
                    int maxWeigth,
                    int mana,
                    Armour[] armour,
                    MagicTorch weapon,
                    int money) {
        super(name, hp, selfAttack, maxWeigth, mana);
        this.armour = armour;
        this.weapon = weapon;
        this.money = money;
        this.bag = new Bag("Bag", 10, 5);
    }

    public static Unit createUnit() {
    String[] paramUnit = Dictionary.magicUnits[Unit.rnd(Dictionary.magicUnits.length)];
    String[] paramArmourBody = Dictionary.armoursBody[Unit.rnd(Dictionary.armoursBody.length)];
    String[] paramArmourHelmet = Dictionary.armoursHelmet[Unit.rnd(Dictionary.armoursHelmet.length)];
    String[] paramArmourBoots = Dictionary.armoursBoots[Unit.rnd(Dictionary.armoursBoots.length)];
    String[] paramArmourGoloves = Dictionary.armoursGloves[Unit.rnd(Dictionary.armoursGloves.length)];
    String[] paramWeapon = Dictionary.weaponsMagic[Unit.rnd(Dictionary.weaponsMagic.length)];
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
    MagicTorch weapon = new MagicTorch(
        paramWeapon[0],
        Integer.parseInt(paramWeapon[1]),
        Integer.parseInt(paramWeapon[2]),
        Integer.parseInt(paramWeapon[3])
    );

    return new MagicUnit(paramUnit[0],
                        Integer.parseInt(paramUnit[1]),
                        Integer.parseInt(paramUnit[2]),
                        Integer.parseInt(paramUnit[3]),
                        Integer.parseInt(paramUnit[4]),
                        armour,
                        weapon,
                        100
                        );
    }
    
}
