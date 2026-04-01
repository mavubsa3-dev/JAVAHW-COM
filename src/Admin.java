import java.util.List;
import java.util.Scanner;

public class Admin {
    private Database database;
    private int count;
    private Scanner scanner;


    public Admin(Database database, Scanner scanner)
    {
        this.database = database;
        this.scanner = scanner;
        showAdminWindow();
    }

    public void showAdminWindow()
    {
        while (true)
        {
            System.out.println("[ 관리자 모드 ]");
            System.out.println("1. 상품 추가");
            System.out.println("2. 상품 수정");
            System.out.println("3. 상품 삭제");
            System.out.println("0. 메인으로 돌아가기");
            int num = scanner.nextInt();
            scanner.nextLine();
            if(num == 0)
            {
                break;
            }else if(num == 1) {
                addProduct();
            }else if(num == 2) {
                editProduct();
            }else if(num == 3)
            {
                removeProduct();
            }

        }
    }


    public int selectCategory()
    {
        System.out.println("어느 카테고리에 추가하시겠습니까?");
        System.out.println("1. 전자제품");
        System.out.println("2. 의류");
        System.out.println("3. 식품");
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    public void addProduct()
    {
        int categorynum = selectCategory();
        Product product = productinfo();
        int optionnum = showproductinfo(product);
        if(optionnum == 1)
        {
            database.addProduct(categorynum, product);
        }
    }

    public void editProduct()
    {
        System.out.print("수정할 상품명을 입력해주세요: ");
        String name = scanner.nextLine();
        Product product = findProduct(name);
        System.out.println("현재 상품 정보: " + product.getName() + " | " + product.getPrice() + "원 | " + product.getExplain() + " | 재고: " + product.getStock() + "개");

        System.out.println("수정할 항목을 선택하세요: ");
        System.out.println("1. 가격");
        System.out.println("2. 설명");
        System.out.println("3. 재고수량");
        int num = scanner.nextInt();
        scanner.nextLine();
        editProductinfo(product, num);
    }

    public Product findProduct(String name)
    {
        List<Category> categorylist = database.getCategorylist();
        for(int i=0; i<categorylist.size(); i++)
        {
            Category category = categorylist.get(i);
            List<Product> products = category.getProducts();
            for(int j=0; j<products.size(); j++)
            {
                Product product = products.get(j);
                if(name.equals(product.getName()))
                {
                    return product;
                }
            }
        }
        return null;
    }

    public void editProductinfo(Product product, int num)
    {
        if(num == 1)
        {
            System.out.println("현재 가격: " + product.getPrice() + "원");
            System.out.print("새로운 가격을 입력하세요: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            System.out.println(product.getName() + "의 가격이 " + product.getPrice() + "원 -> " + product.initPrice(price) + "원으로 수정되었습니다.");
        }
        if(num == 2)
        {
            System.out.println("현재 설명: " + product.getExplain());
            System.out.print("새로운 설명: ");
            String explain = scanner.nextLine();
            System.out.println("설명 변경: " + product.getName() + " | " + product.initExplain(explain));
        }
        if(num == 3)
        {
            System.out.println("현재 수량: " + product.getStock());
            System.out.print("수량 변경: ");
            int stock = scanner.nextInt();
            scanner.nextLine();
            System.out.println(product.getName() + "의 수량이 " + product.getStock() + "개 -> " + product.initStock(stock) + "으로 변경하였습니다.");
        }
    }

    public int showproductinfo(Product product)
    {
        System.out.println(product.getName() + " | " + product.getPrice() + " | " + product.getExplain() + " | " + product.getStock() + "개");
        System.out.println("위 정보로 상품을 추가하시겠습니까?");
        System.out.println("1. 확인      2. 취소");
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    public Product productinfo()
    {
        System.out.println("[ 전자제품 카테고리에 상품 추가]");
        System.out.print("상품명을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("가격을 입력하세요: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.print("상품 설명을 입력하세요: ");
        String introduce = scanner.nextLine();
        System.out.print("재고 수량을 입력하세요: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        Product product = new Product(name, price, introduce, stock);
        return product;
    }

    public void removeProduct()
    {
        System.out.print("상품 이름을 입력하세요: ");
        String name = scanner.nextLine();
        Product product = findProduct(name);
        database.removeProduct(product);
    }




}
