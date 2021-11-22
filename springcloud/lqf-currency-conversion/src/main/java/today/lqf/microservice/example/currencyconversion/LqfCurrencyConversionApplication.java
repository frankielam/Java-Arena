package today.lqf.microservice.example.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("today.lqf.microservice.example.currencyconversion")
@EnableDiscoveryClient
public class LqfCurrencyConversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(LqfCurrencyConversionApplication.class, args);
    }
}