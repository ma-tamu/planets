package jp.co.project.planets.mars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mars application
 */
@SpringBootApplication(scanBasePackages = "jp.co.project.planets")
public class MarsApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MarsApplication.class, args);
    }
}
