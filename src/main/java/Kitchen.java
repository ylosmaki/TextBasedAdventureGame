import java.util.List;

public class Kitchen extends Room {
    public Kitchen(List<String> list) {
        super(list);
    }

    @Override
    public void introduceRoom() {
        System.out.println("You have entered the kitchen. You are greeted by the smell of something rotting.");
    }
}
