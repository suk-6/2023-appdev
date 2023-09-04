import java.util.Scanner;

public class Kiosk_TUI {

    String helloMsg = "Hello World!";
    int cash = 1000000;
    Menu[] menus = new Menu[5];
    static Menu selectedMenu = null;

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

            try {
                String input = myScanner.nextLine();
                int menuNum = Integer.parseInt(input);

                if (menuNum < 1 || menuNum > myKiosk.menus.length) {
                    throw new Exception("메뉴 번호가 잘못되었습니다.");
                }

                selectedMenu = myKiosk.menus[menuNum - 1];
                System.out.println("\n선택하신 메뉴는 [" + selectedMenu.name + "] 입니다.");
                System.out.println("결제하실 금액은 [" + selectedMenu.price + "] 입니다.\n");
                System.out.println("결제를 진행합니다.");
                System.out.println("현금 입력: ");
                input = myScanner.nextLine();

                int cash = Integer.parseInt(input);
                int change = myKiosk.pay(selectedMenu.price, cash);

                if (change == -1) {
                    throw new Exception("결제 금액이 부족합니다.");
                } else {
                    System.out.println("\n결제가 완료되었습니다.");
                    System.out.println("거스름돈은 [" + change + "] 입니다.\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    int pay(int price, int cash) {
        int change = cash - price;
        if (change < 0) {
            return -1;
        }
        return change;
    }

    void showMenus() {
        for (int i = 0; i < menus.length; i++) {
            System.out.println((i + 1) + ". " + menus[i]);
        }
    }
}
