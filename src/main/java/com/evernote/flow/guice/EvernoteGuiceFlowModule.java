package com.evernote.flow.guice;

import org.amplafi.flow.FlowDefinitionsManager;
import org.amplafi.flow.impl.FlowDefinitionsManagerImpl;

import com.amplafi.flow.guice.FlowGuiceModule;
import com.evernote.flow.activity.UserFlowPropertyValueProvider;
import com.evernote.flow.guice.providers.BusinessFlowPropertyDefinitionBuilderProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * 1. Factory FPDBP -- we want to be auto injected
 * 2. Flow definitions - auto injected as well.
 * @author patmoore
 *
 */
public class EvernoteGuiceFlowModule extends AbstractModule {

    public EvernoteGuiceFlowModule() {
    }

    @Override
    protected void configure() {
        FlowGuiceModule flowGuiceModule = new FlowGuiceModule();
        install(flowGuiceModule);
    }

    @Provides
    FlowDefinitionsManager createFlowDefinitionsManager() {
        FlowDefinitionsManager flowDefinitionsManager = new FlowDefinitionsManagerImpl();
        flowDefinitionsManager.addFactoryFlowPropertyDefinitionBuilderProvider((new BusinessFlowPropertyDefinitionBuilderProvider.Factory()).create());
        flowDefinitionsManager.addFactoryFlowPropertyDefinitionBuilderProvider(UserFlowPropertyValueProvider.INSTANCE);
        flowDefinitionsManager.addDefinitions(new EvernoteFlowsDefinitionSource());
        return flowDefinitionsManager;
    }
}
