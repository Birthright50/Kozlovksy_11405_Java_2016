package task07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Peter on 08.02.2016.
 */
public class Main {
    public static void main(String[] args) {
       ApplicationContext ac =
                new AnnotationConfigApplicationContext(Config.class);

        Car m3E46 = ac.getBean(BMWM3E46.class);
        m3E46.getWheel().beeping();
        m3E46.getWheel().turnLeft(true);
        m3E46.getWheel().turnRight(true);
        m3E46.swapEngine(ac.getBean("createEngine", Engine.class));
        m3E46.getTransmission().downshift((byte) 50);


    }
}
