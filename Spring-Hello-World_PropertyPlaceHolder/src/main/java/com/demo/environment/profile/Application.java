/**
 * 
 */
package com.demo.environment.profile;

import java.util.Enumeration;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Shree
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.demo.environment.profile" })
//@Profile("dev")
//@PropertySource("app.dev.properties")

public class Application {

	@Bean
	public PropertySourcesPlaceholderConfigurer getPropertiesFile() {

		String activeProfile = System.getProperty("spring.profiles.active");
		if(activeProfile==null){
			activeProfile="default";
		}
		String propertiesFilename = "app." + activeProfile + ".properties";
		System.out.println(propertiesFilename);
		
		/*Properties prop=new Properties();
		prop.load(inStream);
		Enumeration e=prop.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}*/

		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setLocation(new ClassPathResource(propertiesFilename));

		return configurer;
	}

	/*@Bean(name = "ds")

	public DataSource getDataSource() {
		return new DataSource();

	}*/

	
}
