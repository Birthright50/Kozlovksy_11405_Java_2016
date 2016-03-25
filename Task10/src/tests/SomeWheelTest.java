package tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import our_classes.SomeWheel;


/**
 * Created by Birthright on 25.02.2016.
 */
public class SomeWheelTest {
    public static SomeWheel steeringWheel;
    @BeforeClass
    public static void createWheel(){
        steeringWheel = (SomeWheel) Config.ac.getBean("some_wheel");

    }
    @Test
    public void beepengShouldBeWork(){
        steeringWheel.beeping();
        Assert.assertTrue("Beep".equals(steeringWheel.getCurrent_act()));
    }
    @Test
    public void turnLeftShouldBeWork(){
        steeringWheel.turnLeft(true);
        Assert.assertTrue("Turn left with signal".equals(steeringWheel.getCurrent_act()));
        steeringWheel.turnLeft(false);
        Assert.assertTrue("Turn left".equals(steeringWheel.getCurrent_act()));
    }
    @Test
    public void turnRightShouldBeWork(){
        steeringWheel.turnRight(true);
        Assert.assertTrue("Turn right with signal".equals(steeringWheel.getCurrent_act()));
        steeringWheel.turnRight(false);
        Assert.assertTrue("Turn right".equals(steeringWheel.getCurrent_act()));
    }
}
