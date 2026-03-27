import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    List<Product> products;
    List<Product> electroProducts = new ArrayList<>();
    List<Product> clothesProducts = new ArrayList<>();
    List<Product> foodProducts = new ArrayList<>();


    public Category(List<Product> product)
    {
        this.products = new ArrayList<>(product);
    }
}
