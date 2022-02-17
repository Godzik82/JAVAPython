package engine;
import unit.FlyingUnit;
import unit.GroundUnit;
import unit.MagicUnit;
import unit.Unit;

public class Dictionary {
    static GroundUnit groundUnit;
    static FlyingUnit flyingUnit;
    static MagicUnit magicUnit;
    static Unit[] listUnit = {groundUnit, flyingUnit, magicUnit};
    
    public static String[][] groundUnits = new String[][] {
        {"Orc", "1000", "40", "50"},
        {"Elf", "850", "35", "40"},
        {"Paladin", "950", "45", "50"},
        {"Gnome", "800", "40", "30"},
        {"Golem", "1500", "50", "60"}
    };   
    
    public static String[][] flyingUnits = new String[][] {
        {"Dragon", "1000", "40"},
        {"Manticora", "850", "35"},
        {"Griffon", "950", "45"}
    };

    public static String[][] magicUnits = new String[][] {
        {"Маг", "1000", "40", "50", "60"},
        {"Джин", "850", "35", "40", "70"},
        {"Экзорцист", "950", "45", "50", "60"},
        {"Ведьма", "800", "40", "30", "50"},
        {"Ведьмаг", "1500", "50", "60", "100"}
    };   

    public static String[][] weaponsGround = new String[][] {
        {"Деревянный меч", "65", "10", "20"},
        {"Обычный Меч", "75", "15", "20"},
        {"Меч-кладенец", "80", "20", "20"},
        {"Экскалибур", "90", "25", "20"}
    };
    public static String[][] weaponsMagic = new String[][] {
        {"Волшебная палочка", "65", "10", "5"},
        {"Посох холода", "75", "15", "10"},
        {"Посох шамана", "80", "20", "15"},
        {"Скипитер Сатаны", "90", "25", "20"}
    };

    public static String[][] armoursBody = new String[][] {
        {"Кожанная накидка", "1", "5", "10"},
        {"Кольчуга", "10", "25", "10"},
        {"Дамаская броня", "20", "50", "10"},
        {"Доспехи бога", "30", "150", "10"}
    };
    public static String[][] armoursHelmet = new String[][] {
        {"Обычный шлем", "2", "5", "5"},
        {"Богатырский шлем", "10", "5", "5"},
        {"Шлем минотавра", "20", "50", "5"},
        {"Драконий шлем", "30", "150", "5"}
    };
    public static String[][] armoursBoots = new String[][] {
        {"Солдатский сапоги", "1", "5", "3"},
        {"Сапоги скороходы", "10", "25", "3"},
        {"Рыцарские сапоги", "20", "50", "3"},
        {"Драконий сапог", "30", "150", "3"}
    };
    public static String[][] armoursGloves = new String[][] {
        {"Перчатки", "1", "5", "2"},
        {"Рыцарские перчатки", "10", "25", "2"},
        {"Перчатки минотавра", "20", "50", "2"},
        {"Перчатки дракона", "30", "150", "2"}
    };

    
}
