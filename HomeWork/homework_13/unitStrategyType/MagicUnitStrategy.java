package homework_13.unitStrategyType;

import java.util.Random;

import homework_13.Interfaces.UnitStrategy;

public class MagicUnitStrategy implements UnitStrategy{

    Random rnd = new Random();
    
    @Override
    public String setName() {
        return "MagicUnit rank - ";
    }

    @Override
    public String setWeapon() {
        return "Spell tourch: class ";
        
    }
    @Override
    public Integer setArmour() {
        return rnd.nextInt(5,10);
        
    }
    @Override
    public Integer setHealth() {
        return rnd.nextInt(25, 50);
        
    }
    @Override
    public Integer setSelfAttack() {
        return rnd.nextInt(1,5);        
    }

    // @Override
    // public void info() {
    //     StringBuilder params = new StringBuilder();
    //     params.append("Name - " + name + "\n");
    //     params.append("Health - " + hp + "\n");
    //     params.append("SelfAttack - " + selfAttack + "\n");
    //     params.append("Armour - " + armour + "\n");
    //     params.append("Weapon - " + weapon + "\n");
    //     params.append("Mana - " + mana + "\n");
    //     logger.info("---- Created Unit ----\n" + params);
        
    // // }


    
}
