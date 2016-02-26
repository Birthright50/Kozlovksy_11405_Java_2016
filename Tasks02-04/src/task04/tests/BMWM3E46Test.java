package task04.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import task04.*;

import static org.mockito.Mockito.mock;

/**
 * Created by Birthright on 25.02.2016.
 */
public class BMWM3E46Test {
    private static Transmission transmission;
    private static Engine engine;
    private static SteeringWheel wheel;
    private static ManualPedal pedal;
    private static BMWM3E46 bmwm3E46;

    @BeforeClass
    public static void createE46() {
        transmission = mock(Transmission.class);
        engine = mock(Engine.class);
        pedal = mock(ManualPedal.class);
        wheel = mock(SteeringWheel.class);
        bmwm3E46 = new BMWM3E46(wheel, pedal, transmission, engine);
    }

    @Test
    public void allGettersShouldBeWork() {
        Assert.assertTrue(bmwm3E46.getEngine().equals(engine) && bmwm3E46.getPedal().equals(pedal) && bmwm3E46.getTransmission().equals(transmission) && bmwm3E46.getWheel().equals(wheel));

    }

    @AfterClass
    public static void swapEngineShouldBeWork() {
        Engine eng = mock(Engine.class);
        bmwm3E46.swapEngine(eng);
        Assert.assertFalse(bmwm3E46.getEngine().equals(engine));
    }


}
