package engine;

import unit.*;
import java.util.concurrent.TimeUnit;



public class Engine {
    static Unit[][] fighters = new Unit[2][3];
    

    public static Unit[][] createUnit(){
        Unit curentUnit = null;
        
        System.out.println("Созданы юниты:");
        for (int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                switch (chooseTypeUnit()){
                    case 1:
                        curentUnit = GroundUnit.createUnit();
                        break;
                    case 2:
                        curentUnit = FlyingUnit.createUnit();
                        break;
                    case 3:
                        curentUnit = MagicUnit.createUnit();
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

    public static int chooseUnit(Unit[] fighters){
        
        int i = Unit.rnd(3);
        while (fighters[i].getAlive() == 0)
            i = Unit.rnd(3);
        // System.out.println(i);
        return i;
    }
    public static void battle() throws InterruptedException {

    int endBattle = 1;
    int turn = 0;
    
    System.out.println("Battle begins...");    

    do{        
        fighters[turn % 2][chooseUnit(fighters[turn % 2])].assault(fighters[1 - (turn % 2)][chooseUnit(fighters[1 - (turn % 2)])]);
        turn++;
        // System.out.println(Integer.toString(turn) + 
        //                     Integer.toString(defeatTeam(fighters[0])) + 
        //                     Integer.toString(defeatTeam(fighters[1]))
        // );
        if (defeatTeam(fighters[0]) == 0 || defeatTeam(fighters[1]) == 0)
            endBattle = 0;
        // TimeUnit.MILLISECONDS.sleep(300);
    }
    while (endBattle == 1);

    }

    public static int defeatTeam(Unit[] fighters){
        int defeat = fighters.length;
        for (Unit elm : fighters)
            if (elm.getAlive() == 0)
                defeat--;
        return defeat;

    }
}

