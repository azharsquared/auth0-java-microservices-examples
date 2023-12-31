package com.example.busservice;

import com.example.busservice.data.Bus;
import com.example.busservice.data.BusRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@EnableDiscoveryClient // This annotation enables service registration and discovery.
@SpringBootApplication
public class BusServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusServiceApplication.class, args);
    }

    @Bean
    ApplicationRunner init(BusRepository repository) {
        repository.deleteAll();
        return args -> {
            Stream.of("Bus Ferrari", "Bus Jaguar", "Bus Porsche", "Bus Lamborghini", "Bus Bugatti",
                    "Bus AMC Gremlin", "Bus Triumph Stag", "Bus Ford Pinto", "Bus Yugo GV").forEach(name -> {
                repository.save(new Bus(name));
            });
            repository.findAll().forEach(System.out::println);
        };
    }

}
