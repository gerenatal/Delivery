package orders;

import Exceptions.NoIdFoundException;
import beans.Order;
import java.util.ArrayList;
import java.util.List;

public class OrdersList implements Lists {
    private final List<Order> orders;

    public OrdersList() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Order added to the list");
    }

    @Override
    public void setAsDelivered(int id) {
        try {
            checkIfIdExists(id);
            for (Order order : orders) {
                if (order.getId() == id) {
                    order.setDeliveredStatus(true);
                    System.out.println("Order marked as delivered.");
                    return;
                }
            }
        } catch (NoIdFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private void checkIfIdExists(int id) throws NoIdFoundException {
        boolean found = false;
        for (Order order : orders) {
            if (order.getId() == id) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new NoIdFoundException("ID does not exist.");
        }
    }

    @Override
    public void listOngoingOrders() {
        System.out.println("Ongoing Orders:");
        for (Order order : orders) {
            if (!order.isDeliveredStatus()) {
                System.out.println(order);
            }
        }
    }

    @Override
    public void listDeliveredOrders() {
        System.out.println("Delivered Orders:");
        for (Order order : orders) {
            if (order.isDeliveredStatus()) {
                System.out.println(order);
            }
        }
    }
}
