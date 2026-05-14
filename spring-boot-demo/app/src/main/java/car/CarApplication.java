package car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ApplicationRunner;

record Engine(String type, int horsepower) {}

@SpringBootApplication
@ComponentScan("example")  
public class CarApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CarApplication.class, args);
        Engine engine = context.getBean(Engine.class);
        System.out.println("Engine type: " + engine.type());
        System.out.println("Engine horsepower: " + engine.horsepower());

    }

    @Bean
    public Engine engine() {
        return new Engine("V8", 450);
    }

    @Bean
    public CommandLineRunner commandLineRunner(Engine engine) {
        return args -> {
            System.out.println("Running with engine: " + engine);
        };
    }

    @Bean
    public ApplicationRunner applicationRunner(Engine engine) {
        return args -> {
            System.out.println("Running with engine: " + engine);
        };
    }

}
