package homework_13.factoriesType;

import homework_13.FlyingUnitTypeDict;
import homework_13.flyingUnitType.*;
import homework_13.unitType.FlyingUnit;

public class FactoryFlyingUnit {
    
    public FlyingUnit create(FlyingUnitTypeDict unit, Integer rank){
        // GroundUnit groundUnit = null;
        
        switch (unit){
            case DRAGON:
                return new Dragon(rank);
            case MANTICORA:
                return new Manticora(rank);
            case EAGLE:
                return new Eagle(rank);
            case GRIFFON:
                return new Griffon(rank);
            case GARGULYA:
                return new Gargulya(rank);
            default:
                System.out.println("Такого Юнита не существует");
        }
        return null;
    }
}
