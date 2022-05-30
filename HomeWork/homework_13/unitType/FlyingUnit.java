package homework_13.unitType;

import java.util.Random;
import java.util.logging.Logger;

import homework_13.Unit;
import homework_13.unitStrategyType.FlyingUnitStrategy;

public class FlyingUnit extends Unit{
    
    public FlyingUnit(Integer rank){
        super(new FlyingUnitStrategy(), rank);
    }
}