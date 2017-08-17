package com.evernote.flow.guice.providers;

import org.amplafi.flow.FlowPropertyDefinition;
import org.amplafi.flow.FlowPropertyExpectation;
import org.amplafi.flow.flowproperty.FlowPropertyProviderWithValues;
import org.amplafi.flow.flowproperty.FlowPropertyValuePersister;

import com.evernote.edam.Business;
import com.evernote.persistant.FakeDatabase;

public class BusinessFlowPropertyValuePersister implements FlowPropertyValuePersister<FlowPropertyProviderWithValues> {

    public BusinessFlowPropertyValuePersister() {
    }

    @Override
    public Business saveChanges(FlowPropertyProviderWithValues flowPropertyProvider, FlowPropertyDefinition flowPropertyDefinition) {
        Business business = flowPropertyProvider.getProperty("business");
        FakeDatabase.INSTANCE.put(business.id, business);
        return business;
    }

    @Override
    public boolean isPersisting(FlowPropertyExpectation flowPropertyExpectation) {
        return true;
    }

}
