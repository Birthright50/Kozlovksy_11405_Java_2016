package task04.tests;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import task04.SomeEngine;

/**
 * Created by Birthright on 25.02.2016.
 */
public class SomeEngineTest {
    private static SomeEngine someEngine;
    @BeforeClass
    public static void createEngine(){
        someEngine = new SomeEngine(343, 360, false);

    }

    @Test
    public void turnOnEngineShouldWork(){
        someEngine.runEngine();
        Assert.assertTrue(someEngine.getCurrent_act().equals("engine is on"));
    }

    @Test
    public void turnOffEngineShouldWork(){
        someEngine.stopEngine();
        Assert.assertTrue(someEngine.getCurrent_act().equals("engine is off"));
    }

    @Test
    public void boostShouldBeCorrect(){
        someEngine.boost(true);
       Assert.assertTrue(someEngine.getHp() == 490);
        Assert.assertTrue(someEngine.getTorque() == 450);
    }
}
