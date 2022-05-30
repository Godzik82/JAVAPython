package homework_13.groundUnitType;

import homework_13.unitType.GroundUnit;

public class Archer extends GroundUnit{

    public Archer(Integer rank) {
        super(rank);
        this.name = "Archer";
        this.weapon = "Crossbow";
    }
}
