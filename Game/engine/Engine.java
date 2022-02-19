package engine;

import unit.*;

import java.util.concurrent.TimeUnit;

import items.armour.Armour;


public class Engine {
    static Unit[][] fighters = new Unit[2][3];

    public static Unit[][] createUnit(){
        Unit curentUnit = null;
        String[] paramUnit;
        

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

    public static void batle() throws InterruptedException {
    int endBattle = 1;
    int turn = 0;
    
    System.out.println("Batle begins...");
    System.out.printf("Player 1 - %s%n", fighters[0][0].getName());
    System.out.printf("Player 2 - %s%n", fighters[1][0].getName());
    

    do{
        fighters[turn % 2][0].assault(fighters[1 - (turn % 2)][0]);
        if (defeatTeam(fighters[0]) == 0 || defeatTeam(fighters[1]) == 0)
            endBattle = 0;
        turn++;
        TimeUnit.MILLISECONDS.sleep(300);
    }
    while(endBattle == 1);
    }

    public static int defeatTeam(Unit[] fighters){
        int defeat = 0;
        for (Unit elm : fighters)
            if (elm == null)
                defeat++;
        return defeat;

    }
}

