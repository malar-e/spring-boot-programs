package car;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Car implements CommandLineRunner {
    @Autowired
    Engine engine;

    public void run(String... args) {
        System.out.println("Car is running with engine: " + engine);
        System.out.println("Engine type: " + engine.type());
        System.out.println("Engine horsepower: " + engine.horsepower());
    }

}