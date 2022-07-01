package homework_13;

import java.util.logging.Logger;

import homework_13.Interfaces.UnitStrategy;

public class Unit {

    private static final Logger logger = Logger.getLogger(Unit.class.getName());
    protected String name;
    protected Integer hp;
    protected Integer selfAttack;
    protected String weapon;
    protected Integer armour;
    UnitStrategy unitStrategy;
    protected Integer rank;

    public Unit(UnitStrategy unitStrategy, Integer rank) {
        this.unitStrategy = unitStrategy;
        this.name = setName() + rank;
        this.hp = setHealth() * rank;
        this.selfAttack = setSelfAttack() * rank;
        if (setWeapon() != null)
            this.weapon = setWeapon() + rank;
        this.armour = setArmour() * rank;
        this.rank = rank;
    }

    public String setName(){
        return unitStrategy.setName();
    }
    
    public Integer setHealth(){
        return unitStrategy.setHealth();
    }
    
    public Integer setSelfAttack(){
        return unitStrategy.setSelfAttack();
    }
    public String setWeapon(){
        return unitStrategy.setWeapon();
    }

    public Integer setArmour(){
        return unitStrategy.setArmour();
    }

    public void chooseName(String name){
        this.name = name;
    }

    public void info(){
        StringBuilder params = new StringBuilder();
        params.append("Type - " + getClass().getName() + "\n");
        params.append("Name - " + name + "\n");
        params.append("Rank - " + rank + "\n");
        params.append("Health - " + hp + "\n");
        params.append("SelfAttack - " + selfAttack + "\n");
        params.append("Armour - " + armour + "\n");
        if (weapon != null)
            params.append("Weapon - " + weapon + "\n");
        logger.info("---- Created Unit ----\n" + params);
    }



    // public void setStrategy(UnitStrategy unitStrategy){
    //     this.unitStrategy = unitStrategy;
    // }

    // public void create(Integer rank){
    //     unitStrategy.create(rank);
    // }
    
    // public void info(){
    //     System.out.println(name + " " + hp);
    // }

    


}
