class Beverage extends Menu {
    boolean ice;

    public Beverage(String name, int price, boolean ice) {
        super(name, price);
        this.name = super.name + "(음료)";
        this.ice = ice;
    }

    @Override
    public String toString() {
        return super.toString() + (ice ? "- ICE" : "- HOT");
    }
}
