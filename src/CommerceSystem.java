import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private Scanner scanner = new Scanner(System.in);
    private List<Category> category;

    public CommerceSystem(List<Category> category)
    {
       this.category = category;
    }

    public void start()
    {
        int num = 0;
        while (true)
        {
           showplatform();
           num = inputNum();
           if(num == 0)
            {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }
            int listnum = num - 1;
            int productnumber = showcategory(listnum);
            selectproduct(listnum, productnumber);
        }
    }
    public void showplatform()
    {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < category.size(); i++)
        {
            System.out.println((i+1) + ". " + category.get(i).getName());
        }
        System.out.println("0. 종료");
    }

    public int inputNum()
    {
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    public int showcategory(int number)
    {
        for(int i = 0; i < category.get(number).getProducts().size(); i++)
        {
            System.out.println((i+1) + ". " + category.get(number).getProducts().get(i).getName()+ "      | " + category.get(number).getProducts().get(i).getPrice()
                    + "      | " + category.get(number).getProducts().get(i).getExplain());
        }
        System.out.println("0. 뒤로가기");
        int optionnum = inputNum();
        int indexnum = optionnum - 1;
        return indexnum;
    }

    public void selectproduct(int listnum, int indexnum)
    {
        if(indexnum != -1)
        {
            System.out.println("선택한 상품: " + category.get(listnum).getProducts().get(indexnum).getName() + " | " + category.get(listnum).getProducts().get(indexnum).getPrice() +"원"
                    + " | " + category.get(listnum).getProducts().get(indexnum).getExplain() + " | " + category.get(listnum).getProducts().get(indexnum).getStock() + "개");
        }
    }
}
