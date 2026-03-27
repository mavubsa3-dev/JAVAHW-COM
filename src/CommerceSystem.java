import java.util.ArrayList;
import java.util.List;

public class CommerceSystem {
    List<Product> products;

    public CommerceSystem(List<Product> product)
    {
        this.products = new ArrayList<>(product);
    }
}
