package unit;

import interfaces.Items;
import interfaces.Units;
import items.armour.Armour;
import items.weapon.Weapon;
import items.Bag;
import java.util.Random;

public abstract class Unit implements Units{
    static Random rand = new Random();
    String name;
    int hp;
    int alive;
    int selfAttack;
    int money;
    int maxWeigth;
    int mana;
    // Armour[] armour = new Armour[4];
    Armour[] armour;
    Weapon weapon;
    Bag bag;

    protected Unit(String name, int hp, int selfAttack, int maxWeigth) {
        this.name = name;
        this.hp = hp;
        this.selfAttack = selfAttack;
        this.alive = 1;
        this.maxWeigth = maxWeigth;
    }

    protected Unit(String name, int hp, int selfAttack){
        this.name = name;
        this.hp = hp;
        this.selfAttack = selfAttack;
        this.alive = 1;
    }

    protected Unit(String name, int hp, int selfAttack, int maxWeigth, int mana){
        this.name = name;
        this.hp = hp;
        this.selfAttack = selfAttack;
        this.alive = 1;
        this.maxWeigth = maxWeigth;
        this.mana = mana;
    }
    
    public void assault(Unit targetUnit){
        int damage = weaponExist() && weapon.getExist() == 1? weapon.damageWeapon() : getSelfAttack();
        int totalDamage = targetUnit.armourExist() ? damage - targetUnit.sumArmour() : damage;
        // System.out.printf("%s damage is %d, total damage %d%n", name, damage, totalDamage);
        // targetUnit.infoUnit();
        if (totalDamage > 0){
            targetUnit.hp -= totalDamage;
            if (targetUnit.hp > 0)
                System.out.printf("%s attack %s, get damage %d, health - %d%n",
                                    name, targetUnit.name, totalDamage, targetUnit.hp);
            else {
                targetUnit.death();
                money += DROP;
                System.out.printf("%s killed %s. Awards %d$%n", name, targetUnit.name, DROP);
                if (targetUnit.bag != null && bag != null)
                    bag.addBag(targetUnit, allWeight(), maxWeigth, name);
            }
        }
        else System.out.printf("%s attack %s and missed%n", name, targetUnit.name);
        if (weapon != null && weapon.getExist() == 1){
            weapon.brokeItem(name);
            
        }
        if (targetUnit.armour != null && targetUnit.getArmourExist() > 0){
            do{
                int i = rnd(targetUnit.armour.length);
                if (targetUnit.armour[i].getExist() == 1){
                    targetUnit.armour[i].brokeItem(name);
                    break;
                }
            } while (true);
        }
            
    }

    public static int rnd(int a){
        return rand.nextInt(a);
    }

    public int sumArmour(){
        int sumArmour = 0;
        for (int i=0; i < armour.length; i++)
            if (armour[i] != null)
                sumArmour += armour[i].getDefence() * armour[i].getExist();
        return sumArmour; 
    }

    public int getArmourExist(){
        int exsist = 0;
        for (int i = 0; i < 4; i++)
            if (armour[i].getExist() == 1)
                exsist++;
        return exsist;
    }

    public int sumWeightArmour(){
        int sumWeightArmour = 0;
        for (int i = 0; i < 4; i++)
            if (armour[i] != null)
                sumWeightArmour += armour[i].getWeight();
        return sumWeightArmour;
        }

    public int allWeight(){
        return weapon.getWeight() + sumWeightArmour() + bag.getWeight();
    }

    public Items[] getAllItems(){
        Items[] getAllItems = new Items[weapon.getExist()+getArmourExist()];
        int i = 0;
        if (weapon.getExist() == 1){
            getAllItems[0] = getWeapon();
            i++;
        }
        for (Items elm : armour)
            if (elm.getExist() == 1){
                getAllItems[i] = elm;
                i++;
            }
        return getAllItems;
    }

    public boolean armourExist(){
        return armour != null;
    }

    public boolean weaponExist() {
        return weapon != null;
    }

    public int getSelfAttack(){
        return selfAttack;
    }
    
    public String getName(){
        return name;
    }

    public void setSelfAttack(int attack){
        selfAttack = attack;
    }
    
    public void death(){
        alive = 0;
    }

    public void infoUnit(){
        System.out.printf("%n%s%nHealth: %d%nAttack: %d%n", name, hp, selfAttack);
        if (armour != null)
            for (Armour elm : armour){
                if (elm != null)
                    elm.infoItem();
        }
    }

    public int getAlive(){
        return alive;
    }

    public Weapon getWeapon(){
        return weapon;
    }
}

