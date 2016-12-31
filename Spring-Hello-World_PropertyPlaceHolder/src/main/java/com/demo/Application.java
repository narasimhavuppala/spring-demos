/**
 * 
 */
package com.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Shree
 *
 */
@Configuration
@PropertySource("app.properties")
@ComponentScan(basePackages={"com.demo"})
public class Application {

}
