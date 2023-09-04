import java.util.Scanner;

public class Kiosk_TUI {

    String helloMsg = "Hello World!";
    int cash = 1000000;
    Menu[] menus = new Menu[5];

    public static void main(String[] args) {
        while (true) {
            Kiosk_TUI myKiosk = new Kiosk_TUI();
            myKiosk.menus[0] = new Menu("아아", 3000);
            myKiosk.menus[1] = new Menu("뜨아", 3300);
            myKiosk.menus[2] = new Beverage("레몬에이드", 4000, true);
            myKiosk.menus[3] = new Coffee("카페모카", 4500, false, false, "콜롬비아");
            myKiosk.menus[4] = new Coffee("카라멜마끼야또", 3300, true, false, "멕시코");

            myKiosk.showMenus();

            System.out.println("\n원하는 메뉴를 입력해주세요(1~" + myKiosk.menus.length + "): ");
            Scanner myScanner = new Scanner(System.in);
            String input = myScanner.nextLine();

            int selectMenuPrice = 0;

            try {
                int menuNum = Integer.parseInt(input);
                if (menuNum < 1 || menuNum > myKiosk.menus.length) {
                    throw new Exception("메뉴 번호가 잘못되었습니다.");
                }

                selectMenuPrice = myKiosk.menus[menuNum - 1].price;
                System.out.println("선택하신 메뉴는 [" + myKiosk.menus[menuNum - 1] + "] 입니다.\n");
                System.out.println("결제를 진행합니다.");
                System.out.println("현금 입력: ");
                input = myScanner.nextLine();

                int cash = Integer.parseInt(input);

                myKiosk.pay(selectMenuPrice, cash);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void pay(int price, int cash) {
        int change = cash - price;
        if (change < 0) {
            System.out.println("잔액이 부족합니다.");
        } else {
            System.out.println("결제가 완료되었습니다. 거스름돈은 " + change + "원 입니다.");
            cash -= price;
        }
    }

    void showMenus() {
        for (int i = 0; i < menus.length; i++) {
            System.out.println(menus[i]);
        }
    }
}
