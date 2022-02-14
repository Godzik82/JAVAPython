package items.armour;

import interfaces.Items;

public abstract class Armour implements Items {
    String name;
    float weigth;
    int defence;
    int streigth;
    int exist;

    protected Armour(String name, int weigth, int defence, int streigth){
        this.name = name;
        this.weigth = weigth;
        this.defence = defence;
        this.streigth = streigth;
        this.exist = 1;
    }

    public String getName(){
        return name;
    }

    public float getWeight(){
        return weigth;
    }
    public int getDefence(){
        return defence;
    }
    public int getStreigth(){
        return streigth;
    }

    public int getExist() {
        return exist;
    }
        
    public void setExist(int exist) {
        this.exist = exist;
    }

    public void brokeItem(){
        if (exist != 0 && streigth < 1)
            exist = 0;    
        else streigth = downStreigth();
    }

    public String[] addItem(){
        return new String[]{name, Float.toString(weigth), Integer.toString(defence), Integer.toString(streigth)};
    }

    public void replaceItem(Armour replaceItem){
        this.name = replaceItem.getName();
        this.weigth = replaceItem.getWeight();
        this.defence = replaceItem.getDefence();
        this.streigth = replaceItem.getStreigth();
    }
}

