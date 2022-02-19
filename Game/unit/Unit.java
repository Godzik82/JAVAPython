package unit;
import interfaces.Items;
import interfaces.Units;
import items.armour.Armour;
import items.weapon.Weapon;
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
    Armour[] armour = new Armour[4];
    Weapon weapon;

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
        int damage = weapon != null ? weapon.damageWeapon() : getSelfAttack();
        int totalDamage = damage - targetUnit.sumArmour();
        int stop = 0;
        if (totalDamage > 0){
            targetUnit.hp -= totalDamage;
            System.out.printf("%s attack %s, get damege %d%n", name, targetUnit.name, totalDamage);
        }
        else System.out.printf("%s attack %s and missed%n", name, targetUnit.name);
        if (weapon != null)
            weapon.brokeItem();
        if (targetUnit.armour != null )
            do {
                int i = rnd(3);
                if (targetUnit.armour[i] != null && targetUnit.getArmourExist() != 0) {
                        targetUnit.armour[i].brokeItem();
                        stop = 1;
                }
            } while (stop == 0);         
    }

    public static int rnd(int a){
        return rand.nextInt(a);
    }

    public int sumArmour(){
        int sumArmour = 0;
        for (int i=0; i < armour.length; i++)
            if (armour[i] != null)
                sumArmour += armour[i].getDefence();
        return sumArmour; 
    }

    public int getArmourExist(){
        int exsist = 0;
        for (int i = 0; i < 4; i++)
            if (armour[i].getExist() == 1)
                exsist++;
        return exsist;
    }

    public float sumWeightArmour(){
        float sumWeightArmour = 0;
        for (int i = 0; i < 4; i++)
            if (armour[i] != null)
                sumWeightArmour += armour[i].getWeight();
        return sumWeightArmour;
        }

    public float allWeight(){
        return weapon.getWeight() + sumWeightArmour();
    }

    public boolean armourExist(){
        return armour != null;
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
        for (Armour elm : armour){
            if (elm != null)
                elm.infoItem();
        }
    }
}

