package homework_13;

import java.util.Random;
import java.util.logging.Logger;
import homework_13.factoriesType.*;
import homework_13.unitStrategyType.FlyingUnitStrategy;
import homework_13.unitStrategyType.GroundUnitStrategy;
import homework_13.unitStrategyType.MagicUnitStrategy;
import homework_13.unitType.FlyingUnit;
import homework_13.unitType.GroundUnit;
import homework_13.unitType.MagicUnit;

public class HomeWork {

    private static final Logger logger = Logger.getLogger(HomeWork.class.getName());
    static Random rnd = new Random();
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1(){

        System.out.println("Паттерн СТРАТЕГИЯ\nСоздание объектов Unit через дочерний класс\n");
        
        GroundUnit groundUnit = new GroundUnit(rnd.nextInt(1,6));
        groundUnit.info();

        MagicUnit magicUnit = new MagicUnit(rnd.nextInt(1,6));
        magicUnit.info();

        FlyingUnit flyingUnit = new FlyingUnit(rnd.nextInt(1,6));
        flyingUnit.info(); 

        System.out.println("Паттерн СТРАТЕГИЯ\nСоздание объектов Unit через базовый класс");
        
        Unit gUnit = new Unit(new GroundUnitStrategy(), rnd.nextInt(1,6));
        gUnit.info();

        Unit mUnit = new Unit(new MagicUnitStrategy(), rnd.nextInt(1,6));
        mUnit.info();

        Unit fUnit = new Unit(new FlyingUnitStrategy(), rnd.nextInt(1,6));
        fUnit.info();
    }

    public static void task2(){
        System.out.println("Паттерн Фабрика\n");
        FactoryGroundUnit factoryGroundUnit = new FactoryGroundUnit();
        FactoryFlyingUnit factoryFlyingUnit = new FactoryFlyingUnit();
        FactoryMagicUnit factoryMagicUnit = new FactoryMagicUnit();
        
        for (GroundUnitTypeDict unit : GroundUnitTypeDict.values()){
            factoryGroundUnit.create(unit, rnd.nextInt(1,6)).info();
        }

        for (FlyingUnitTypeDict unit : FlyingUnitTypeDict.values()){
            factoryFlyingUnit.create(unit, rnd.nextInt(1,6)).info();
        }
        
        for (MagicUnitTypeDict unit : MagicUnitTypeDict.values()){
            factoryMagicUnit.create(unit, rnd.nextInt(1,6)).info();
        }
    }   
}
