package com.ant.context.config;

import com.ant.context.imports.MyImportSelector;
import com.ant.context.service.CityService;
import com.ant.context.service.UserService;
import org.springframework.context.annotation.*;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: AppConfig
 * @Description: TODO
 * @datetime 2018/11/8 19:51
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.ant.context")
//@Import(MyImportSelector.class)
//@ImportResource("classpath:spring.xml")
//@AntEnable
public class AppConfig {

}
