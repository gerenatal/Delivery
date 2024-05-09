package orders;

import beans.Order;

public interface Lists {
    void addOrder(Order order);
    void setAsDelivered(int id);
    void listOngoingOrders();
    void listDeliveredOrders();
}