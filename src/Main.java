import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰");
        Product product2 = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰");
        Product product3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북");
        Product product4 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰");
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        CommerceSystem commerceSystem = new CommerceSystem(products);
        commerceSystem.start();
    }
}