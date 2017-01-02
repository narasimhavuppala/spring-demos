/**
 * 
 */
package com.demo.environment.conidtion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Shree
 *
 */
@Configuration
//@Profile("dev")
//@PropertySource("app."+"#{systemEnvironment['env']}"+".properties")
@ComponentScan(basePackages = { "com.demo.environment.condition" })

public class Application {

	@Bean(name = "ds")
	@Conditional(DevCondition.class)
	public DataSource getDevDataSource() {
		return new DevDataSource();

	}

	@Bean(name = "ds")	
	@Conditional(ProdCondition.class)
	public DataSource getProdDataSource() {
		return new ProdDataSource();

	}

}
