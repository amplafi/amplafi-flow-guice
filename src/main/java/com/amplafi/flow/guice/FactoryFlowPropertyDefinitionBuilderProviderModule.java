package com.amplafi.flow.guice;

import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilderProvider;

import com.google.inject.AbstractModule;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.multibindings.Multibinder;

/**
 * https://stackoverflow.com/questions/4410712/injecting-collection-of-classes-with-guice
 * USE :
 * public final class MyStandardFactoryFlowPropertyDefinitionBuilderProviderModule extends FactoryFlowPropertyDefinitionBuilderProviderModule() {
  @Override protected void configureFactoryFlowPropertyDefinitionBuilderProviders() {
    bindFlowPropertyDefinitionBuilderProvider().to(FooFactoryFlowPropertyDefinitionBuilderProvider.class);
    bindFlowPropertyDefinitionBuilderProvider().to(BarFactoryFlowPropertyDefinitionBuilderProvider.class);
    // If you need to instantiate an action through a Provider, do this.
    bindFlowPropertyDefinitionBuilderProvider().toProvider(BazFactoryFlowPropertyDefinitionBuilderProviderProvider.class);
    // You can also scope stuff:
    bindFlowPropertyDefinitionBuilderProvider().to(MySingletonFactoryFlowPropertyDefinitionBuilderProvider.class).in(Singleton.class);
  }

  then @Inject the Set<FactoryFlowPropertyDefinitionBuilderProvider>
}
 * @author patmoore
 *
 */
public abstract class FactoryFlowPropertyDefinitionBuilderProviderModule extends AbstractModule {

    private Multibinder<FlowPropertyDefinitionBuilderProvider> flowPropertyDefinitionBuilderProviderBinder;

    @Override protected void configure() {
        flowPropertyDefinitionBuilderProviderBinder = Multibinder.newSetBinder(binder(),
            FlowPropertyDefinitionBuilderProvider.class,
            // do i want the filter on annotation?
            FactoryFlowPropertyDefinitionBuilderProvider.class);
      configureFactoryFlowPropertyDefinitionBuilderProviders();
    }

    /**
     * Override this method to call {@link #bindFactoryFlowPropertyDefinitionBuilderProvider}.
     */
    protected abstract void configureFactoryFlowPropertyDefinitionBuilderProviders();

    protected final LinkedBindingBuilder<FlowPropertyDefinitionBuilderProvider> bindFlowPropertyDefinitionBuilderProvider() {
      return flowPropertyDefinitionBuilderProviderBinder.addBinding();
    }
}
