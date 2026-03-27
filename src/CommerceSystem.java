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
        int num = 0;
        while(true)
        {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            System.out.println("1. 전자제품");
            System.out.println("2. 의류");
            System.out.println("3. 식품");
            System.out.println("4. 종료");
            num = scanner.nextInt();
            scanner.nextLine();
            if(num == 0)
            {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }
        }
    }
}
