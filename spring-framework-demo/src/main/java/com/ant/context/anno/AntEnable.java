package com.ant.context.anno;

import com.ant.context.imports.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Ant
 * @ClassName: AntEnable
 * @Description: TODO
 * @datetime 2018/12/6 8:34
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportSelector.class)
public @interface AntEnable {

}
