/**
 * 
 */
package com.demo.model.autowire;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * @author Shree
 *
 */
@Component
public class MyEventLisnters implements ApplicationListener<ContextStartedEvent> {

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextStartedEvent arg0) {

		System.out.println("Started = " + arg0);
	}
	
	
}
