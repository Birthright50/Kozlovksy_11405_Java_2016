package task04.tests;

import org.junit.Assert;
import org.junit.Test;
import task04.SomeAutoTransmission;

/**
 * Created by Birthright on 25.02.2016.
 */
public class SomeAutoTransTest {
    @Test
    public void autoModeSholdBeWork(){
        SomeAutoTransmission someAutoTransmission = new SomeAutoTransmission(1, 6, true, false);
        someAutoTransmission.autoOn(true);
        Assert.assertTrue(someAutoTransmission.isAutoMode());

    }
}
