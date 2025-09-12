import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloLog4jLookup {
    private static final Logger logger = LogManager.getLogger(HelloLog4jLookup.class);

    public static void main(String[] args) {
        // Unsafe-looking string but safe if you keep it in a test environment and don't have an LDAP server.
        // Debricked will see the lookup pattern as exercising the lookup code path.
        logger.error("Trigger lookup machinery: ${jndi:ldap://127.0.0.1:1389/a}");
        System.out.println("Logged lookup string (check logs).");
    }
}
