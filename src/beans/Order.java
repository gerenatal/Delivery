package beans;

import DeliveryMode.DeliveryMode;
import Products.Product;

import java.util.List;

public class Order {
    private static int idCounter = 1;
    private final int id;
    private final Client client;
    private final List<Product> products;
    private final String deliveryGuy;
    private final DeliveryMode deliveryMode;
    private boolean deliveredStatus;
    private final double finalPrice;

    public Order(Client client, List<Product> products, String deliveryGuy, DeliveryMode deliveryMode) {
        this.id = idCounter++;
        this.client = client;
        this.products = products;
        this.deliveryGuy = deliveryGuy;
        this.deliveryMode = deliveryMode;
        deliveredStatus = false;
        this.finalPrice = calculateFinalPrice();
    }

    private double calculateFinalPrice() {
        double totalPrice = products.stream().mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();
        return deliveryMode.finalPriceCalc(totalPrice);
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getDeliveryGuy() {
        return deliveryGuy;
    }

    public DeliveryMode getDeliveryMode() {
        return deliveryMode;
    }

    public boolean isDeliveredStatus() {
        return deliveredStatus;
    }

    public void setDeliveredStatus(boolean deliveredStatus) {
        this.deliveredStatus = deliveredStatus;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Details:\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Client: ").append(client.getName()).append("\n");
        sb.append("Address: ").append(client.getAddress()).append("\n");
        sb.append("Products:\n");
        for (Product product : products) {
            sb.append("- ").append(product.getName()).append(": ").append(product.getQuantity()).append(" units\n");
            product.giftMessage();
        }
        sb.append("Delivery Guy: ").append(deliveryGuy).append("\n");
        sb.append("Delivery Mode: ").append(deliveryMode.getClass().getSimpleName()).append("\n");
        sb.append("Total Price: $").append(String.format("%.2f", finalPrice));
        return sb.toString();
    }
}
