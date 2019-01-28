package com.ant.context.config;

import com.ant.context.beanfactoryfostprocessor.MyBeanFactoryPostProcessor;
import com.ant.context.dao.IndexDao3;
import com.ant.context.imports.MyImportSelector;
import com.ant.context.service.CityService;
import com.ant.context.service.UserService;
import org.springframework.context.annotation.*;
//import org.springframework.web.context.WebApplicationContext;

/**
 * @author Ant
 * @ClassName: AppConfig
 * @Description: TODO
 * @datetime 2018/11/8 19:51
 * @Version 1.0
 */
@Configuration(value = "appConfig")
@ComponentScan("com.ant.context")
//@Import(MyImportSelector.class)
//@ImportResource("classpath:spring.xml")
//@AntEnable
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Import(IndexDao3.class)
public class AppConfig {

}
