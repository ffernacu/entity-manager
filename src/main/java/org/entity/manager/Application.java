package org.entity.manager;

import lombok.extern.slf4j.Slf4j;
import org.entity.manager.infrastructure.port.PersistentCategoryPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@SpringBootApplication
public class Application implements CommandLineRunner {

    private final PersistentCategoryPort persistentCategoryPort;

    public Application(PersistentCategoryPort persistentCategoryPort) {
        this.persistentCategoryPort = persistentCategoryPort;
    }

    public static void main(String[] args) {

        System.out.println("Hello world test!");
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var result = persistentCategoryPort.finCategoryInfo(1);
        log.info("{}",result);
    }
}