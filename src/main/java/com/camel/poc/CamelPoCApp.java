package com.camel.poc;

import com.camel.poc.configuration.TransformFileDSL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class CamelPoCApp {
    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(CamelPoCApp.class, args);
        TransformFileDSL transformFileDSL = new TransformFileDSL();
        transformFileDSL.transformFile();
    }
}
