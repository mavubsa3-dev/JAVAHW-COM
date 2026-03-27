import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    List<Product> products;

    public Category(List<Product> product)
    {
        this.products = new ArrayList<>(product);
    }
}
