package jp.co.project.planets.earthly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "jp.co.project.planets")
public class EarthlyApplication {

    public static void main(final String[] args) {
        SpringApplication.run(EarthlyApplication.class, args);
    }
}
