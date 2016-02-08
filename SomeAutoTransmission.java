/**
 * Created by Peter on 08.02.2016.
 */
public class SomeAutoTransmission extends SomeTransmission implements AutoTransmission
{
    boolean isAutoMode;
    public SomeAutoTransmission(int currentGear, int numberOfGears, boolean isOk, boolean autoMode) {
        super(currentGear, numberOfGears, isOk);
        isAutoMode = autoMode;
    }

    @Override
    public void autoOn(boolean on) {
        isAutoMode = on;
    }
}
