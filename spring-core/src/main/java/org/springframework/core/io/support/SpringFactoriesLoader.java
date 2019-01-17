/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.io.support;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.io.UrlResource;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

/**
 * General purpose factory loading mechanism for internal use within the framework.
 *
 * <p>{@code SpringFactoriesLoader} {@linkplain #loadFactories loads} and instantiates
 * factories of a given type from {@value #FACTORIES_RESOURCE_LOCATION} files which
 * may be present in multiple JAR files in the classpath. The {@code spring.factories}
 * file must be in {@link Properties} format, where the key is the fully qualified
 * name of the interface or abstract class, and the value is a comma-separated list of
 * implementation class names. For example:
 *
 * <pre class="code">example.MyService=example.MyServiceImpl1,example.MyServiceImpl2</pre>
 *
 * where {@code example.MyService} is the name of the interface, and {@code MyServiceImpl1}
 * and {@code MyServiceImpl2} are two implementations.
 *
 * @author Arjen Poutsma
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @since 3.2
 */
public abstract class SpringFactoriesLoader {

	/**
	 * The location to look for factories.
	 * <p>Can be present in multiple JAR files.
	 */
	public static final String FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories";


	private static final Log logger = LogFactory.getLog(SpringFactoriesLoader.class);

	private static final Map<ClassLoader, MultiValueMap<String, String>> cache = new ConcurrentReferenceHashMap<>();


	/**
	 * Load and instantiate the factory implementations of the given type from
	 * {@value #FACTORIES_RESOURCE_LOCATION}, using the given class loader.
	 * <p>The returned factories are sorted through {@link AnnotationAwareOrderComparator}.
	 * <p>If a custom instantiation strategy is required, use {@link #loadFactoryNames}
	 * to obtain all registered factory names.
	 * @param factoryClass the interface or abstract class representing the factory
	 * @param classLoader the ClassLoader to use for loading (can be {@code null} to use the default)
	 * @see #loadFactoryNames
	 * @throws IllegalArgumentException if any factory implementation class cannot
	 * be loaded or if an error occurs while instantiating any factory
	 */
	public static <T> List<T> loadFactories(Class<T> factoryClass, @Nullable ClassLoader classLoader) {
		Assert.notNull(factoryClass, "'factoryClass' must not be null");
		ClassLoader classLoaderToUse = classLoader;
		if (classLoaderToUse == null) {
			classLoaderToUse = SpringFactoriesLoader.class.getClassLoader();
		}
		List<String> factoryNames = loadFactoryNames(factoryClass, classLoaderToUse);
		if (logger.isTraceEnabled()) {
			logger.trace("Loaded [" + factoryClass.getName() + "] names: " + factoryNames);
		}
		List<T> result = new ArrayList<>(factoryNames.size());
		for (String factoryName : factoryNames) {
			result.add(instantiateFactory(factoryName, factoryClass, classLoaderToUse));
		}
		AnnotationAwareOrderComparator.sort(result);
		return result;
	}

	/**
	 * 这一部分知识是属于springboot中的知识
	 * Load the fully qualified class names of factory implementations of the
	 * given type from {@value #FACTORIES_RESOURCE_LOCATION}, using the given
	 * class loader.
	 * @param factoryClass the interface or abstract class representing the factory
	 * @param classLoader the ClassLoader to use for loading resources; can be
	 * {@code null} to use the default
	 * @see #loadFactories
	 * @throws IllegalArgumentException if an error occurs while loading factory names
	 */
	public static List<String> loadFactoryNames(Class<?> factoryClass, @Nullable ClassLoader classLoader) {
		String factoryClassName = factoryClass.getName();
		// 从spring的配置文件中加载出用于初始化springboot环境的加载类的类名
		// 这些类名是被spring配置在META-INF/spring.factories路径下面的
		// 这些是spring在初始化环境的过程中用到的
		return loadSpringFactories(classLoader).getOrDefault(factoryClassName, Collections.emptyList());
	}

