package task07;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Birthright on 23.03.2016.
 */
@Configuration
@ComponentScan(basePackages = {"task07"})
public class Config {
    @Bean()
    public Engine newEngine() {
        return new SomeEngine(500, 700, true);
    }

    @Bean
    @Qualifier(value = "engine")
    public Engine createEngine() {
        return new SomeEngine(343, 360, false);
    }
}
