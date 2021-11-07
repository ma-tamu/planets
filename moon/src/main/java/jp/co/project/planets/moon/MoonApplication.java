package jp.co.project.planets.moon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * moon application
 */
@SpringBootApplication(scanBasePackages = "jp.co.project.planets.pleiades")
public class MoonApplication {

    /**
     * main
     *
     * @param args
     *         起動引数
     */
    public static void main(final String[] args) {
        SpringApplication.run(MoonApplication.class, args);
    }
}
