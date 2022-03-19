package homework_8;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product>
{

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.name.equals(o2.name) && o1.cost.equals(o2.cost))
            return 0;
        else return 1;
    }
    
}
