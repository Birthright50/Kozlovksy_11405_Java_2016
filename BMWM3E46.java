/**
 * Created by Peter on 08.02.2016.
 */
public class BMWM3E46 implements Car {
    SteeringWheel wheel;
    ManualPedal pedal;

    public BMWM3E46(SteeringWheel wheel, ManualPedal pedal, Transmission transmission, Engine engine) {
        this.wheel = wheel;
        this.pedal = pedal;
        this.transmission = transmission;
        this.engine = engine;
    }

    Transmission transmission;
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
