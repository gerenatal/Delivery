package Products;

public class Sandwich extends Product {
    public Sandwich(){
        super("sandwich", 8.9);
    }

    @Override
    public String giftMessage(){
        return "You get a hoodie as a gift!";
    }
}
