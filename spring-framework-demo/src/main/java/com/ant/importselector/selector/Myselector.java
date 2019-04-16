package com.ant.importselector.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: Myselector
 * @Description: Myselector
 * @datetime 2019/3/14 21:33
 * @Version 1.0
 */

public class Myselector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{MyBeanPostProcessor.class.getName()};
	}
}
