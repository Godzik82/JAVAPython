package homework_4;

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
        infoUnit();   
    }

    public void assault(Unit target, String name){
        int damageTarget = (weapon.damage * weapon.exist) +
                            (selfAttack * (1 - weapon.exist)) -
                            (target.armour.selfArmour * target.armour.exist);
        if (damageTarget > 0) {
            target.hp -= damageTarget;
            if (target.hp > 0){
                System.out.printf(
                "%s наносит %d урона %s (Осталось здоровья - %d).%n",
                name, damageTarget, target.name, target.hp);
                target.armour.downStrength();
                weapon.downStrength();
            }
            else death(target, name);
        } else{
            System.out.printf("Удар %s не смог пробить броню %s%n", name, target.name);
            target.armour.downStrength();
            weapon.downStrength();
        }
    }

    public void death(Unit target, String name){
        target.alive = 0;
        System.out.printf("%s погиб от удара %s%n", target.name, name);
        bag.addBag(target, name);
    }
    
    public void infoUnit(){
        System.out.printf("%n%s%nЗдоровье: %d%nАтака: %d%n", name, hp, selfAttack);
        System.out.printf("***Экипировка***%nБроня %s (Защита - %d, Прочность - %d)%nОружие %s (Атака - %d, Прочность - %d)%n",
                            armour.name, armour.selfArmour, armour.strength, weapon.name, weapon.damage, weapon.strength);
    }
}
