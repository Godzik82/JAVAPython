package homework4;

import java.util.Arrays;

public class Unit {
    String name;
    int hp;
    int selfAttack;
    Armour armour;
    Weapon weapon;
    int alive;
    Bag bag;
    String[] currentWeapon;
    String[] currentArmour;


    public Unit(String name, int hp, int selfAttack){
        this.name = name;
        this.hp = hp;
        this.selfAttack = selfAttack;
        currentArmour = Dictionary.armours[HomeWork.rnd(Dictionary.armours.length)];
        this.armour = new Armour(currentArmour[0], Integer.parseInt(currentArmour[1]), Integer.parseInt(currentArmour[2]));
        currentWeapon = Dictionary.weapons[HomeWork.rnd(Dictionary.weapons.length)];
        this.weapon = new Weapon(currentWeapon[0], Integer.parseInt(currentWeapon[1]), Integer.parseInt(currentWeapon[2]));
        this.alive = 1;
        this.bag = new Bag();
        System.out.println("Создан юнит " + infoUnit());   
    }

    public void assault(Unit target){
        int damageTarget = (weapon.damage * weapon.exist) +
                            (selfAttack * (1 - weapon.exist)) -
                            (target.armour.selfArmour * target.armour.exist);
        if (damageTarget > 0) {
            target.hp -= damageTarget;
            if (target.hp > 0)
                System.out.printf(
                    "%s наносит %d урона %s (Осталось здоровья - %d).%n",
                    name, damageTarget, target.name, target.hp
                    );
            else death(target);
        } else System.out.printf("Удар %s не смог пробить броню %s%n", name, target.name);
        
        target.armour.downStrength();
        weapon.downStrength();
    }

    public void death(Unit target){
        target.alive = 0;
        System.out.printf("%s погиб%n", target.name);
        bag.addBag(target);
    }
    
    public String infoUnit(){
        String[] info = new String[] {
            name,
            Integer.toString(hp),
            Integer.toString(selfAttack),
            armour.name,
            weapon.name,
            Integer.toString(alive)
        };
        return Arrays.toString(info);

    }
}
