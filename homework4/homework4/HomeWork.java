package homework4;

public class HomeWork {
    public static void main(String[] args) {
        Unit ork = new Unit("Орк", 100);
        Unit elf = new Unit("Ельф", 100);
        do{
            ork.assault(elf);
            elf.assault(ork);
        }
        while(ork.alive > 0 || elf.alive > 0);
        System.out.println("Битва закончена");

        
    }
    
    public Unit[] createUnit(){
        Unit[] fighters = new Unit[2];
        for (int i = 0; i < fighters.length; i++){
            fighters[i] = new Unit("Орк", 100);
        }
        
        System.out.println("");
        return fighters;
    }
}
