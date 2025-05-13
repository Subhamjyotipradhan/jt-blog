
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class car {
    private Engine engine;

    // // setter based injection
    // @Autowired
    // public void setEngine(Engine engine){
    //     System.out.println("Setter method called - di");.
    //     this.engine = engine;
    // }
   //constracter based injection
    public car(Engine engine){
        System.out.println("constracter maethiod called - di");
        this.engine = engine;

    }

    public void runCar(){
        engine.startEngine();
        System.out.println("car is running");
    }

}
