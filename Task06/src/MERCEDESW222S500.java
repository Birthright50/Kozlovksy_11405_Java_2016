/**
 * Created by Peter on 08.02.2016.
 */
public class MERCEDESW222S500 implements Car {
    SteeringWheel wheel;
    Pedal pedal;

    public MERCEDESW222S500(SteeringWheel wheel, ManualPedal pedal, AutoTransmission transmission, Engine engine) {
        this.wheel = wheel;
        this.pedal = pedal;
        this.transmission = transmission;
        this.engine = engine;
    }

    AutoTransmission transmission;
    Engine engine;

    @Override
    public SteeringWheel getWheel() {
        return wheel;
    }

    @Override
    public Pedal getPedal() {
        return pedal;
    }

    @Override
    public Transmission getTransmission() {
        return transmission;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public void swapEngine(Engine newEngine) {
        engine = newEngine;
    }
}
