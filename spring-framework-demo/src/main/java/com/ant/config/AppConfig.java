package com.ant.config;

import com.ant.anno.AntEnable;
import com.ant.beanfactoryfostprocessor.MyBeanFactoryPostProcessor;
import com.ant.beanpostporcessor.MyBeanPostPorcessor;
import com.ant.imports.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: AppConfig
 * @Description: TODO
 * @datetime 2018/11/8 19:51
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.ant")
@Import(MyImportSelector.class)
//@AntEnable
public class AppConfig {

}
