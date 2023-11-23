package kr.hs.data.kiosk;

class Beverage extends Menu {
    boolean ice;

    public Beverage(String name, int price, boolean ice, int thumbnail) {
        super(name, price, thumbnail);
        this.name = super.name + "(음료)";
        this.ice = ice;
    }

    @Override
    public String toString() {
        return super.toString() + (ice ? "- ICE" : "- HOT");
    }
}
