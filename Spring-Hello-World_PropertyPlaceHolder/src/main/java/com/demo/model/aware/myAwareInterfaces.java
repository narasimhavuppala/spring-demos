/**
 * 
 */
package com.demo.model.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Shree
 *
 */
@Component("myaware")
public class myAwareInterfaces implements ApplicationContextAware, EnvironmentAware, BeanFactoryAware, Aware {

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
	 */
	public void setBeanFactory(BeanFactory paramBeanFactory) throws BeansException {
		 System.out.println("Bean factory Aware");

	}

	/* (non-Javadoc)
	 * @see org.springframework.context.EnvironmentAware#setEnvironment(org.springframework.core.env.Environment)
	 */
	public void setEnvironment(Environment arg0) {
		System.out.println("Environment aware");

	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("Application Context Aware");

	}

}
