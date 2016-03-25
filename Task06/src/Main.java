import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Peter on 08.02.2016.
 */
public class Main {
    public static void main(String[] args) {
       ApplicationContext ac =
                new ClassPathXmlApplicationContext("spring-cfg.xml");

        Car m3E46 = (Car) ac.getBean("e46");
        m3E46.getWheel().beeping();
        m3E46.getWheel().turnLeft(true);
        m3E46.getWheel().turnRight(true);
        m3E46.swapEngine((Engine) ac.getBean("new_engine"));
        m3E46.getTransmission().downshift((byte) 50);


    }
}
