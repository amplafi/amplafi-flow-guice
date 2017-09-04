package com.amplafi.flow.guice;

import org.amplafi.flow.flowproperty.FactoryFlowPropertyDefinitionBuilderProvider;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilderProvider;

import com.google.inject.AbstractModule;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.multibindings.Multibinder;

public abstract class FactoryFlowPropertyDefinitionBuilderProviderModule extends AbstractModule {

    private Multibinder<FlowPropertyDefinitionBuilderProvider> flowPropertyDefinitionBuilderProviderBinder;

    @Override protected void configure() {
        flowPropertyDefinitionBuilderProviderBinder = Multibinder.newSetBinder(binder(),
            FlowPropertyDefinitionBuilderProvider.class,
            FactoryFlowPropertyDefinitionBuilderProvider.class);
      configureActions();
    }

    /**
     * Override this method to call {@link #bindAction}.
     */
    protected abstract void configureActions();

    protected final LinkedBindingBuilder<FlowPropertyDefinitionBuilderProvider> bindFlowPropertyDefinitionBuilderProvider() {
      return flowPropertyDefinitionBuilderProviderBinder.addBinding();
    }
}
