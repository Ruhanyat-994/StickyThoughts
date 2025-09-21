package com.apress.myretro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;

@EnableConfigurationProperties({MyRetroProperties.class})
@Configuration
public class MyRetroConfiguration {
    Logger log = LoggerFactory.getLogger(MyretroApplication.class);


    @Bean
    ApplicationListener<ApplicationReadyEvent> init( MyRetroProperties myRetroProperties){
        return event -> {
            log.info("\nThe users service properties are:\n- Server: {}\n- Port" +
                    ": {}\n- Username: {}\n- Password: {}",
                    myRetroProperties.getUsers().getServer(),
                    myRetroProperties.getUsers().getPort(),
                    myRetroProperties.getUsers().getUsername(),
                    myRetroProperties.getUsers().getPassword()
            );
        };


    }



}
