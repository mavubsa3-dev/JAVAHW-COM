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
            for(int i=0; i<3; i++)
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

        }
    }
}
