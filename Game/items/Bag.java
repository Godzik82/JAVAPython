package items;

import unit.Unit;
import interfaces.Items;

public class Bag implements Items {

    String name;
    int weigth;
    int exist;
    Items[] capacity;

    public Bag(String name, int weigth, int capacity){
        this.name = name;
        this.weigth = weigth;
        this.capacity = new Items[capacity];
        this.exist = 1;
    }

    @Override
    public int getExist() {
        return exist;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWeight() {
        return weigth;
    }

    public int getEmpty(){
        for (int i = 0; i < capacity.length; i++)
            if (capacity[i] == null)
                return i;
        return -1;
    }

    public void addBag(Unit targetUnit, int curentItemsWeigth, int maxWeigth, String name){
        int cell = getEmpty();
        int i = 1;
        if (targetUnit.getAllItems().length == 0)
            System.out.printf("All items of %s is broken, nothing place in %s's bag%n", targetUnit.getName(), name);
        else {
            while (cell != -1 || curentItemsWeigth < maxWeigth || i < targetUnit.getAllItems().length){
            for (Items item : targetUnit.getAllItems()){
                capacity[cell] = item;
                System.out.printf("%s placed in %s's bag%n", item.getName(), name);
                i++;
            }
            cell = getEmpty();
            }
            if (cell == -1)
            System.out.println("Bag if full");
        }
    }

    // public void addBag(Unit target, String name){
    //     int nothing = 0; 

    //     if (target.weapon.exist == 1) {
    //         capacity[0] = new String[] {
    //             target.weapon.name,
    //             Integer.toString(target.weapon.damage),
    //             Integer.toString(target.weapon.strength),
    //             "1"
    //         };
    //         System.out.printf("В сумку %s добавлено: %s%n", name, capacity[0][0]);
    //     } else nothing++;
    //     if (target.armour.exist == 1){
    //         capacity[1] = new String[] {
    //             target.armour.name,
    //             Integer.toString(target.armour.selfArmour),
    //             Integer.toString(target.armour.strength),
    //             "1"
    //         };
    //         System.out.printf("В сумку добавлено: %s%n",  capacity[1][0]);
    //     }  else nothing++;
    //     if (nothing == 2)
    //         System.out.printf("В суммку %s ничего не добавлено", name);   
    // }
}
