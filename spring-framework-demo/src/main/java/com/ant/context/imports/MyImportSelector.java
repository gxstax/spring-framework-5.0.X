package com.ant.context.imports;

import com.ant.context.dao.IndexDao3;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: MyImportSelector
 * @Description: TODO
 * @datetime 2018/12/6 8:08
 * @Version 1.0
 */
public class MyImportSelector implements ImportSelector{
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{IndexDao3.class.getName()};
	}
}
