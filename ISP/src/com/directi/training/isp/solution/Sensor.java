import java.util.Random;

public class Sensor {
    public void register(ISensing sensingDoor) {
        while (true) {
            if (isPersonClose()) {
                sensingDoor.proximityCallback();
                break;
            }
        }
    }

    private boolean isPersonClose() {
        return new Random().nextBoolean();
    }
}
