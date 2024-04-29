import Exceptions.NoDeliveryGuyAvailableException;
import Exceptions.NoIdException;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Menu {
    private int newOrderId;
    private Delivery delivery;
    private static Menu instance;
    static Menu getInstance(){
        return instance == null ? instance = new Menu() : instance;
    }
    private Menu(){
        newOrderId = 0;
        delivery = new Delivery();
    }
    public void menuLoop(){
        OrdersList ordersList = OrdersList.getInstance();
        boolean exit = false;
        while (!exit) {
            String choice = lineInput("""
                    1. New order
                    2. Update ongoing order
                    3. List ongoing orders
                    4. List delivered orders
                    5. Exit
                    Enter your choice:""");
            switch (choice) {
                case "1":
                    try {
                        String deliveryGuy = selectRandomDeliveryGuy();
                        OrderFactory newOrder = new OrderFactory(newOrderId, deliveryGuy);
                        newOrderId++;
                        ordersList.addOngoingOrder(newOrder.getOrder());
                        delivery.becomeBusy(deliveryGuy);
                        System.out.println("Order created!");
                    } catch (NoDeliveryGuyAvailableException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;
                case "2":
                    String id = lineInput("Insert order ID:");
                    try{
                        checkIfIdExists(ordersList, id);
                        delivery.becomeAvailable(String.valueOf(ordersList.getOngoingOrders().get(id)));
                        ordersList.addDeliveredOrder(id);
                        System.out.println("Order set as delivered!");
                    }catch (NoIdException e){
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;
                case "3":
                    ordersList.listOngoingOrders();
                    break;
                case "4":
                    ordersList.listDeliveredOrders();
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private String selectRandomDeliveryGuy() throws NoDeliveryGuyAvailableException {
        List<String> availableDeliveryGuys = delivery.getAvailable();
        if (availableDeliveryGuys.isEmpty()) {
            throw new NoDeliveryGuyAvailableException("No delivery guy available.");
        }
        Random random = new Random();
        int index = random.nextInt(availableDeliveryGuys.size());
        return availableDeliveryGuys.get(index);
    }

    private void checkIfIdExists(OrdersList ordersList, String id) throws NoIdException {
        if (!orderExists(ordersList, id)) {
            throw new NoIdException("Order ID does not exist.");
        }
    }

    private boolean orderExists(OrdersList ordersList, String id) {
        return ordersList.getOngoingOrders().containsKey(id);
    }


    static String lineInput(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

}
