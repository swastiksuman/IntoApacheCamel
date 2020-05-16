package com.myapp.Main;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamel {

    public static void main(String[] args){
        System.out.println("X");
        CamelContext context = new DefaultCamelContext();
        try{
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
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
