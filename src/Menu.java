import DeliveryMode.DeliveryGuy;
import orders.OrderFactory;
import orders.OrdersList;
import java.util.Scanner;
public class Menu {
    private DeliveryGuy deliveryGuy;
    private final OrdersList ordersList;
    public Menu() {
        ordersList = new OrdersList();
    }

    public void menuLoop() {
        OrderFactory orderFactory = new OrderFactory();
        boolean exit = false;
        while (!exit) {
            String choice = lineInput("""
                    Enter your choice:
                    1. New order
                    2. Update ongoing order
                    3. List ongoing orders
                    4. List delivered orders
                    5. Exit""");
            switch (choice) {
                case "1":
                    ordersList.addOrder(OrderFactory.makeOrder(DeliveryGuy.selectRandomAvailable()));
                    //add new order
                    //now set the "available" correspondent deliveryGuy that is busy with the order just created to false
                    break;
                case "2":
                    int id = intInput("Insert order ID:");
                    //Implement update ongoing order to delivered
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
    static String lineInput (String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }
    static int intInput (String message){
    Scanner in = new Scanner(System.in);
    System.out.println(message);
    return in.nextInt();
    }
}