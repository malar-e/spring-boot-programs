package car;


import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class Bus implements ApplicationRunner {
    Engine engine;

    public Bus(Engine engine) {
        this.engine = engine;
    }

    public void run(ApplicationArguments args) {
        try {
            if (engine == null) {
                throw new IllegalStateException("Engine is not initialized!");
            }

            System.out.println("Bus is running with engine: " + engine);
            System.out.println("Engine type: " + engine.type());
            System.out.println("Engine horsepower: " + engine.horsepower());

        } catch (Exception e) {
            System.err.println("Error while starting the bus: " + e.getMessage());
            e.printStackTrace();
        }
    }

}