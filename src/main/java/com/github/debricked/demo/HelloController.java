import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LogManager.getLogger("HelloWorld");

    @GetMapping("/")
    public String index(@RequestHeader(value = "X-Api-Version", required = false) String apiVersion) {
        if (apiVersion == null) {
            logger.warn("Received a request with no API version header");
        } else {
            logger.info("Received a request for API version " + apiVersion);
        }
        return "Hello, world!";
    }
}
