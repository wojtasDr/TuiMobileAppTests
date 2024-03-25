package tuimobileapptests.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource("application.properties")
@ComponentScan ("tuimobileapptests")
public class Config {
}
