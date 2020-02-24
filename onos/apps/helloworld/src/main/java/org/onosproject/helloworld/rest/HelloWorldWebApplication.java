package org.onosproject.helloworld.rest;

import org.onlab.rest.AbstractWebApplication;

import java.util.Set;

public class HelloWorldWebApplication extends AbstractWebApplication {

    @Override
    public Set<Class<?>> getClasses() {
        return getClasses(HelloWorldResource.class);
    }
}
