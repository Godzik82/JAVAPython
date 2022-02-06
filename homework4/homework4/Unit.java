package homework4;

public class Unit {
    String name;
    int hp;
    int selfAttack;
    Armour armour;
    Weapon weapon;
    int alive;
    Bag bag;


    public Unit(String name, int hp){
        this.name = name;
        this.hp = hp;
        this.selfAttack = 2;
        this.armour = new Armour("Броня 1", 15, 5);
        this.weapon = new Weapon("Меч-кладенец", 30, 5);
        this.alive = 1;
        this.bag = new Bag();
        System.out.println("Создан юнит " + name);
        
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
    
}
