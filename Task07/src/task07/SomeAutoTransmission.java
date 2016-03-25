package task07;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Peter on 08.02.2016.
 */
@Component
@Qualifier(value = "auto_trans")
public class SomeAutoTransmission extends SomeTransmission implements AutoTransmission
{
    @Value("true")
    boolean isAutoMode;
    public SomeAutoTransmission(int currentGear, int numberOfGears, boolean isOk, boolean autoMode) {
        super(currentGear, numberOfGears, isOk);
        isAutoMode = autoMode;
    }
public SomeAutoTransmission(){

}
    @Override
    public void autoOn(boolean on) {
        isAutoMode = on;
    }
}
