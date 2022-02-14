package items.weapon;
import interfaces.Items;

public abstract class Weapon implements Items{
    String name;
    float weigth;
    int damage;
    int streigth;
    int exist = 1;

    protected Weapon(String name, float weigth, int damage, int streigth){
        this.name = name;
        this.weigth = weigth;
        this.damage = damage;
        this.streigth = streigth;
        this.exist = 1;
    }

    public String getName(){
        return name;
    }

    public float getWeight(){
        return weigth;
    }
    public int getDamage(){
        return damage;
    }
    public int getStreigth(){
        return streigth;
    }

    public int getExist() {
        return exist;
    }

    public int damageWeapon() {
        return damage * exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public String[] addItem(){
        return new String[]{name, Float.toString(weigth), Integer.toString(damage), Integer.toString(streigth)};
    }

    public void brokeItem(){
        if (exist != 0 && streigth < 1)
            exist = 0;    
        else streigth = downStreigth();
    }

    public void replaceItem(Weapon replaceItem){
        this.name = replaceItem.getName();
        this.weigth = replaceItem.getWeight();
        this.damage = replaceItem.getDamage();
        this.streigth = replaceItem.getStreigth();
    }

}
