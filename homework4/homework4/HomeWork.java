package homework4;

import java.util.Random;

public class HomeWork {
    static Random rand = new Random();
    static Unit[] fighters = new Unit[2];
    public static void main(String[] args) {
        createUnit();
        battle();
        // Unit ork = new Unit("Орк", 100);
        // Unit elf = new Unit("Ельф", 100);
        // do{
        //     ork.assault(elf);
        //     elf.assault(ork);
        // }
        // while(ork.alive > 0 || elf.alive > 0);
        // System.out.println("Битва закончена");

        
    }
    
    public static Unit[] createUnit(){
        
        String[] curentUnit;
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

    public static void battle(){
        int endBattle = 1;
        int turn = 0;
        do{
            fighters[turn % 2].assault(fighters[1 - (turn % 2)]);
            if (fighters[0].alive == 0 || fighters[1].alive == 0)
                endBattle = 0;
            turn++;
        }
        while(endBattle ==1);
    }
}
