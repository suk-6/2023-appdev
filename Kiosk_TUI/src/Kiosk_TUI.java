public class Kiosk_TUI {

    String helloMsg = "Hello World!";
    int cash = 1000000;
    Menu[] menus = new Menu[5];

    public static void main(String[] args) {
        Kiosk_TUI myKiosk = new Kiosk_TUI();
        myKiosk.menus[0] = new Menu("아아");
        myKiosk.menus[1] = new Menu("뜨아", 3300);
        myKiosk.menus[2] = new Beverage("레몬에이드", 4000, true);
        myKiosk.menus[3] = new Coffee("카페모카", 4500, false, false, "콜롬비아");
        myKiosk.menus[4] = new Coffee("카라멜마끼야또", 3300, true, false, "멕시코");

        for (int i = 0; i < myKiosk.menus.length; i++) {
            System.out.println(myKiosk.menus[i]);
        }
    }

    int pay() {
        return 500;
    }
}
