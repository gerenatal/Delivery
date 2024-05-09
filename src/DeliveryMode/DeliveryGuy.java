package DeliveryMode;
import Exceptions.NoDeliveryGuyAvailableException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum DeliveryGuy {
    MARCOS("Marcos", true),
    CLAUDIO("Claudio", true),
    MONICA("Monica", true);

    private String name;
    private boolean available;

    DeliveryGuy(String name, boolean available){
        this.name = name;
        this.available = available;
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
    public static DeliveryGuy selectRandomAvailable() {
        DeliveryGuy deliveryGuyAvailable = null;
        try {
            checkIfAnyAvailable();
            List<DeliveryGuy> availableGuys = new ArrayList<>();
            for (DeliveryGuy deliveryGuy : DeliveryGuy.values()) {
                if (deliveryGuy.isAvailable()) {
                    availableGuys.add(deliveryGuy);
                }
            }
            Random random = new Random();
             deliveryGuyAvailable = availableGuys.get(random.nextInt(availableGuys.size()));
        } catch (NoDeliveryGuyAvailableException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return deliveryGuyAvailable;
    }

    public static void checkIfAnyAvailable() throws NoDeliveryGuyAvailableException {
        for (DeliveryGuy deliveryGuy : DeliveryGuy.values()) {
            if (deliveryGuy.isAvailable()) {
                return;
            }
        }
        throw new NoDeliveryGuyAvailableException("No delivery guy available.");
    }
}