package com.myapp.Main;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamelLogging {
    public static void main(String[] args){
        CamelContext context = new DefaultCamelContext();
        try{
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output");
                }
            });
            context.start();
            Thread.sleep(3000);
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
    }
}
