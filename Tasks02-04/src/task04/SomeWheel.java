package task04;

/**
 * Created by Peter on 08.02.2016.
 */
public class SomeWheel implements SteeringWheel {
   private int radius;
   private boolean leather;

    public SomeWheel(int radius, boolean leather, boolean threeSpokes) {
        this.radius = radius;
        this.leather = leather;
        this.threeSpokes = threeSpokes;
    }

    public String getCurrent_act() {
        return current_act;
    }

    public int getRadius() {
        return radius;
    }

    public boolean isLeather() {
        return leather;
    }

    public boolean isThreeSpokes() {
        return threeSpokes;
    }

    private String current_act;



    private boolean threeSpokes;


    @Override
    public void turnRight(boolean turnSignal) {
        if (turnSignal) {
            current_act = "Turn right with signal";

        } else {
            current_act = "Turn right";

        }
        System.out.println(current_act);
    }

    @Override
    public void turnLeft(boolean turnSignal) {
        if (turnSignal) {
            current_act = "Turn left with signal";
        } else {
            current_act = "Turn left";
        }
        System.out.println(current_act);
    }

    @Override
    public void beeping() {
        current_act = "Beep";
        System.out.println(current_act);
    }
}