package task04.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task04.SomeTransmission;

/**
 * Created by Birthright on 25.02.2016.
 */
public class SomeTransmissionTest {
    private static SomeTransmission someTransmission;

    @Before
    public void createTransmission() {
        someTransmission = new SomeTransmission(1, 6, true);
    }

    @Test
    public void upShiftShouldBeWork() {
        int a = someTransmission.getCurrentGear();
        someTransmission.upshift((byte) 5);
        org.junit.Assert.assertEquals(a + 5, someTransmission.getCurrentGear());
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
