class Coffee extends Beverage {
    boolean decaffeine;
    String origin;

    Coffee(String name, int price, boolean ice, boolean decaffeine, String origin) {
        super(name, price, ice);
        this.decaffeine = decaffeine;
        this.origin = origin;
    }
}