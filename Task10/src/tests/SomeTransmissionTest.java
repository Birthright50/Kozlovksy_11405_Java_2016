package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import our_classes.SomeTransmission;


/**
 * Created by Birthright on 25.02.2016.
 */
public class SomeTransmissionTest {
    private static SomeTransmission someTransmission;

    @Before
    public void createTransmission() {
        someTransmission = (SomeTransmission) Config.ac.getBean("some_transmission");
    }

    @Test
    public void upShiftShouldBeWork() {
        int a = someTransmission.getCurrentGear();
        someTransmission.upshift((byte) 5);
        Assert.assertEquals(a + 5, someTransmission.getCurrentGear());
    }

    @Test
    public void downShiftShouldBeWork() {
        int a = someTransmission.getCurrentGear();
        someTransmission.downshift((byte) 5);
        Assert.assertEquals(a, someTransmission.getCurrentGear());
    }

    @Test
    public void reverseGearShouldBeWork(){
        someTransmission.reverseGear();
        Assert.assertEquals(-1, someTransmission.getCurrentGear());
    }
}
