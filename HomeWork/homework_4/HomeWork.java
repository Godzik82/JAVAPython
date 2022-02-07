package homework_4;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HomeWork {
    static Random rand = new Random();
    static Unit[] fighters = new Unit[2];
    public static void main(String[] args) throws InterruptedException {
        createUnit();
        battle();
    }
    
    public static Unit[] createUnit(){
        String[] curentUnit;

        System.out.println("Созданы юниты:");
        for (int i = 0; i < fighters.length; i++){
            curentUnit = Dictionary.units[rnd(Dictionary.units.length)];
            fighters[i] = new Unit(curentUnit[0], Integer.parseInt(curentUnit[1]), Integer.parseInt(curentUnit[2]));
        }
        
        System.out.println("");
        return fighters;
    }

    public static int rnd(int a){
        return rand.nextInt(a);
    }

    public static void battle() throws InterruptedException {
        int endBattle = 1;
        int turn = 0;
        do{
            fighters[turn % 2].assault(fighters[1 - (turn % 2)], fighters[turn % 2].name);
            if (fighters[0].alive == 0 || fighters[1].alive == 0)
                endBattle = 0;
            turn++;
            TimeUnit.MILLISECONDS.sleep(300);
        }
        while(endBattle == 1);
    }
}
