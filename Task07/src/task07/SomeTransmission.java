package task07;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Peter on 08.02.2016.
 */
@Component
@Qualifier("transmission")
public class SomeTransmission implements Transmission {
    @Value("1")
    int currentGear;
    @Value("6")
    int numberOfGears;
    @Value("true")
    boolean isOk;

    public SomeTransmission() {
    }

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
