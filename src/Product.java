public class Product {
    private String name;
    private int price;
    private String explain;
    private int stock;
    private int productcount;

    public Product(String name, int price, String explain, int stock)
    {
        this.name = name;
        this.price = price;
        this.explain = explain;
        this.stock = stock;
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

    public int getProductcount() {
        return productcount;
    }

    public int initStock(int count)
    {
        stock -= count;
        return stock;
    }

}
