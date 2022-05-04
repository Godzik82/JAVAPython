package homework_13.factoriesType;

import homework_13.GroundUnitTypeDict;
import homework_13.unitType.GroundUnit;
import homework_13.groundUnitType.*;

public class FactoryGroundUnit {

    public GroundUnit create(GroundUnitTypeDict unit, Integer rank){
        // GroundUnit groundUnit = null;

        switch (unit){
            case ORK:
                return new Ork(rank);
            case PALADIN:
                return new Paladin(rank);
            case KNIGTH:
                return new Knight(rank);
            case ARCHER:
                return new Archer(rank);
            case ELF:
                return new Elf(rank);
            default:
                System.out.println("Такого Юнита не существует");
        }
        return null;
    }
    
    // public GroundUnit paladin(Integer rank){
    //     GroundUnit groundUnit = new GroundUnit(rank);
    //     groundUnit.chooseName("Paladin");
    //     return groundUnit;
    // }

    // public GroundUnit knigth(Integer rank){
    //     GroundUnit groundUnit = new GroundUnit(rank);
    //     groundUnit.chooseName("Knigth");
    //     return groundUnit;
    // }

    // public GroundUnit archer(Integer rank){
    //     GroundUnit groundUnit = new GroundUnit(rank);
    //     groundUnit.chooseName("Archer");
    //     return groundUnit;
    // }

    // public GroundUnit elf(Integer rank){
    //     GroundUnit groundUnit = new GroundUnit(rank);
    //     groundUnit.chooseName("Elf");
    //     return groundUnit;
    // }

    // public GroundUnit ork(Integer rank){
    //     GroundUnit groundUnit = new GroundUnit(rank);
    //     groundUnit.chooseName("Ork");
    //     return groundUnit;
    // }
    

}
