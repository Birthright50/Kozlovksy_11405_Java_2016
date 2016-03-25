package tests;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import our_classes.SomeEngine;


/**
 * Created by Birthright on 25.02.2016.
 */
public class SomeEngineTest {
    private static SomeEngine someEngine;
    @BeforeClass
    public static void createEngine(){
        someEngine = (SomeEngine) Config.ac.getBean("some_engine");

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
