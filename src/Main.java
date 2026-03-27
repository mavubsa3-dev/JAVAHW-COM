import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
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
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        Category eleCategory = new Category(product1, product2, product3, product4, "전자제품");
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        Category clothCategory = new Category(product5, product6, product7, product8, "의류");
        products.add(product9);
        products.add(product10);
        products.add(product11);
        products.add(product12);
        Category foodCategory = new Category(product9, product10, product11, product12, "식품");
        categoryList.add(eleCategory);
        categoryList.add(clothCategory);
        categoryList.add(foodCategory);
        CommerceSystem commerceSystem = new CommerceSystem(categoryList);
        commerceSystem.start();
    }
}