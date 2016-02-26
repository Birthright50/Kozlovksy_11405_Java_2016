package task04;

/**
 * Created by Peter on 08.02.2016.
 */
public class SomeTransmission implements Transmission {
    int currentGear;

    public int getCurrentGear() {
        return currentGear;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public boolean isOk() {
        return isOk;
    }

    int numberOfGears;
    boolean isOk;

    public SomeTransmission(int currentGear, int numberOfGears, boolean isOk) {
        this.currentGear = currentGear;
        this.numberOfGears = numberOfGears;
        this.isOk = isOk;
    }

    @Override
    public void upshift(byte toWhatExtent) {
        if (currentGear < numberOfGears && currentGear + toWhatExtent <= numberOfGears) {
            currentGear += toWhatExtent;
        }
    }

    @Override
    public void downshift(byte toWhatExtent) {
        if (currentGear > 1 && currentGear - toWhatExtent >= 1) {
            currentGear -= toWhatExtent;
        }
    }

    @Override
    public void reverseGear() {
        currentGear = -1;
    }
}
