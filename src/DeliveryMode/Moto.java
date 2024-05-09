package DeliveryMode;

public class Moto implements DeliveryMode{
    @Override
    public double finalPriceCalc(double totalPrice) {
        return totalPrice*1.02;
    }
}
