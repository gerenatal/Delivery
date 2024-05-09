package Products;
public class Burrito extends Product {
    public Burrito() {
        super("burrito", 6.5);
    }
    @Override
    public void giftMessage(){
        System.out.println("You get a pin as a gift!");
    }
}
