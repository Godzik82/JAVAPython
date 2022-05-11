package engine;

import unit.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

import items.armour.Armour;
import items.weapon.Weapon;



public class Engine {
    static Unit[][] fighters = new Unit[2][3];
    
    public static Unit[][] createUnit(){
        // DBHandler dbHandler = DBHandler.getInstance();
        Unit curentUnit = null;
        String typeUnit;
        Weapon weapon;
        Armour[] armour;
        
        System.out.println("Созданы юниты:");
        for (int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                switch (chooseTypeUnit()){
                    case 1:
                        // armour = new Armour[] {
                        //     dbHandler.getItemArmour("helmet"),
                        //     dbHandler.getItemArmour("body"),
                        //     dbHandler.getItemArmour("gloves"),
                        //     dbHandler.getItemArmour("boots")};
                        // weapon = dbHandler.getWeapon("sword");
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
    
    public static Unit[] battle() throws InterruptedException {

    int endBattle = 1;
    int turn = 0;
    
    System.out.println("Battle begins...");    

    do{        
        fighters[turn % 2][chooseUnit(fighters[turn % 2])].assault(fighters[1 - (turn % 2)][chooseUnit(fighters[1 - (turn % 2)])]);
        turn++;
        if (defeatTeam(fighters[0]) == 0 || defeatTeam(fighters[1]) == 0)
            endBattle = 0;
    }
    while (endBattle == 1);

    if (defeatTeam(fighters[0]) == 0)
        return fighters[1];
    else return fighters[0];
    }

    public static int defeatTeam(Unit[] fighters){
        int defeat = fighters.length;
        for (Unit elm : fighters)
            if (elm.getAlive() == 0)
                defeat--;
        return defeat;

    }

    public static void saveTeam(Unit[] winFigthers) {
        File file = new File("./Game/engine/save.txt");
        

        for (Unit elm : winFigthers){
            if (elm.getAlive() == 1)
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
                    oos.writeObject(elm);
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
        }
    }
        
}


