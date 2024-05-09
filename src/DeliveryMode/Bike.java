package DeliveryMode;

public class Bike implements DeliveryMode{
    @Override
    public double finalPriceCalc(double totalPrice) {
        return totalPrice*1.01;
    }
}
