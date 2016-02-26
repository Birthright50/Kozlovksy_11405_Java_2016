package task04;

/**
 * Created by Peter on 08.02.2016.
 */
public class BMWM3E92 implements Car {
    SteeringWheel wheel;
    Pedal pedal;
    AutoTransmission transmission;
    Engine engine;

    public BMWM3E92(SteeringWheel wheel, Pedal pedal, AutoTransmission transmission, Engine engine) {
        this.wheel = wheel;
        this.pedal = pedal;
        this.transmission = transmission;
        this.engine = engine;
    }

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
