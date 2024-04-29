import java.util.ArrayList;
import java.util.List;

public class Delivery {
    private List<String> available;
    private List<String> busy;

    public Delivery(){
        available = new ArrayList<>();
        busy = new ArrayList<>();
        available.add("Marcos");
        available.add("Claudio");
        available.add("Monica");
    }

    public void becomeAvailable(String name){
        busy.remove(name);
        available.add(name);
    }

    public void becomeBusy(String name){
        available.remove(name);
        busy.add(name);
    }

    public List<String> getAvailable() {
        return available;
    }
}