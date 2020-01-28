import java.util.List;

public class LaundryRoom extends Room {
    public LaundryRoom(List<String> list) {
        super(list);
    }

    @Override
    public void introduceRoom() {
        System.out.println("You have entered the laundry room.");
    }
}
