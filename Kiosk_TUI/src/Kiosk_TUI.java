public class Kiosk_TUI {

    String helloMsg = "Hello World!";
    int cash = 1000000;
    Menu menu1;
    Menu menu2;
    Menu menu3;
    Menu menu4;
    Menu menu5;

    public static void main(String[] args) {
        Kiosk_TUI myKiosk = new Kiosk_TUI();
        myKiosk.menu1 = new Menu("아아");
        myKiosk.menu2 = new Menu("뜨아", 3300);
        myKiosk.menu3 = new Beverage("레몬에이드", 4000, true);
        myKiosk.menu4 = new Coffee("카페모카", 4500, false, false, "콜롬비아");
        myKiosk.menu5 = new Coffee("카라멜마끼야또", 3300, true, false, "멕시코");

        System.out.println(myKiosk.menu1.name);
        System.out.println(myKiosk.menu1.price);
    }

    int pay() {
        return 500;
    }
}
