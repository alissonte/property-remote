package com.propremote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.propremote.model.Property;

@SpringBootApplication
public class PropRemoteApplication extends SpringBootServletInitializer{

	Property pr = new Property();

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PropRemoteApplication.class, args);
    }
}