	private static Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader) {
		MultiValueMap<String, String> result = cache.get(classLoader);
		if (result != null) {
			return result;
		}

		try {
			// 使用jdk的加载器去加载META-INF/spring.factories路径下的文件内容
			// 主要是去加载springboot源码包的spring.factories文件
			Enumeration<URL> urls = (classLoader != null ?
					classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
					ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
			result = new LinkedMultiValueMap<>();
			// 循环遍历，依次解析
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				UrlResource resource = new UrlResource(url);
				/* 这里只举第一次加载，spring-boot项目下的META-INF下的spring.factoriers文件，实际上spring-boot下面有很多个spring.factoriers文件 */

				// 加载spring-boot下META-INF路径下的spring.factoriers文件内容
				// 这里我们会有8个，具体内容大致如下,我下的是spring-boot2.0x的源码包
				//0 = {Hashtable$Entry@659} "org.springframework.boot.diagnostics.FailureAnalyzer" -> "org.springframework.boot.diagnostics.analyzer.BeanCurrentlyInCreationFailureAnalyzer,org.springframework.boot.diagnostics.analyzer.BeanNotOfRequiredTypeFailureAnalyzer,org.springframework.boot.diagnostics.analyzer.BindFailureAnalyzer,org.springframework.boot.diagnostics.analyzer.BindValidationFailureAnalyzer,org.springframework.boot.diagnostics.analyzer.UnboundConfigurationPropertyFailureAnalyzer,org.springframework.boot.diagnostics.analyzer.ConnectorStartFailureAnalyzer,org.springframework.boot.diagnostics.analyzer.NoSuchMethodFailureAnalyzer,org.springframework.boot.diagnostics.analyzer.NoUniqueBeanDefinitionFailureAnalyzer,org.springframework.boot.diagnostics.analyzer.PortInUseFailureAnalyzer,org.springframework.boot.diagnostics.analyzer.ValidationExceptionFailureAnalyzer,org.springframework.boot.diagnostics.analyzer.InvalidConfigurationPropertyNameFailureAnalyzer,org.springframework.boot.diagnostics.analyzer.InvalidConfigur
				//1 = {Hashtable$Entry@660} "org.springframework.boot.env.EnvironmentPostProcessor" -> "org.springframework.boot.cloud.CloudFoundryVcapEnvironmentPostProcessor,org.springframework.boot.env.SpringApplicationJsonEnvironmentPostProcessor,org.springframework.boot.env.SystemEnvironmentPropertySourceEnvironmentPostProcessor"
				//2 = {Hashtable$Entry@661} "org.springframework.boot.SpringApplicationRunListener" -> "org.springframework.boot.context.event.EventPublishingRunListener"
				//3 = {Hashtable$Entry@662} "org.springframework.context.ApplicationContextInitializer" -> "org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer,org.springframework.boot.context.ContextIdApplicationContextInitializer,org.springframework.boot.context.config.DelegatingApplicationContextInitializer,org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer"
				//4 = {Hashtable$Entry@663} "org.springframework.boot.env.PropertySourceLoader" -> "org.springframework.boot.env.PropertiesPropertySourceLoader,org.springframework.boot.env.YamlPropertySourceLoader"
				//5 = {Hashtable$Entry@664} "org.springframework.context.ApplicationListener" -> "org.springframework.boot.ClearCachesApplicationListener,org.springframework.boot.builder.ParentContextCloserApplicationListener,org.springframework.boot.context.FileEncodingApplicationListener,org.springframework.boot.context.config.AnsiOutputApplicationListener,org.springframework.boot.context.config.ConfigFileApplicationListener,org.springframework.boot.context.config.DelegatingApplicationListener,org.springframework.boot.context.logging.ClasspathLoggingApplicationListener,org.springframework.boot.context.logging.LoggingApplicationListener,org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener"
				//6 = {Hashtable$Entry@665} "org.springframework.boot.diagnostics.FailureAnalysisReporter" -> "org.springframework.boot.diagnostics.LoggingFailureAnalysisReporter"
				//7 = {Hashtable$Entry@666} "org.springframework.boot.SpringBootExceptionReporter" -> "org.springframework.boot.diagnostics.FailureAnalyzers"
				Properties properties = PropertiesLoaderUtils.loadProperties(resource);

				// 依次对取到的内容进行解析，以congtext初始化为例,这里有4个，会对这4个依次进行解析
				//# Application Context Initializers
				//org.springframework.context.ApplicationContextInitializer=\
				//org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer,\
				//org.springframework.boot.context.ContextIdApplicationContextInitializer,\
				//org.springframework.boot.context.config.DelegatingApplicationContextInitializer,\
				//org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer
				for (Map.Entry<?, ?> entry : properties.entrySet()) {
					List<String> factoryClassNames = Arrays.asList(
							StringUtils.commaDelimitedListToStringArray((String) entry.getValue()));
					result.addAll((String) entry.getKey(), factoryClassNames);
				}
			}
			cache.put(classLoader, result);
			return result;
		}
		catch (IOException ex) {
			throw new IllegalArgumentException("Unable to load factories from location [" +
					FACTORIES_RESOURCE_LOCATION + "]", ex);
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> T instantiateFactory(String instanceClassName, Class<T> factoryClass, ClassLoader classLoader) {
		try {
			Class<?> instanceClass = ClassUtils.forName(instanceClassName, classLoader);
			if (!factoryClass.isAssignableFrom(instanceClass)) {
				throw new IllegalArgumentException(
						"Class [" + instanceClassName + "] is not assignable to [" + factoryClass.getName() + "]");
			}
			return (T) ReflectionUtils.accessibleConstructor(instanceClass).newInstance();
		}
		catch (Throwable ex) {
			throw new IllegalArgumentException("Unable to instantiate factory class: " + factoryClass.getName(), ex);
		}
	}

}
