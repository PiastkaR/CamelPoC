package com.camel.poc.configuration;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.io.FileInputStream;
import java.io.InputStream;

public class TransformFileDSL {
    public void transformFile() throws Exception {
        CamelContext context = new DefaultCamelContext();
        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:src\\main\\resources\\input\\")
                            .to("file:src\\main\\resources\\output\\");
                    // .to("file:src/main/resources/order/");
                }
            });
            context.start();
            ProducerTemplate jsonTemplate = context.createProducerTemplate();
            InputStream jsonInputStream = new FileInputStream(ClassLoader.getSystemClassLoader()
                    .getResource("input.json").getFile());
            jsonTemplate.sendBody("file:/input", jsonInputStream);
        } finally {
            context.stop();
        }
    }
}
