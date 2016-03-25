package task07;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Peter on 08.02.2016.
 */
@Component
@Qualifier("wheel")
public class SomeWheel implements SteeringWheel {
    @Value("19")
    int radius;
    @Value(value = "true")
    boolean leather;

    public SomeWheel(int radius, boolean leather, boolean threeSpokes) {
        this.radius = radius;
        this.leather = leather;
        this.threeSpokes = threeSpokes;
    }

    public SomeWheel() {
    }

    @Value("true")
    boolean threeSpokes;

    @Override
    public void turnRight(boolean turnSignal) {
        if (turnSignal) {
            System.out.println("Turn right with signal");
        } else {
            System.out.println("turn right");
        }
    }

    @Override
    public void turnLeft(boolean turnSignal) {
        if (turnSignal) {
            System.out.println("Turn left with signal");
        } else {
            System.out.println("turn left");
        }
    }

    @Override
    public void beeping() {
        System.out.println("Beep");
    }
}