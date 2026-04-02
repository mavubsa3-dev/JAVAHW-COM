import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private Scanner scanner = new Scanner(System.in);
    private Database database;
    private int count;
    private boolean isExit = false;


    public CommerceSystem(Database database)
    {
       this.database = database;
    }

    public void start()
    {
        Category selectedCategory;
        Product selectedproduct;
        while (true)
        {
            selectedCategory = selectcategory();
            if(selectedCategory == null) {
                if(isExit){
                    break;
                }else {
                    continue;
                }
            }
            if (selectedCategory.getName().equals("SKIP")) {
                continue;
            }
            database.setSelectedCategory(selectedCategory);
            selectedproduct = selectproduct();
            if (selectedproduct == null) {
                continue;
            }
            database.setSelectedproduct(selectedproduct);
            showselectproduct();
        }
    }

    public Category selectcategory()
    {
        List<Category> categorylist = database.getCategorylist();
        List<Product> basketList = database.getBasketList();
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categorylist.size(); i++)
        {
            System.out.println((i+1) + ". " + categorylist.get(i).getName());
        }
        System.out.println("0. 종료");
        System.out.println("6. 관리자 모드");
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
            isExit = true;
           return null;
        }
        else if(categorylistnumber == 3)
        {
            checkedList();
            return null;
        }
        else if(categorylistnumber == 4)
        {
            removeList();
            return null;
        }
        else if(categorylistnumber == 5)
        {
            authorization();
            isExit = false;
            return null;
        }
        else
        {
            return categorylist.get(categorylistnumber);
        }
    }


    public Product selectproduct()
    {
        Category selectedCategory = database.getSelectedCategory();
        for(int i = 0; i < selectedCategory.getProductslist().size(); i++)
        {
            Product p = selectedCategory.getProductslist().get(i);
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
        return selectedCategory.getProductslist().get(selectedproductnum);

    }

    public void showselectproduct()
    {
        Product selectedproduct = database.getSelectedproduct();
        List<Product> basketList = database.getBasketList();
            System.out.println("선택한 상품: " + selectedproduct.getName() + " | " + selectedproduct.getPrice() +"원"
                    + " | " + selectedproduct.getExplain() + " | " + selectedproduct.getStock() + "개");

        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인          2. 취소");
        int number = scanner.nextInt();
        scanner.nextLine();
        if(number == 1)
        {
            database.addbasketlist(selectedproduct);
            System.out.println(selectedproduct.getName() + "가 장바구니에 추가되었습니다!");
            count = selectedproduct.getProductcount();
            count++;
        }
    }

    public void checkedList()
    {
        List<Product> list = database.getBasketList();
        int totalprice = 0;
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("[ 장비구니 내역 ]");
        for(int i=0; i<list.size(); i++) {
            Product selectedproduct = list.get(i);
            System.out.println(selectedproduct.getName() + " | " + selectedproduct.getPrice() + " | " + selectedproduct.getExplain() + " | " + "  수량:" + count
                    + "개");
            totalprice += selectedproduct.getPrice();
        }
        System.out.println("[ 총 주문 금액 ]");
        System.out.println(totalprice + "원");
        System.out.println("1. 주문 확정           2. 메인으로 돌아가기");
        int num = scanner.nextInt();
        scanner.nextLine();
        if(num == 1)
        {
            executeOrder(totalprice);
        }
    }

    public void executeOrder(int price)
    {
        Product selectedproduct = database.getSelectedproduct();
        System.out.println("주문이 완료되었습니다!. 총 금액: " + price + "원");
        System.out.println(selectedproduct.getName() + " 재고가" + selectedproduct.getStock() + " 개 -> " + selectedproduct.initStock(count) + "개로 업데이트 되었습니다.");
    }

    public void removeList()
    {
        Product selectedproduct = database.getSelectedproduct();
        List<Product> basketList = database.getBasketList();
        System.out.println("주문을 취소합니다.");
        database.removebasketlist(selectedproduct);
    }

    public void authorization()
    {
        for(int count = 1; count <= 3; count++)
        {
            System.out.print("비밀번호를 입력하세요: ");
            String pw = scanner.nextLine();

            if(pw.equals(database.getPW()))
            {
                Admin admin = new Admin(database, scanner);
                return;
            }
            else{
                System.out.println("관리자 로그인 실패 " + count + " / 3");
            }
        }
    }


}
