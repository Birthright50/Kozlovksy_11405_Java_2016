package task04;

/**
 * Created by Peter on 08.02.2016.
 */
public class SomePedal implements Pedal {
    private int size;

    public SomePedal(int size, boolean comfortable) {
        this.size = size;
        this.comfortable = comfortable;
    }

    private boolean comfortable;
    private String current_act;

    public int getSize() {
        return size;
    }

    public boolean isComfortable() {
        return comfortable;
    }

    public String getCurrent_act() {
        return current_act;
    }

    @Override
    public void gasPedal(byte effort) {
        if (effort > 80) {
            current_act = "going fast";
        } else {
            current_act = "going slow";
        }
        System.out.println(current_act);
    }

    @Override
    public void brakePedal(byte effort) {
        if (effort > 80) {
            current_act = "brake fast";
        } else {
            current_act = "brake slow";
        }
        System.out.println(current_act);
    }
}
