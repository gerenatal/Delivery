package Products;
public class Pizza extends Product{
    public Pizza(){
        super("pizza", 7.9);
    }
    @Override
    public String giftMessage(){
        return "";
    }
}
