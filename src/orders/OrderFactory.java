package orders;
import DeliveryMode.*;
import Products.*;
import beans.Client;
import beans.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderFactory {

    public static Order makeOrder(DeliveryGuy deliveryGuy) {
        Client client = addClient();
        List<Product> products = addProducts();
        String deliveryGuyName = deliveryGuy.getName();
        DeliveryMode deliveryMode = selectDeliveryMode();
        return new Order(client, products, deliveryGuyName, deliveryMode);
    }

    static Client addClient() {
        String clientName = lineInput("Insert client name:");
        String clientAddress = lineInput(("Insert client address:"));
        return new Client(clientName, clientAddress);
    }

    static List<Product> addProducts() {
        List<Product> products = new ArrayList<>();
        boolean exit = false;
        while (!exit) {
            String choice = lineInput("""
                    Select the product:
                    1. Burrito
                    2. Sandwich
                    3. Kebab
                    4. Pizza
                    5. Done""");
            switch (choice) {
                case "1":
                    addOrUpdateProduct(products, new Burrito());
                    break;
                case "2":
                    addOrUpdateProduct(products, new Sandwich());
                    break;
                case "3":
                    addOrUpdateProduct(products, new Kebab());
                    break;
                case "4":
                    addOrUpdateProduct(products, new Pizza());
                    break;
                case "5":
                    if(products.isEmpty()){
                        System.out.println("Order cannot be empty!");
                    }else{
                        exit = true;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        return products;
    }

    static void addOrUpdateProduct(List<Product> products, Product newProduct) {
        for (Product product : products) {
            if (product.getName().equals(newProduct.getName())) {
                product.setQuantity(product.getQuantity() + 1);
                return;
            }
        }
        products.add(newProduct);
    }

    static DeliveryMode selectDeliveryMode() {
        DeliveryMode deliveryMode = new Foot();
        String option;
        boolean exit = false;
        while (!exit) {
            option = lineInput("""
                    Select the delivery mode:
                    1. Bike
                    2. Motorcycle
                    3. On foot""");
            switch (option) {
                case "1":
                    deliveryMode = new Bike();
                    exit = true;
                    break;
                case "2":
                    deliveryMode = new Moto();
                    exit = true;
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        return deliveryMode;
    }

    static String lineInput(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }
}
