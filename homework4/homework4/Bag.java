package homework4;

public class Bag {
    String[][] capacity;

    public Bag(){
        this.capacity = new String [2][4];
    }

    public void addBag(Unit target){
        if (target.weapon.exist == 1) {
            capacity[0] = new String[] {
                target.weapon.name,
                Integer.toString(target.weapon.damage),
                Integer.toString(target.weapon.strength),
                "1"
            };
            System.out.printf("В сумку добавлено: %s%n ",  capacity[0][0]);
        }
        if (target.armour.exist == 1){
            capacity[1] = new String[] {
                target.armour.name,
                Integer.toString(target.armour.selfArmour),
                Integer.toString(target.armour.strength),
                "1"
            };
            System.out.printf("В сумку добавлено: %s%n",  capacity[1][0]);
        }    
    }

    public void bagInfo(){
        System.out.println("В сумке находится:");
    }

}
