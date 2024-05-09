package Products;

public class Sandwich extends Product {
    public Sandwich(){
        super("sandwich", 8.9);
    }

    @Override
    public void giftMessage(){
        System.out.println("You get a hoodie as a gift!");
    }
}
