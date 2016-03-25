package task07;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Peter on 08.02.2016.
 */
@Component
public class SomePedal implements Pedal {
    @Value(value = "60")
    int size;

    public SomePedal(int size, boolean comfortable) {
        this.size = size;
        this.comfortable = comfortable;
    }

    @Value(value = "true")
    boolean comfortable;

    public SomePedal() {
    }

    @Override
    public void gasPedal(byte effort) {
        if (effort > 80) {
            System.out.println("going fast");
        } else {
            System.out.println("going slow");
        }
    }

    @Override
    public void brakePedal(byte effort) {
        if (effort > 80) {
            System.out.println("brake fast");
        } else {
            System.out.println("brake slow");
        }
    }
}
