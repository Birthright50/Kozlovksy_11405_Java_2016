/**
 * Created by Peter on 08.02.2016.
 */
public class SomeWheel implements SteeringWheel {
    int radius;
    boolean leather;

    public SomeWheel(int radius, boolean leather, boolean threeSpokes) {
        this.radius = radius;
        this.leather = leather;
        this.threeSpokes = threeSpokes;
    }

    boolean threeSpokes;
    @Override
    public void turnRight(boolean turnSignal) {
        if(turnSignal){
            System.out.println("Turn right with signal");
        }
        else{
            System.out.println("turn right");
        }
    }

    @Override
    public void turnLeft(boolean turnSignal) {
        if(turnSignal){
            System.out.println("Turn left with signal");
        }
        else{
            System.out.println("turn left");
        }
    }

    @Override
    public void beeping() {
        System.out.println("Beep");
    }
}