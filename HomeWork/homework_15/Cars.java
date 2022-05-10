package homework_15;

public class Cars {
    
    String name;
    String color;
    String model;

    public Cars(String name, String color, String model){
        this.name = name;
        this.color = color;
        this.model = model;
    }

    public String info(){
        return "Name: " + name + " Model: " + model + " Color: " + color;
    }
}
