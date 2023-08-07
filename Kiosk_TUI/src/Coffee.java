class Coffee extends Beverage {
    boolean decaffeine;
    String origin;

    Coffee(String name, int price, boolean ice, boolean decaffeine, String origin) {
        super(name, price, ice);
        this.decaffeine = decaffeine;
        this.origin = origin;
    }

    @Override
    public String toString() {
        return super.toString() + (decaffeine ? " 디카페인" : "") + " (" + origin + ")";
    }
}