package com.evernote.flow.guice;

import org.amplafi.flow.FlowDefinitionsManager;
import com.amplafi.flow.guice.FlowGuiceModule;
import com.evernote.flow.guice.providers.BusinessFlowPropertyDefinitionBuilderProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class EvernoteGuiceFlowModule extends AbstractModule {

    public EvernoteGuiceFlowModule() {
    }

    @Override
    protected void configure() {
        FlowGuiceModule flowGuiceModule = new FlowGuiceModule();
        install(flowGuiceModule);
        Injector injector = Guice.createInjector(flowGuiceModule);
        FlowDefinitionsManager flowDefinitionsManager = injector.getInstance(FlowDefinitionsManager.class);
        flowDefinitionsManager.addFactoryFlowPropertyDefinitionBuilderProvider(new BusinessFlowPropertyDefinitionBuilderProvider());
    }

//    @Provides
//    public FlowDefinitionsManager createFlowDefinitionsManager() {
//        return new FlowDefinitionsManagerImpl();
//    }

}
