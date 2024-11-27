package com.fedpat.msgraphapidemo;

import com.fedpat.msgraphapidemo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsGraphApiDemoApplication implements CommandLineRunner {

    @Autowired
    MessageService messageService;

    public static void main(String[] args) {
        SpringApplication.run(MsGraphApiDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Resultado: " + messageService.getListMessages().size());
    }
}
