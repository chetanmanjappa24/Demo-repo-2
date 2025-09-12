import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.core.lookup.Interpolator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Log4jReachabilityController {

    // Dummy implementation to satisfy StrLookup
    static class DummyLookup implements StrLookup {
        @Override
        public String lookup(String key) {
            return "value";
        }

        @Override
        public String lookup(org.apache.logging.log4j.core.LogEvent event, String key) {
            return "value";
        }
    }

    @GetMapping("/test-log4j")
    public String testLog4j() {
        StrLookup lookup = new DummyLookup();
        List<String> list = new ArrayList<>();

        // Call the vulnerable constructor
        Interpolator interpolator = new Interpolator(lookup, list);

        return "Interpolator created: " + interpolator.toString();
    }
}
