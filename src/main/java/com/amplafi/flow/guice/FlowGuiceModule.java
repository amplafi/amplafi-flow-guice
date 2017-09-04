package com.amplafi.flow.guice;

import org.amplafi.flow.FlowManager;
import org.amplafi.flow.FlowTranslatorResolver;
import org.amplafi.flow.flowproperty.FactoryFlowPropertyDefinitionBuilderProvider;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilderProvider;
import org.amplafi.flow.impl.FlowManagerImpl;
import org.amplafi.flow.translator.BaseFlowTranslatorResolver;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class FlowGuiceModule extends AbstractModule {

    public FlowGuiceModule() {
    }

    @Override
    protected void configure() {
        bind(FlowManager.class).to(FlowManagerImpl.class);
        bind(FlowTranslatorResolver.class).to(BaseFlowTranslatorResolver.class);

        Multibinder<FlowPropertyDefinitionBuilderProvider> actionBinder = Multibinder.newSetBinder(binder(),
            FlowPropertyDefinitionBuilderProvider.class, FactoryFlowPropertyDefinitionBuilderProvider.class);
    }


}
