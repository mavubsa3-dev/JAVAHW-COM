import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Product> products = new ArrayList<>();


    public Category(Product product1, Product product2, Product product3, Product product4, String name)
    {
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

}
