package org.onosproject.helloworld.impl;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.Service;
import org.onlab.util.SharedScheduledExecutorService;
import org.onlab.util.SharedScheduledExecutors;
import org.onosproject.core.ApplicationId;
import org.onosproject.core.CoreService;
import org.onosproject.net.helloworld.HelloWorldService;
import org.slf4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static org.slf4j.LoggerFactory.getLogger;

@Component(immediate = true)
@Service
public class HelloWorld implements HelloWorldService {

    private final Logger log = getLogger(getClass());

    private final SharedScheduledExecutorService helloworldExecutor =
            SharedScheduledExecutors.getPoolThreadExecutor();

    private ApplicationId appId;

    private ScheduledFuture<?> scheduledTask;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected CoreService coreService;

    private static final int DEFAULT_POLL_FREQUENCY_SECONDS = 30;

    @Activate
    public void activate() {
        appId = coreService.registerApplication("org.onosproject.helloworld");
        log.info("Registered as {}", appId);
        scheduledTask = schedulePolling();
        log.info("Started Successfully");
    }

    @Deactivate
    public void deactivate() {
        log.info("Start deactive {}", appId);
        scheduledTask.cancel(true);
        log.info("Stopped Successfully");
    }

    @Override
    public void sayHello(String name) {
        log.info("I am Hello World Service name = {}", name);
    }

    private void getHelloWorld() {
        log.info("This is a schedulePolling at time {}",
                 new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(new Date()));
    }

    private ScheduledFuture schedulePolling() {
        return helloworldExecutor.scheduleAtFixedRate(this::getHelloWorld,
                                                      DEFAULT_POLL_FREQUENCY_SECONDS / 2,
                                                      DEFAULT_POLL_FREQUENCY_SECONDS,
                                                      TimeUnit.SECONDS);
    }

}
