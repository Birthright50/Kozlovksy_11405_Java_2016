package tests;

import org.junit.Assert;
import org.junit.Test;
import our_classes.SomeAutoTransmission;


/**
 * Created by Birthright on 25.02.2016.
 */
public class SomeAutoTransTest {
    @Test
    public void autoModeSholdBeWork(){
        SomeAutoTransmission someAutoTransmission = (SomeAutoTransmission) Config.ac.getBean("some_auto_trans");
        someAutoTransmission.autoOn(true);
        Assert.assertTrue(someAutoTransmission.isAutoMode());

    }
}
