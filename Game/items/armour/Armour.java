package items.armour;

import interfaces.*;

public abstract class Armour implements Items {
    String name;
    int weigth;
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

    public int getWeight(){
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
        if (exist != 0 && streigth < 1) {
            exist = 0;
            System.out.printf("%s is broken%n", name);
        }
        else streigth = downStreigth();
    }

    public String[] addItem(){
        return new String[]{name, Integer.toString(weigth), Integer.toString(defence), Integer.toString(streigth)};
    }

    public void replaceItem(Armour replaceItem){
        this.name = replaceItem.getName();
        this.weigth = replaceItem.getWeight();
        this.defence = replaceItem.getDefence();
        this.streigth = replaceItem.getStreigth();
    }

    public void infoItem(){
        System.out.printf("%s (Weigth - %d, Defence - %d, Streigth - %d)%n", name, weigth, defence, streigth);
    }
}

