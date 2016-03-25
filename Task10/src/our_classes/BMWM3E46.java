package our_classes;

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

    public BMWM3E46() {
    }

    Transmission transmission;
    Engine engine;

    public void setWheel(SteeringWheel wheel) {
        this.wheel = wheel;
    }

    public void setPedal(ManualPedal pedal) {
        this.pedal = pedal;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setEngine(Engine engine) {
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
