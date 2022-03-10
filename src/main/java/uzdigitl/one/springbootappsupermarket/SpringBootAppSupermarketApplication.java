package uzdigitl.one.springbootappsupermarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootAppSupermarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppSupermarketApplication.class, args);
    }

}
