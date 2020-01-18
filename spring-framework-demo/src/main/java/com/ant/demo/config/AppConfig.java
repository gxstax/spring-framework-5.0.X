package com.ant.demo.config;

import com.ant.demo.conditional.AntConditional;
import com.ant.demo.service.AntService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-11-14 14:34
 */
@Configuration
@ComponentScan("com.ant.demo")
@Conditional(value = AntConditional.class)
public class AppConfig {

	@Bean
	public AntService antService() {
		return new AntService();
	}
}
