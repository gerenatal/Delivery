package DeliveryMode;

public class Foot implements DeliveryMode{
    @Override
    public double finalPriceCalc(double totalPrice) {
        return totalPrice;
    }
}
