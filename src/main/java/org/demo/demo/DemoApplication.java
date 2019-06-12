package org.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@RequestMapping("/a")
public class DemoApplication extends SpringBootServletInitializer {
    @Autowired
    CLibrary cLibrary;

    public static void main(String[] args) {
        System.out.println("classpath:" + System.getProperty("java.class.path"));
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/b")
    @ResponseBody
    public String hello() {
      //  System.out.println("vist...");
        cLibrary.printf("Hello, World\n");
        return "hello";
    }
    @RequestMapping("/c")
    @ResponseBody
    public String min() {
        System.out.println("vist again...");
        cLibrary.printf("Hello, World\n");
        return "hello";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }

}
