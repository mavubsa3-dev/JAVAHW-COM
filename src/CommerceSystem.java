import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private Scanner scanner = new Scanner(System.in);
    private List<Category> categorylist;
    private Product selectedproduct;
    private List<Product> products;
    private List<Product> basketList;

    public CommerceSystem(List<Category> category)
    {
       this.categorylist = category;
    }

    public void start()
    {
        while (true)
        {
            products = selectcategorylistnumber();
            if(products == null)
            {
                break;
            }
            selectedproduct = selectproduct();
            if (selectedproduct == null) {
                continue;
            }
            showselectproduct();
        }
    }
    public List<Product> selectcategorylistnumber()
    {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categorylist.size(); i++)
        {
            System.out.println((i+1) + ". " + categorylist.get(i).getName());
        }
        System.out.println("0. 종료");
        if(basketList != null)
        {
            System.out.println("[ 주문 관리 ]");
            System.out.println("4. 장바구니 확인");
            System.out.println("5. 주문 취소");
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        int categorylistnumber =  number - 1;
        if (categorylistnumber == -1) {
            System.out.println("커머스 플랫폼을 종료합니다.");
           return null;
        }
        if(categorylistnumber == 4)
        {
            removeList();
        }
        return categorylist.get(categorylistnumber).getProducts();
    }


    public Product selectproduct()
    {
        for(int i = 0; i < products.size(); i++)
        {
            Product p = products.get(i);
            System.out.println((i+1) + ". " + p.getName()+ "      | " + p.getPrice()
                    + "      | " + p.getExplain());
        }
        System.out.println("0. 뒤로가기");
        int productnumber = scanner.nextInt();
        scanner.nextLine();
        int selectedproductnum =  productnumber - 1;
        if (selectedproductnum == -1) {
            return null;
        }
        return products.get(selectedproductnum);

    }

    public void showselectproduct()
    {
            System.out.println("선택한 상품: " + selectedproduct.getName() + " | " + selectedproduct.getPrice() +"원"
                    + " | " + selectedproduct.getExplain() + " | " + selectedproduct.getStock() + "개");

        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인          2. 취소");
        int number = scanner.nextInt();
        scanner.nextLine();
        if(number == 1)
        {
            basketList.add(selectedproduct);
        }
    }

    public void removeList()
    {
        System.out.println("주문을 취소합니다.");
        basketList.remove(selectedproduct);
    }
}
