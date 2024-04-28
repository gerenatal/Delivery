import java.util.Scanner;
public class Menu {
    private static Menu instance;
    static Menu getInstance(){
        return instance == null ? instance = new Menu() : instance;
    }
    private Menu(){}
    public void menuLoop(){
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
                    //makeNewOrder();
                    break;
                case "2":
                    //updateOrderStatus();
                    break;
                case "3":
                    //listOngoingOrders();
                    break;
                case "4":
                    //listDeliveredOrders();
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    static String lineInput(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }
}
