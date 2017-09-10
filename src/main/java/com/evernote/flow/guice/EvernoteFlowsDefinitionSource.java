package com.evernote.flow.guice;

import java.util.HashMap;
import java.util.Map;

import org.amplafi.flow.FlowActivityImplementor;
import org.amplafi.flow.FlowImplementor;
import org.amplafi.flow.definitions.DefinitionSource;
import org.amplafi.flow.impl.FlowActivityImpl;
import org.amplafi.flow.impl.FlowImpl;

public class EvernoteFlowsDefinitionSource implements DefinitionSource<FlowImplementor> {

    public static final String WRITEABLE = "writeable";
    private Map<String, FlowImplementor> flowDefinitions = new HashMap<>();
    public EvernoteFlowsDefinitionSource() {
        FlowImpl writeable = new FlowImpl(WRITEABLE);
        FlowActivityImplementor flowActivity = new FlowActivityImpl();

        writeable.addActivity(flowActivity);
        flowDefinitions.put(writeable.getFlowPropertyProviderFullName(), writeable);
    }

    @Override
    public Map<String, FlowImplementor> getFlowDefinitions() {
        return flowDefinitions;
    }

}
