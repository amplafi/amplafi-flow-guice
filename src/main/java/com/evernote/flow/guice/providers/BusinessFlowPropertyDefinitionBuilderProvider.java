package com.evernote.flow.guice.providers;

import org.amplafi.flow.flowproperty.BaseFlowPropertyDefinitionBuilderProvider;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilder;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilderProvider;

import com.evernote.edam.Business;;

@Inject
public class BusinessFlowPropertyDefinitionBuilderProvider extends BaseFlowPropertyDefinitionBuilderProvider
                                                           implements FlowPropertyDefinitionBuilderProvider {

    public static class Factory {
        public BusinessFlowPropertyDefinitionBuilderProvider create() {
            FlowPropertyDefinitionBuilder flowPropertyDefinitionBuilder = new FlowPropertyDefinitionBuilder("business", Business.class);
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
