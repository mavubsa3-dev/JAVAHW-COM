public class Product {
    private String name;
    private int price;
    private String explain;
    private int stock;
    private String cate;

    public Product(String name, int price, String explain, int stock, String cate)
    {
        this.name = name;
        this.price = price;
        this.explain = explain;
        this.stock = stock;
        this.cate = cate;
    }

    public String getName()
    {
        return this.name;
    }

    public int getPrice()
    {
        return price;
    }

    public String getExplain()
    {
        return explain;
    }

    public int getStock()
    {
        return stock;
    }

    public String getCate()
    {
        return cate;
    }

}
