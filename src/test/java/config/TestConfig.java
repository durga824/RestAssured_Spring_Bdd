package config;

/**
 * Author: Durga Rao
 * Initial Date: 06/13/2024
 * Description: Configuration class for Spring context.
 * This class is used to specify base packages for component scanning.
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "stepDefinitions")
public class TestConfig {

}
