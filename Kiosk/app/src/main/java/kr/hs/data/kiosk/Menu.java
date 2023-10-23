package kr.hs.data.kiosk;

public class Menu {
    String name;
    int price;

    Menu(String name) {
        this.name = name;
    }

    Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price + "원";
    }
}
