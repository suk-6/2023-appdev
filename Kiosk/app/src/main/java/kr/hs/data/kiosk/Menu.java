package kr.hs.data.kiosk;

import java.io.Serializable;

public class Menu implements Serializable {
    String name;
    int price;
    int thumbnail = -1;

    Menu(String name) {
        this.name = name;
    }

    Menu(String name, int price, int thumbnail) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return name + " " + price + "원";
    }
}
