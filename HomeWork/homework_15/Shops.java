package homework_15;

public class Shops {

    String name;
    String address;

    public Shops(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String info(){
        return "Name: " + name + " Address: " + address;
    }
    
}
