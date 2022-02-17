package engine;

import unit.*;
import items.armour.Armour;


public class Engine {

    public static Unit[][] createUnit(){
        Unit curentUnit = null;
        String[] paramUnit;
        String[] paramArmour;
        Unit[][] fighters = new Unit[2][3];

        System.out.println("Созданы юниты:");
        for (int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                switch (chooseTypeUnit()){
                    case 1:
                        curentUnit = GroundUnit.createUnit();
                        break;
                    case 2:
                        paramUnit = Dictionary.flyingUnits[Unit.rnd(Dictionary.flyingUnits.length)];
                        curentUnit = new FlyingUnit(paramUnit[0],
                                                    Integer.parseInt(paramUnit[1]),
                                                    Integer.parseInt(paramUnit[2])
                        );
                        break;
                    case 3:
                        paramUnit = Dictionary.magicUnits[Unit.rnd(Dictionary.magicUnits.length)];
                        curentUnit = new MagicUnit(paramUnit[0],
                                                    Integer.parseInt(paramUnit[1]),
                                                    Integer.parseInt(paramUnit[2]),
                                                    Integer.parseInt(paramUnit[3]),
                                                    Integer.parseInt(paramUnit[4])
                        );
                        break;
                    default:
                        System.out.println("Something wrong....");
                        break;
                }
                fighters[i][j] = curentUnit;
                curentUnit.infoUnit();
            }
        }
        return fighters;
    }
        

    public static int chooseTypeUnit(){
        return Unit.rnd(3) + 1;
    }
}

