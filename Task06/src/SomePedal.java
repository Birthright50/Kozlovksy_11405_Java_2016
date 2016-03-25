/**
 * Created by Peter on 08.02.2016.
 */
public class SomePedal implements Pedal {
    int size;

    public SomePedal(int size, boolean comfortable) {
        this.size = size;
        this.comfortable = comfortable;
    }

    boolean comfortable;

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
