package org.openshift.quickstarts;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jetty.JettyHttpComponent;
import org.apache.camel.impl.converter.AsyncProcessorTypeConverter;

/**
 * A Camel Java8 DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

//        JettyHttpComponent jetty = (JettyHttpComponent) getContext().getComponent("jetty");
//        jetty.addSocketConnectorProperty("maxIdleTime", 300000);
//
//        errorHandler(defaultErrorHandler()
//                .maximumRedeliveries(3)
//                .retryAttemptedLogLevel(LoggingLevel.WARN)
//                .backOffMultiplier(2)
//                .useExponentialBackOff());

        // here is a sample which set a random body then performs content
        // based routing on the message using method references

//        onException(Exception.class)
//                .log("Error received");

        from("jetty:http://0.0.0.0:8080/demo?continuationTimeout=1000")
            .log("Pushing to FTP")
        .to("seda:myFTP")
//                .wireTap("seda:myFTP")
        .log("End of main route")
        .to("mock:result");

        from("seda:myFTP")
                .to("ftp://vagrant@oracle-xe/tmp?password=vagrant")
//                .process(new MyUploadService())
                .delay(5000)
                .asyncDelayed()
                .log("pushed to FTP");
        from("direct:a")
                .log("I'm so slow...")
                .delay(5000)
                .asyncDelayed()
                .log("I finished my slow processing.");
    }

}
