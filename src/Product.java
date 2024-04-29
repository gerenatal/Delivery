public enum Product {
    BURRITO("Burrito", 6.5, "Won a pin per burrito unit(s)!"),
    SANDWICH("Sandwich",8.9, "Won a hoodie per sandwich unit(s)!"),
    KEBAB("Kebab",4.5,""),
    PIZZA("Pizza",7.9,"");
    private String name;
    private double price;
    private String gift;
    Product(String name, double price, String gift) {
        this.name = name;
        this.price = price;
        this.gift = gift;
    }
    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }
    public String getGift(){
        return gift;
    }
}
