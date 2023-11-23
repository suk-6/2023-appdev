package kr.hs.data.kiosk;

class Coffee extends Beverage {
    boolean decaffeinate;
    String origin;

    Coffee(String name, int price, boolean ice, boolean decaffeinate, String origin, int thumbnail) {
        super(name, price, ice, thumbnail);
        this.decaffeinate = decaffeinate;
        this.origin = origin;
    }

    @Override
    public String toString() {
        return super.toString() + (decaffeinate ? " 디카페인" : "") + " (" + origin + ")";
    }
}