import Controller.Requests;
import org.apache.log4j.BasicConfigurator;

/**
 * Main class
 * @author andrey1pf
 * @version 1.1
 */
public class Main {
    /**
     * Method for starting program
     * @param args - args
     */
    public static void main(String args[]) {
        BasicConfigurator.configure();
        Requests req = new Requests();
        req.Start();
    }
}