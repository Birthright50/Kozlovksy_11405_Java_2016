package our_classes;

/**
 * Created by Peter on 08.02.2016.
 */
public class SomeManualPedal extends SomePedal implements ManualPedal {
    public SomeManualPedal(int size, boolean comfortable) {
        super(size, comfortable);
    }

    private String current_act;

    @Override
    public String getCurrent_act() {
        return current_act;
    }

    @Override
    public void clutch(byte effort) {
        if (effort > 80) {
            current_act = "good";
        } else {
            current_act = "bad";
        }
        System.out.println(current_act);
    }
}
