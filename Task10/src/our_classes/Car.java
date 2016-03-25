package our_classes;

/**
 * Created by Peter on 08.02.2016.
 */
public interface Car {
    SteeringWheel getWheel();
    Pedal getPedal();
    Transmission getTransmission();
    Engine getEngine();
    void swapEngine(Engine newEngine);

}
