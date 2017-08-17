package com.evernote.flow.guice.providers;

import org.amplafi.flow.FlowPropertyDefinition;
import org.amplafi.flow.flowproperty.AbstractFlowPropertyValueProvider;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilder;
import org.amplafi.flow.flowproperty.FlowPropertyProvider;

/**
 * read operation.
 * @author patmoore
 *
 */
public class BusinessFlowPropertyValueProvider extends AbstractFlowPropertyValueProvider {


    public BusinessFlowPropertyValueProvider() {
        super(new FlowPropertyDefinitionBuilder("business"));
    }

    /**
     * @param flowPropertyProvider - provides the current data needed to construct the returned object ( i.e
     * @see org.amplafi.flow.FlowPropertyValueProvider#get(org.amplafi.flow.flowproperty.FlowPropertyProvider, org.amplafi.flow.FlowPropertyDefinition)
     */
    public Object get(FlowPropertyProvider flowPropertyProvider, FlowPropertyDefinition flowPropertyDefinition) {
        return null;
    }

}
