package task07;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Peter on 08.02.2016.
 */
@Component
@Qualifier("pedal")
public class SomeManualPedal extends SomePedal implements ManualPedal {
    public SomeManualPedal(int size, boolean comfortable) {
        super(size, comfortable);
    }

    public SomeManualPedal() {

    }

    @Override
    public void clutch(byte effort) {
        if(effort > 80) {
            System.out.println("good");
        }
        else{
            System.out.println("bad");
        }
    }
}
