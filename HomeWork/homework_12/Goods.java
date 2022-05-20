package homework_12;

import java.util.LinkedList;
import java.util.Random;

public class Goods implements Comparable<Goods>{

    String name;
    Integer amount;
    static String[] goodsName = new String[]{"Wood", "Metal", "Paper", "Plastic", "Glass"};
    static Random rnd = new Random();
    
    public Goods(String name, Integer amount){
        this.name = name;
        this.amount = amount;
    }

    @Override
    public int compareTo(Goods g) {
        if (name.equals(g.name))
            return 1;
        else return 0;
    }

    public static Goods createGood() {
        return new Goods(goodsName[rnd.nextInt(5)], rnd.nextInt(1, 10));
    }

    public static Goods[] createGoods(){
        Integer vol = rnd.nextInt(1,5);
        Goods[] createGoods = new Goods[vol];
        Integer i = 0;
        LinkedList<String> dictGoodsName = new LinkedList<>();

        do {
            
            createGoods[i] = Goods.createGood();
            if (dictGoodsName.indexOf(createGoods[i].name) == -1){
                dictGoodsName.add(createGoods[i].name);
                i++;
            }
        } while (i < vol);
        
        return createGoods;
    }
}
