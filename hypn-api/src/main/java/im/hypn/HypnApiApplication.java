package im.hypn;

import im.hypn.core.HypnCoreConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(HypnCoreConfiguration.class)
@SpringBootApplication
public class HypnApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HypnApiApplication.class, args);
    }
}
