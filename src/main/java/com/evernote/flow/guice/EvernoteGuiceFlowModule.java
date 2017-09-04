package com.evernote.flow.guice;

import java.util.Map;

import org.amplafi.flow.FlowDefinitionsManager;
import org.amplafi.flow.definitions.DefinitionSource;
import org.amplafi.flow.definitions.FlowDefinition;
import org.amplafi.flow.impl.FlowDefinitionsManagerImpl;

import com.amplafi.flow.guice.FlowGuiceModule;
import com.evernote.flow.guice.providers.BusinessFlowPropertyDefinitionBuilderProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

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

        return flowDefinitionsManager;
    }

    @Provides
    DefinitionSource<FlowDefinition> createDefinitionSource() {
        DefinitionSource<FlowDefinition> definitionSource = new DefinitionSource<FlowDefinition>() {

            @Override
            public boolean isFlowDefined(String flowTypeName) {
                return false;
            }

            @Override
            public Map<String, FlowDefinition> getFlowDefinitions() {
                return null;
            }

            @Override
            public FlowDefinition getFlowDefinition(String flowTypeName) {
                return null;
            }
        };
    }
}
