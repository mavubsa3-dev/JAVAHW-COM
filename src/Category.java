import java.util.ArrayList;
import java.util.List;

public class Category {
    private String[] name = {"전자제품", "의류", "식품"};
    private List<Product> products;
    private List<Product> electroProducts = new ArrayList<>();
    private List<Product> clothesProducts = new ArrayList<>();
    private List<Product> foodProducts = new ArrayList<>();


    public Category(List<Product> product)
    {
        for(int i=0; i< product.size(); i++)
        {
            if(product.get(i).getCate().equals("ele"))
            {
                electroProducts.add(product.get(i));
            }
            if(product.get(i).getCate().equals("clo"))
            {
                clothesProducts.add(product.get(i));
            }
            if(product.get(i).getCate().equals("food"))
            {
                foodProducts.add(product.get(i));
            }
        }
    }

    public String[] getName()
    {
        return name;
    }
}
