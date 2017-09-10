package com.evernote.flow.activity;

import org.amplafi.flow.impl.FlowActivityImpl;

import com.evernote.flow.guice.providers.BusinessFlowPropertyDefinitionBuilderProvider;

public class ReadBusinessFlowActivityImpl extends FlowActivityImpl {

    public ReadBusinessFlowActivityImpl(String name) {
        super(name);
    }

    protected void addStandardFlowPropertyDefinitions() {
        super.addStandardFlowPropertyDefinitions();
        BusinessFlowPropertyDefinitionBuilderProvider businessFlowPropertyDefinitionBuilderProvider =
                (new BusinessFlowPropertyDefinitionBuilderProvider.Factory()).create();

        businessFlowPropertyDefinitionBuilderProvider
    }

}
