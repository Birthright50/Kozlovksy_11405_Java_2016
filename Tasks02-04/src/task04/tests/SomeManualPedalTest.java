package task04.tests;


import org.junit.Assert;
import org.junit.Test;
import task04.SomeManualPedal;

/**
 * Created by Birthright on 25.02.2016.
 */
public class SomeManualPedalTest {
@Test
    public void clutchShouldBeWork(){
    SomeManualPedal someManualPedal = new SomeManualPedal(50, true);

    someManualPedal.clutch((byte) 70);
    Assert.assertTrue(someManualPedal.getCurrent_act().equals("bad"));
    someManualPedal.clutch((byte) 100);
    Assert.assertTrue(someManualPedal.getCurrent_act().equals("good"));
}
}
