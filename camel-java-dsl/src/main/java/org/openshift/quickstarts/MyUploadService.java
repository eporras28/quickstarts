package org.openshift.quickstarts;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by rromerom on 07/02/17.
 */
public class MyUploadService implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Endpoint ftpEndpoint = exchange.getContext().getEndpoint("ftp://vagrant@oracle-xe/tmp?password=vagrant");
        Exchange exchange1 = ftpEndpoint.createExchange();
        exchange1.getIn().setBody(exchange.getIn().getBody());
        ftpEndpoint.createProducer().process(exchange1);
    }
}
