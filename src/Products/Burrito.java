package Products;
public class Burrito extends Product {
    public Burrito() {
        super("burrito", 6.5);
    }
    @Override
    public String giftMessage(){
        return "You get a pin as a gift!";
    }
}
