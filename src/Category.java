import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Product> products;


    public Category(List<Product> products ,String name)
    {
        this.products = products;
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public List<Product> getProductslist()
    {
        return products;
    }



}
