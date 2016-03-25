/**
 * Created by Peter on 08.02.2016.
 */
public class SomeManualPedal extends SomePedal implements ManualPedal {
    public SomeManualPedal(int size, boolean comfortable) {
        super(size, comfortable);
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
