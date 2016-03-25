package our_classes;

/**
 * Created by Peter on 08.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        SteeringWheel wheel = new SomeWheel(50, true, true);
        ManualPedal mPedal = new SomeManualPedal(50, true);
        Engine engine = new SomeEngine(343, 360, false);
        Transmission transmission = new SomeTransmission(1, 6, true);
        Car m3E46 = new BMWM3E46(wheel, mPedal, transmission, engine);
        m3E46.getWheel().beeping();
        m3E46.getWheel().turnLeft(true);
        m3E46.getWheel().turnRight(true);
        m3E46.swapEngine(new SomeEngine(500, 700, true));
        m3E46.getTransmission().downshift((byte) 50);

    }
}
