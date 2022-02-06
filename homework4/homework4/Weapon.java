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
        strength -= 2;
    }
}
