package homework_8;

public class Product implements Comparable<Product>{
    String name;
    Double cost;

    public Product(String name, Double cost){
        this.name = name;
        this.cost = cost;
    }

    public String info(){
        return name + "         \t" + cost;
    }

    @Override
    public int compareTo(Product o) {
        if (name.equals(o.name))
            return 0;
        else return 1;
    }
    
}
