/**
 * 
 */
package com.demo.model.events;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/**
 * @author Shree
 *
 */
@Configuration
@ComponentScan(basePackages={"com.demo.model.events"})
@PropertySource("app.properties")
public class AppConfig {
	
//	@Bean
//	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//	public Address getAddress(){
//		
//		Address obj=new Address();
//		return obj;
//	}

}
