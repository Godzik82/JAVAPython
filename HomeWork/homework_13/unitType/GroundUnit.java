package homework_13.unitType;

import homework_13.Unit;
import homework_13.unitStrategyType.GroundUnitStrategy;

public class GroundUnit extends Unit{
    
    public GroundUnit(Integer rank){
        super(new GroundUnitStrategy(), rank);
    }
}
