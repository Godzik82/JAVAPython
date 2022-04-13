package homework_12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {

    Store store;
    Goods[] goods;
    private static final Logger logger = Logger.getLogger(Store.class.getName());

    public Producer (Store store){
        this.store = store;
    }

    @Override
    public void run(){
        try{
            logger.info("Start Producer");
            while (true) {
                Goods[] goods = Goods.createGoods();
                store.addGoodsToStore(goods);
                Thread.sleep(1000);
            } 
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "Stop produce", e);
            Thread.currentThread().interrupt();
        }
    }
}
