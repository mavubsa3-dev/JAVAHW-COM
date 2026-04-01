import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Category> categorylist;
    private Category selectedCategory;
    private Product selectedproduct;
    private List<Product> basketList;
    private String PW = "admin123";

    private List<Product> electroProducts;
    private List<Product> clothProducts;
    private List<Product> foodProducts;

    public Database()
    {
        electroProducts = new ArrayList<>();
        clothProducts = new ArrayList<>();
        foodProducts = new ArrayList<>();

        categorylist = new ArrayList<>();
        basketList = new ArrayList<>();
        Product product1 = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 30);
        Product product2 = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 30);
        Product product3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 30);
        Product product4 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 30);
        Product product5 = new Product("모자", 10000, "캡모자", 30);
        Product product6 = new Product("바지", 20000, "데님 팬츠", 30);
        Product product7 = new Product("반팔", 30000, "스투시", 30);
        Product product8 = new Product("아우터", 40000, "바람막이", 30);
        Product product9 = new Product("김치", 10000, "배추김치", 30);
        Product product10 = new Product("고기", 15000, "삼겹살", 30);
        Product product11 = new Product("국", 7000, "된장찌개", 30);
        Product product12 = new Product("갈비", 20000, "돼지갈비", 30);
        electroProducts.add(product1);
        electroProducts.add(product2);
        electroProducts.add(product3);
        electroProducts.add(product4);
        Category eleCategory = new Category(electroProducts, "전자제품");
        clothProducts.add(product5);
        clothProducts.add(product6);
        clothProducts.add(product7);
        clothProducts.add(product8);
        Category clothCategory = new Category(clothProducts, "의류");
        foodProducts.add(product9);
        foodProducts.add(product10);
        foodProducts.add(product11);
        foodProducts.add(product12);
        Category foodCategory = new Category(foodProducts, "식품");
        categorylist.add(eleCategory);
        categorylist.add(clothCategory);
        categorylist.add(foodCategory);
    }

    public List<Product> getElectroProducts()
    {
        return electroProducts;
    }

    public List<Product> getClothProducts(){
        return clothProducts;
    }

    public List<Product> getFoodProducts(){
        return foodProducts;
    }

    public List<Category> getCategorylist()
    {
        return categorylist;
    }

    public Category getSelectedCategory()
    {
        return selectedCategory;
    }

    public Product getSelectedproduct()
    {
        return selectedproduct;
    }

    public void setSelectedCategory(Category category)
    {
        this.selectedCategory = category;
    }

    public List<Product> getBasketList()
    {
        return basketList;
    }

    public void setSelectedproduct(Product product)
    {
        this.selectedproduct = product;
    }

    public void addbasketlist(Product selectedproduct)
    {
        basketList.add(selectedproduct);
    }

    public void removebasketlist(Product selectedproduct)
    {
        basketList.remove(selectedproduct);
    }

    public String getPW()
    {
        return PW;
    }

    public void addProduct(int number, Product product)
    {
        boolean isSuccess = false;
        if(number == 1)
        {
            isSuccess = verifyProduct(electroProducts, product);
        }
        if(number == 2)
        {
            isSuccess = verifyProduct(clothProducts, product);
        }
        if(number == 3)
        {
            isSuccess = verifyProduct(foodProducts, product);
        }
        if(isSuccess){
            System.out.println("상품이 성공적으로 추가되었습니다!");
        }

    }

    public void removeProduct(Product product)
    {
        for(int i=0; i<categorylist.size(); i++)
        {
            Category category = categorylist.get(i);
            List<Product> products = category.getProducts();
            products.remove(product);
            basketList.remove(product);
        }
        System.out.println("상품이 삭제되었습니다");
    }

    public boolean verifyProduct(List<Product> list, Product product)
    {
        for(int i=0; i<list.size(); i++)
        {
           if(list.get(i).getName().equals(product.getName()))
            {
                System.out.println("이미 등록된 상품입니다.");
                return false;
            }else{
               list.add(product);
               return true;
           }
        }
    }


}
