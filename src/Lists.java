public interface Lists {
    void addOngoingOrder(Order order);
    void addDeliveredOrder(String id);
    void listOngoingOrders();
}