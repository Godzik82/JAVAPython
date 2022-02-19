package items;
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

    public int getEmpty(Items[] capacity){
        for (int i = 0; i < capacity.length; i++)
            if (capacity[i] == null)
                return i;
        return -1;
    }
   
}
