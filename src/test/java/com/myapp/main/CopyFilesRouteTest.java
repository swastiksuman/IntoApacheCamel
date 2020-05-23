package com.myapp.main;

import com.myapp.Main.CopyFilesRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CopyFilesRouteTest extends CamelTestSupport {
    protected RouteBuilder createRouteBuilder(){
        return new CopyFilesRoute();
    }

    @Test
    public void checkFileExistsInOutputDirectory() throws InterruptedException {
        Thread.sleep(5000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());

    }
}
