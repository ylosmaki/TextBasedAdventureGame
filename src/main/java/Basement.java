import java.util.List;

public class Basement extends Room {
    public Basement(List<String> list) {
        super(list);
    }

    @Override
    public void introduceRoom() {
        System.out.println("You walk down steep stairs into a cold damp basement.");
    }
}
