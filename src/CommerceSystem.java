import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    Scanner scanner = new Scanner(System.in);
    private List<Category> category;

    public CommerceSystem(List<Category> category)
    {
       this.category = category;
    }

    public void start()
    {
        int num = 0;
        while(true)
        {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for(int i=0; i< category.size(); i++)
            {
                System.out.println((i+1) + ". " + category.get(i).getName());
            }
            System.out.println("0. 종료");
            num = scanner.nextInt();
            scanner.nextLine();
            if(num == 0)
            {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }
            if(num == 1)
            {
                for(int i=0; i<category.get(0).getProducts().size(); i++)
                {
                    System.out.println((i+1) + ". " + category.get(0).getProducts().get(i).getName()+ "      | " + category.get(0).getProducts().get(i).getPrice()
                     + "      | " + category.get(0).getProducts().get(i).getExplain());
                }
                System.out.println("0. 뒤로가기");
                int optionnum = scanner.nextInt();
                scanner.nextLine();
                int indexnum = optionnum - 1;
                if(optionnum != 0)
                {
                    System.out.println("선택한 상품: " + category.get(0).getProducts().get(indexnum).getName() + " | " + category.get(0).getProducts().get(indexnum).getPrice() +"원"
                    + " | " + category.get(0).getProducts().get(indexnum).getExplain() + " | " + category.get(0).getProducts().get(indexnum).getStock() + "개");
                }
            }
            if(num == 2)
            {
                for(int i=0; i<category.get(1).getProducts().size(); i++)
                {
                    System.out.println((i+1) + ". " + category.get(1).getProducts().get(i).getName()+ "      | " + category.get(1).getProducts().get(i).getPrice()
                            + "      | " + category.get(1).getProducts().get(i).getExplain());
                }
                System.out.println("0. 뒤로가기");
                int optionnum = scanner.nextInt();
                scanner.nextLine();
                int indexnum = optionnum - 1;
                if(optionnum != 0)
                {
                    System.out.println("선택한 상품: " + category.get(1).getProducts().get(indexnum).getName() + " | " + category.get(1).getProducts().get(indexnum).getPrice() +"원"
                            + " | " + category.get(1).getProducts().get(indexnum).getExplain() + " | " + category.get(1).getProducts().get(indexnum).getStock() + "개");
                }
            }
            if(num == 3)
            {
                for(int i=0; i<category.get(2).getProducts().size(); i++)
                {
                    System.out.println((i+1) + ". " + category.get(2).getProducts().get(i).getName()+ "      | " + category.get(2).getProducts().get(i).getPrice()
                            + "      | " + category.get(2).getProducts().get(i).getExplain());
                }
                System.out.println("0. 뒤로가기");
                int optionnum = scanner.nextInt();
                scanner.nextLine();
                int indexnum = optionnum - 1;
                if(optionnum != 0)
                {
                    System.out.println("선택한 상품: " + category.get(2).getProducts().get(indexnum).getName() + " | " + category.get(2).getProducts().get(indexnum).getPrice() +"원"
                            + " | " + category.get(2).getProducts().get(indexnum).getExplain() + " | " + category.get(2).getProducts().get(indexnum).getStock() + "개");
                }
            }
        }
    }
}
