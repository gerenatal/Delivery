import java.util.HashMap;
import java.util.Scanner;

public class OrderFactory {
    private Order order;
    public OrderFactory(int newOrderId, String deliveryGuy){
        this.order = makeOrder(newOrderId, deliveryGuy);
    }

    public Order makeOrder(int newOrderId, String deliveryGuy){
        String clientName = lineInput("Insert client name:");
        String clientAddress = lineInput(("Insert client address:"));
        Client client = new Client(clientName, clientAddress);
        HashMap<Product, Integer> products = new HashMap<>();
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
                    products.put(Product.BURRITO, products.getOrDefault(Product.BURRITO, 0) + 1);
                    break;
                case "2":
                    products.put(Product.SANDWICH, products.getOrDefault(Product.SANDWICH, 0) + 1);
                    break;
                case "3":
                    products.put(Product.KEBAB, products.getOrDefault(Product.KEBAB, 0) + 1);
                    break;
                case "4":
                    products.put(Product.PIZZA, products.getOrDefault(Product.PIZZA, 0) + 1);
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        Order order = new Order(newOrderId, client, products, deliveryGuy, selectTransportation());
        return order;
    }

    public Order getOrder() {
        return order;
    }

    static String lineInput(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

    static String selectTransportation(){
        String transportation = "foot";
        String option;
        boolean exit = false;
        while (!exit){
            option = lineInput(("""
                    Select transportation:
                    1. Bike
                    2. Motorcycle
                    3. On foot"""));
            switch (option){
                case "1":
                    transportation = "bike";
                    exit = true;
                    break;
                case "2":
                    transportation = "motorcycle";
                    exit = true;
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        return transportation;
    }
}
