package com.mercedes.by.kunal.RESTdevelopment;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;



@SpringBootApplication
public class RestDevelopmentApplication {

	public static void main(String[] args) {
//        Set Timezone in next line to fix the timezone issue.
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Kolkata"));

        SpringApplication.run(RestDevelopmentApplication.class, args);

	}

}
