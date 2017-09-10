package com.evernote.flow.guice.providers;

import javax.inject.Inject;

import org.amplafi.flow.flowproperty.BaseFlowPropertyDefinitionBuilderProvider;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilder;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilderProvider;

import com.amplafi.flow.guice.FactoryFlowPropertyDefinitionBuilderProvider;
import com.evernote.edam.Business;
import com.google.inject.Provides;;

@FactoryFlowPropertyDefinitionBuilderProvider(propertyName=BusinessFlowPropertyDefinitionBuilderProvider.PROPERTY_NAME)
public class BusinessFlowPropertyDefinitionBuilderProvider extends BaseFlowPropertyDefinitionBuilderProvider
                                                           implements FlowPropertyDefinitionBuilderProvider {

    public static final String PROPERTY_NAME = "business";
    public static class Factory {
        @Inject
        @Provides
        public BusinessFlowPropertyDefinitionBuilderProvider create() {
            FlowPropertyDefinitionBuilder flowPropertyDefinitionBuilder = new FlowPropertyDefinitionBuilder(PROPERTY_NAME, Business.class);
            BusinessFlowPropertyValuePersister businessFlowPropertyValuePersister =
                    new BusinessFlowPropertyValuePersister(flowPropertyDefinitionBuilder);
            BusinessFlowPropertyValueProvider flowPropertyValueProvider = new BusinessFlowPropertyValueProvider(flowPropertyDefinitionBuilder);
            flowPropertyDefinitionBuilder.initFlowPropertyValuePersister(businessFlowPropertyValuePersister)
                .initFlowPropertyValueProvider(flowPropertyValueProvider);
            return new BusinessFlowPropertyDefinitionBuilderProvider(flowPropertyDefinitionBuilder);
        }
    }

    public BusinessFlowPropertyDefinitionBuilderProvider(FlowPropertyDefinitionBuilder flowPropertyDefinitionBuilder) {
        super(flowPropertyDefinitionBuilder);
    }
}
