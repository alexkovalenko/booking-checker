package org.alexkov.bookingchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(BookingConfig.class)
@EnableScheduling
public class BookingCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingCheckerApplication.class, args);
    }
}
