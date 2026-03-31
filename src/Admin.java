public class Admin {
    private Database database;
    private int count;


    public Admin(Database database)
    {
        this.database = database;
        showAdminWindow();
    }

    public void showAdminWindow()
    {
        System.out.println("[ 관리자 모드 ]");
        System.out.println("1. 상품 추가");
        System.out.println("2. 상품 수정");
        System.out.println("3. 상품 삭제");
        System.out.println("4. 전체 상품 현황");
        System.out.println("0. 메인으로 돌아가기");
    }

    public void addProduct()
    {

    }


}
