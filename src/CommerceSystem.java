import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private Scanner scanner = new Scanner(System.in);
    private List<Category> categorylist;
    private Category selectedCategory;
    private Product selectedproduct;
    private List<Product> basketList;
    private int count;

    public CommerceSystem(List<Category> category)
    {
       this.categorylist = category;
    }

    public void start()
    {
        basketList = new ArrayList<>();
        while (true)
        {
            selectedCategory = selectcategorylistnumber();
            if(selectedCategory == null)
            {
                break;
            }
            if (selectedCategory.getName().equals("SKIP")) {
                continue;
            }
            selectedproduct = selectproduct();
            if (selectedproduct == null) {
                continue;
            }
            showselectproduct();
        }
    }

    public Category selectcategorylistnumber()
    {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categorylist.size(); i++)
        {
            System.out.println((i+1) + ". " + categorylist.get(i).getName());
        }
        System.out.println("0. 종료");
        if(!basketList.isEmpty())
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
        else if(categorylistnumber == 3)
        {
            checkedList();
            return new Category(null, null, null, null, "SKIP");
        }
        else if(categorylistnumber == 4)
        {
            removeList();
            return new Category(null, null, null, null, "SKIP");
        }
        else
        {
            return categorylist.get(categorylistnumber);
        }
    }


    public Product selectproduct()
    {
        for(int i = 0; i < selectedCategory.getProducts().size(); i++)
        {
            Product p = selectedCategory.getProducts().get(i);
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
        return selectedCategory.getProducts().get(selectedproductnum);

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
            System.out.println(selectedproduct.getName() + "가 장바구니에 추가되었습니다!");
            count = selectedproduct.getProductcount();
            count++;
        }
    }

    public void checkedList()
    {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("[ 장비구니 내역 ]");
        System.out.println(selectedproduct.getName() + " | " + selectedproduct.getPrice() + " | " + selectedproduct.getExplain() + " | " +  "  수량:" + count
        + "개");

        System.out.println("[ 총 주문 금액 ]");
        System.out.println(selectedproduct.getPrice() + "원");
        System.out.println("1. 주문 확정           2. 메인으로 돌아가기");
        int num = scanner.nextInt();
        scanner.nextLine();
        if(num == 1)
        {
            executeOrder();
        }
    }

    public void executeOrder()
    {
        System.out.println("주문이 완료되었습니다!. 총 금액: " + selectedproduct.getPrice());
        System.out.println(selectedproduct.getName() + " 재고가" + selectedproduct.getStock() + " 개 -> " + selectedproduct.initStock(count) + "개로 업데이트 되었습니다.");
    }

    public void removeList()
    {
        System.out.println("주문을 취소합니다.");
        basketList.remove(selectedproduct);
    }
}
