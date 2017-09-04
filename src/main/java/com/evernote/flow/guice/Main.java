package com.evernote.flow.guice;

import org.amplafi.flow.FlowManager;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilder;

import com.evernote.persistant.PBusiness;
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

        FlowPropertyDefinitionBuilder flowPropertyDefinitionBuilder =
                flowManager.getFactoryFlowPropertyDefinitionBuilder("business", PBusiness.class);

        if (flowPropertyDefinitionBuilder != null) {
            System.out.println("found def");
        } else {
            System.out.println("wtf: found def");
        }
        if (flowManager.isFlowDefined("test")) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }

}
