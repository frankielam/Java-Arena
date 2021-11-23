package today.lqf.microservice.example.forex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LqfForexServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LqfForexServiceApplication.class, args);
    }

}
