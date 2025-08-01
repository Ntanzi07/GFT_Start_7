package one.digitalInnovation.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApplicationJava {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationJava.class,args);
    }
}
