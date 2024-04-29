import java.util.ArrayList;
import java.util.HashMap;

public class OrdersList implements Lists {
    private HashMap<String, Order> ongoingOrders;
    private ArrayList<Order> deliveredOrders;

    private static OrdersList instance;
    static OrdersList getInstance(){
        return instance == null ? instance = new OrdersList() : instance;
    }
    private OrdersList() {
        ongoingOrders = new HashMap<>();
        deliveredOrders = new ArrayList<>();
    }

    public void addOngoingOrder(Order order){
        ongoingOrders.put(String.valueOf(order.getId()), order);
    }
    public void addDeliveredOrder(String id){
        deliveredOrders.add(ongoingOrders.get(id));
        ongoingOrders.remove(id);
    }
    public void listOngoingOrders(){
        for (HashMap.Entry<String, Order> entry : ongoingOrders.entrySet()) {
            System.out.println(entry.getValue().toString());
            System.out.println("---------");
        }
    }
    public void listDeliveredOrders(){
        for (Order order : deliveredOrders) {
            System.out.println((order.toString()));
            System.out.println("---------");
        }
    }
    public HashMap<String, Order> getOngoingOrders() {
        return ongoingOrders;
    }
}
