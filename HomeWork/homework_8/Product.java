package homework_8;

public class Product implements Comparable<Product>{
    String name;
    Float cost;

    public Product(String name, Float cost){
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int compareTo(Product o) {
        if (name.equals(o.name) && cost.equals(o.cost))
            return 0;
        else return 1;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Product){
            Product p = (Product) o;
            return name == p.name && cost == p.cost;
        }
        return false;
    }

    @Override
    public int hashCode(){
        int code = name == null ? 0 : name.hashCode();
        code += cost;
        return code;
    }

    public String getName(){
        return name;
    }
    
    public Float getCost(){
        return cost;
    }
    
}
