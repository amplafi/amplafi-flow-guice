package com.evernote.flow.guice;

import org.amplafi.flow.FlowDefinitionsManager;
import org.amplafi.flow.impl.FlowDefinitionsManagerImpl;

import com.amplafi.flow.guice.FlowGuiceModule;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class EvernoteGuiceFlowModule extends AbstractModule {

    public EvernoteGuiceFlowModule() {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void configure() {
        install(new FlowGuiceModule());
        FlowDefinitionsManager flowDefinitionsManager =
    }

    @Provides
    public FlowDefinitionsManager createFlowDefinitionsManager() {
        return new FlowDefinitionsManagerImpl();
    }

}
