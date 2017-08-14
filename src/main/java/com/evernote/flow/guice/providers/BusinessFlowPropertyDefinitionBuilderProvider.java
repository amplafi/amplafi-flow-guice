package com.evernote.flow.guice.providers;

import org.amplafi.flow.flowproperty.BaseFlowPropertyDefinitionBuilderProvider;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilder;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilderProvider;

import com.evernote.edam.Business;;

public class BusinessFlowPropertyDefinitionBuilderProvider extends BaseFlowPropertyDefinitionBuilderProvider implements FlowPropertyDefinitionBuilderProvider {

    public static final BusinessFlowPropertyDefinitionBuilderProvider INSTANCE = new BusinessFlowPropertyDefinitionBuilderProvider();

    public BusinessFlowPropertyDefinitionBuilderProvider() {
        this("business");
    }
    @SuppressWarnings("unchecked")
    public BusinessFlowPropertyDefinitionBuilderProvider(String parameterName) {
        super(new FlowPropertyDefinitionBuilder(parameterName, Business.class)
            .initFlowPropertyValuePersister(new BusinessFlowPropertyValuePersister())
            .initFlowPropertyValueProvider(new BusinessFlowPropertyValueProvider()));
    }
}
