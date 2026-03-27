import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    Scanner scanner = new Scanner(System.in);
    List<Product> products;
    Category category;

    public CommerceSystem(List<Product> product)
    {
        this.products = new ArrayList<>(product);
         category = new Category(products);
    }

    public void start()
    {
        int num = 0;
        while(true)
        {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for(int i=0; i<category.getName().length; i++)
            {
                System.out.println((i+1) + ". " + category.getName()[i]);
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
                System.out.println("[ 전자제품 카테고리 ]");
                for(int i=0; i<category.getElectroProducts().size(); i++)
                {
                    System.out.println((i+1) + ". " + category.getElectroProducts().get(i).getName() + "      | " + category.getElectroProducts().get(i).getPrice()
                    + "      | " + category.getElectroProducts().get(i).getExplain());
                }
                System.out.println("0. 뒤로가기");
                int optionnumber = scanner.nextInt();
                scanner.nextLine();
                if(optionnumber != 0)
                {
                    System.out.println("선택한 상품: " + category.getElectroProducts().get(optionnumber).getName() + " | " + category.getElectroProducts().get(optionnumber).getPrice()
                    + " | " +  category.getElectroProducts().get(optionnumber).getExplain() + " | " + category.getElectroProducts().get(optionnumber).getStock());
                }
            }
        }
    }
}
