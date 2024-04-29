import java.util.HashMap;

public class Order {
    private int id;
    private Client client;
    private HashMap<Product, Integer> products;
    private String deliveryGuy;
    private String transportation;
    private double totalPrice;

    public Order(int id, Client client, HashMap<Product, Integer> products, String deliveryGuy, String transportation){
        this.id = id;
        this.client = client;
        this.products = products;
        this.deliveryGuy = deliveryGuy;
        this.transportation = transportation;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        double total = 0.0;
        for (HashMap.Entry<Product, Integer> entry : products.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        switch (transportation){
            case "bike":
                total = total*1.01;
                break;
            case "motorcycle":
                total = total*1.02;
                break;
            default:
                transportation = "foot";
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public Client getClient(){
        return client;
    }
    public String getDeliveryGuy(){
        return deliveryGuy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Details:\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Client: ").append(client.getName()).append("\n");
        sb.append("Address: ").append((client.getAddress())).append("\n");
        sb.append("Products:\n");
        for (HashMap.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            sb.append("- ").append(product.getName()).append(": ").append(quantity).append(" units\n");
            sb.append(product.getGift()).append("\n");
        }
        sb.append("Delivery by: ").append(deliveryGuy).append(" on ").append(transportation).append("\n");
        sb.append("Total Price: $").append(String.format("%.2f",totalPrice));
        return sb.toString();
    }
}
