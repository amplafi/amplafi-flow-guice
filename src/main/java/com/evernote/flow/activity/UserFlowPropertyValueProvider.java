package com.evernote.flow.activity;

import org.amplafi.flow.FlowPropertyDefinition;
import org.amplafi.flow.flowproperty.AbstractFlowPropertyValueProvider;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilder;
import org.amplafi.flow.flowproperty.FlowPropertyDefinitionBuilderProvider;
import org.amplafi.flow.flowproperty.FlowPropertyProviderWithValues;

import com.amplafi.flow.guice.FactoryFlowPropertyDefinitionBuilderProvider;
import com.evernote.edam.User;

/**
 * This ensures that User value is always provided from the session object never the flowState.
 *
 * @author patmoore
 * @see CreateUserFlowPropertyValueProvider
 */
@FactoryFlowPropertyDefinitionBuilderProvider(propertyName=UserFlowPropertyValueProvider.USER)
public class UserFlowPropertyValueProvider extends AbstractFlowPropertyValueProvider<FlowPropertyProviderWithValues> implements
                                                                                                                    FlowPropertyDefinitionBuilderProvider {

    public static final String USER = "user";
    public static final UserFlowPropertyValueProvider INSTANCE = new UserFlowPropertyValueProvider();

    public UserFlowPropertyValueProvider() {
        super(new FlowPropertyDefinitionBuilder(USER, User.class).internalOnly());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(FlowPropertyProviderWithValues flowPropertyProvider, FlowPropertyDefinition flowPropertyDefinition) {
        if (flowPropertyDefinition.isNamed(USER)) {
            User user = null;
//            PersistedRegisterableCallback persistedRegisterableCallback = getSafe(flowPropertyProvider, flowPropertyDefinition, CALLBACK);
//            if (persistedRegisterableCallback != null && persistedRegisterableCallback.isSecuredCallback()) {
//                user = persistedRegisterableCallback.getLogonUser();
//            }
            user = new User(1);
            return (T) user;
        } else {
            throw fail(flowPropertyDefinition);
        }
    }
}

