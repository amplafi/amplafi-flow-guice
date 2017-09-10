package com.amplafi.flow.guice;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Mark a FlowPropertyDefinitionBuilderProvider as being generally available
 * to satisfy a property with the named request.
 * @author patmoore
 *
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD, ANNOTATION_TYPE })
// This annotation is used to pick a default FlowPropertyDefinitionBuilderProvider
@Qualifier
public @interface FactoryFlowPropertyDefinitionBuilderProvider {
    String propertyName();
}
