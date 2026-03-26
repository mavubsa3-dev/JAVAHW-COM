public class Product {
    private String name;
    private int price;
    private String explain;
    private int stock;

    public Product(String name, int price, String explain)
    {
        this.name = name;
        this.price = price;
        this.explain = explain;
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

}
