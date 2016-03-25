package task07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Peter on 08.02.2016.
 */
@Component
public class BMWM3E46 implements Car {
    @Autowired

    private SteeringWheel wheel;
    @Autowired

    private ManualPedal pedal;
    @Autowired
    @Qualifier(value = "transmission")
    private Transmission transmission;
    @Autowired
    @Qualifier(value = "engine")
    private Engine engine;

    public BMWM3E46(SteeringWheel wheel, ManualPedal pedal, Transmission transmission, Engine engine) {
        this.wheel = wheel;
        this.pedal = pedal;
        this.transmission = transmission;
        this.engine = engine;
    }

    public BMWM3E46() {
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
