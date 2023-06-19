public class Kiosk_TUI {

    String helloMsg = "Hello World!";
    int cash = 10000000;

    public static void main(String[] args) throws Exception {
        Kiosk_TUI myKiosk = new Kiosk_TUI();

        myKiosk.helloMsg = "Hi";
        myKiosk.cash = 1000;

        System.out.println(myKiosk.helloMsg);
        System.out.println(myKiosk.cash);
        System.out.println(myKiosk.pay());
    }

    int pay() {
        return 500;
    }
}
