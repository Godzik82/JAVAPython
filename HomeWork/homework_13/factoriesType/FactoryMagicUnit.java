package homework_13.factoriesType;

import homework_13.MagicUnitTypeDict;
import homework_13.magicUnitType.*;
import homework_13.unitType.MagicUnit;

public class FactoryMagicUnit {
    
    public MagicUnit create(MagicUnitTypeDict unit, Integer rank){
    
        switch (unit){
            case GENEE:
                return new Genee(rank);
            case MAG:
                return new Mag(rank);
            case WITCH:
                return new Witch(rank);
            case EXORCIST:
                return new Exorcist(rank);
            case SPELLMASTER:
                return new Spellmaster(rank);
            default:
                System.out.println("Такого Юнита не существует");
        }
        return null;
    }
}
