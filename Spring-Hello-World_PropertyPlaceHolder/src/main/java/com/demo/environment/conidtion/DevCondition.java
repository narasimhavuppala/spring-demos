/**
 * 
 */
package com.demo.environment.conidtion;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Shree
 *
 */
public class DevCondition implements Condition {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.annotation.Condition#matches(org.
	 * springframework.context.annotation.ConditionContext,
	 * org.springframework.core.type.AnnotatedTypeMetadata)
	 */
	@Override
	public boolean matches(ConditionContext arg0, AnnotatedTypeMetadata arg1) {
		String env=arg0.getEnvironment().getProperty("env");
		System.out.println("env=" + env);
		if("dev".equalsIgnoreCase(env)) 
			return true;
		else
			return false;
		
	}

}
