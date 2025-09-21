package com.apress.myretro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;


@SpringBootApplication
public class MyretroApplication {
    static Logger log = LoggerFactory.getLogger(MyretroApplication.class);

	public static void main(String[] args) {


        new SpringApplicationBuilder().
                sources(MyretroApplication.class)
                .logStartupInfo(false)
                .lazyInitialization(true)
//                .web(WebApplicationType.NONE)
                .profiles("cloud")
                .listeners(event -> log.info("Event: {}", event.getClass().
                        getCanonicalName()))
                .run(args);
	}

}
