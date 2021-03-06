package unit;

import engine.Dictionary;

public class FlyingUnit extends Unit{

    public FlyingUnit(String name, int hp, int selfAttack) {
        super(name, hp, selfAttack);
    }  

    public static Unit createUnit() {
        String[] paramUnit = Dictionary.flyingUnits[Unit.rnd(Dictionary.flyingUnits.length)];
        return new FlyingUnit(paramUnit[0], Integer.parseInt(paramUnit[1]), Integer.parseInt(paramUnit[2]));
    }
}
