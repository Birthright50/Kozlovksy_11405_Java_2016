/**
 * Created by Peter on 08.02.2016.
 */
public class SomeTransmission implements Transmission {
    int currentGear;
    int numberOfGears;
    boolean isOk;

    public SomeTransmission(int currentGear, int numberOfGears, boolean isOk) {
        this.currentGear = currentGear;
        this.numberOfGears = numberOfGears;
        this.isOk = isOk;
    }

    @Override
    public void upshift(byte toWhatExtent) {
        if (currentGear < numberOfGears) {
            currentGear++;
        }
    }

    @Override
    public void downshift(byte toWhatExtent) {
        if (currentGear > 1) {
            currentGear--;
        }
    }

    @Override
    public void reverseGear() {
        currentGear = -1;
    }
}
