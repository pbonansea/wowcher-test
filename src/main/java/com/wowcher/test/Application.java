package com.wowcher.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author pbonansea
 *
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {

    /**
     * @param args Application arguments
     */
    public static void main(final String[] args) {

        SpringApplication.run(Application.class, args);

    }

    /**
     * Return app name.
     * @return App name
     */
    public String getName() {
        return "wowcher-test";
    }

}
