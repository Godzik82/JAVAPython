package homework_13.unitStrategyType;

import java.util.Random;

import homework_13.Interfaces.UnitStrategy;

public class FlyingUnitStrategy implements UnitStrategy{

    Random rnd = new Random();
    
    @Override
    public String setName() {
        return "FlyingUnit rank - ";    }

    @Override
    public String setWeapon() {
        return null;
        
    }
    @Override
    public Integer setArmour() {
        return rnd.nextInt(20,30);
        
    }
    @Override
    public Integer setHealth() {
        return rnd.nextInt(100, 150);
        
    }
    @Override
    public Integer setSelfAttack() {
        return rnd.nextInt(100,500);        
    }
    
}
