package homework4;

public class Weapon {
    String name;
    int damage;
    int strength;
    int exist;

    public Weapon(String name, int damage, int strength){
        this.name = name;
        this.damage = damage;
        this.strength = strength;
        this.exist = 1;
    }

    public void downStrength(){
        if(exist == 1){
            strength -= 1;
            if(strength <= 0)
                exist = 0;
            }
    }
}
