package homework4;

public class Armour{
    String name;
    int selfArmour;
    int strength;
    int exist;

    public Armour(String name, int selfArmour, int strength){
        this.name = name;
        this.selfArmour = selfArmour;
        this.strength = strength;
        this.exist = 1;
    }

    public void downStrength(){
        if(exist == 1)
            strength -= 1;
        if(strength <= 0)
            exist = 0;
    }
    
}
