import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    Scanner scanner = new Scanner(System.in);
    List<Product> products;

    public CommerceSystem(List<Product> product)
    {
        this.products = new ArrayList<>(product);
    }

    public void start()
    {
        while(true)
        {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for(int i=0; i< products.size(); i++)
            {
                System.out.println((i+1) + ". " + products.get(i).getName() + "     | " + products.get(i).getPrice() + "원  | " + products.get(i).getExplain());
            }
            System.out.println("0. 종료");
            System.out.print("");

            int num = scanner.nextInt();
            scanner.nextLine();
            if(num == 0)
            {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }
        }
    }
}
