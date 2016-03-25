package tests;


import org.junit.Assert;
import org.junit.Test;
import our_classes.SomeManualPedal;


/**
 * Created by Birthright on 25.02.2016.
 */
public class SomeManualPedalTest {
@Test
    public void clutchShouldBeWork(){
    SomeManualPedal someManualPedal = (SomeManualPedal) Config.ac.getBean("some_man_pedal");

    someManualPedal.clutch((byte) 70);
    Assert.assertTrue(someManualPedal.getCurrent_act().equals("bad"));
    someManualPedal.clutch((byte) 100);
    Assert.assertTrue(someManualPedal.getCurrent_act().equals("good"));
}
}
