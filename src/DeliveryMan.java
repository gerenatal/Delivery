public class DeliveryMan {
    private String name;
    private boolean available;
    public DeliveryMan(String name) {
        this.name = name;
        this.available = true;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}