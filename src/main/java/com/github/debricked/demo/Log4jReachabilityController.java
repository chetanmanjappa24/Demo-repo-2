import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.core.lookup.Interpolator;

public class Log4jReachabilityExample {

    public static void main(String[] args) {
        StrLookup lookup = new StrLookup() {
            public String lookup(String key) { return "value"; }
            public String lookup(org.apache.logging.log4j.core.LogEvent event, String key) { return "value"; }
        };

        // Directly call the vulnerable constructor
        Interpolator interpolator = new Interpolator(lookup, java.util.Collections.emptyList());

        System.out.println("Interpolator created");
    }
}
