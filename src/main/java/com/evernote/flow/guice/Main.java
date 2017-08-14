package com.evernote.flow.guice;

import org.amplafi.flow.FlowManager;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public Main() {

    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            protected void configure() {
                install(new EvernoteGuiceFlowModule());
            }
        });
        FlowManager flowManager = injector.getInstance(FlowManager.class);

        flowManager.isFlowDefined("test");
    }

}
