/*
 * Copyright 2002-2017 the original author or authors.
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

package org.springframework.context.annotation;

import java.lang.annotation.Annotation;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Convenient adapter for programmatic registration of annotated bean classes.
 * This is an alternative to {@link ClassPathBeanDefinitionScanner}, applying
 * the same resolution of annotations but for explicitly registered classes only.
 *
 * @author Juergen Hoeller
 * @author Chris Beams
 * @author Sam Brannen
 * @author Phillip Webb
 * @since 3.0
 * @see AnnotationConfigApplicationContext#register
 */
public class AnnotatedBeanDefinitionReader {

	private final BeanDefinitionRegistry registry;

	private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

	private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();

	// 用来处理@注解的类
	private ConditionEvaluator conditionEvaluator;


	/**
	 * Create a new {@code AnnotatedBeanDefinitionReader} for the given registry.
	 * If the registry is {@link EnvironmentCapable}, e.g. is an {@code ApplicationContext},
	 * the {@link Environment} will be inherited, otherwise a new
	 * {@link StandardEnvironment} will be created and used.
	 * @param registry the {@code BeanFactory} to load bean definitions into,
	 * in the form of a {@code BeanDefinitionRegistry}
	 * @see #AnnotatedBeanDefinitionReader(BeanDefinitionRegistry, Environment)
	 * @see #setEnvironment(Environment)
	 */
	public AnnotatedBeanDefinitionReader(BeanDefinitionRegistry registry) {
		this(registry, getOrCreateEnvironment(registry));
	}

	/**
	 * Create a new {@code AnnotatedBeanDefinitionReader} for the given registry and using
	 * the given {@link Environment}.
	 * @param registry the {@code BeanFactory} to load bean definitions into,
	 * in the form of a {@code BeanDefinitionRegistry}
	 * @param environment the {@code Environment} to use when evaluating bean definition
	 * profiles.
	 * @since 3.1
	 */
	public AnnotatedBeanDefinitionReader(BeanDefinitionRegistry registry, Environment environment) {
		Assert.notNull(registry, "BeanDefinitionRegistry must not be null");

		// registry实际上是我们传过来的AnnotationConfigApplicationContext（spring容器）
		// 它继承了BeanDefinitionRegistry接口；
		// 这里把它赋值给当前类定义的BeanDefinitionRegistry，用来做容器的初始化
		this.registry = registry;
		this.conditionEvaluator = new ConditionEvaluator(registry, environment, null);
		// 这个方法会定义6+1个处理我们bean的类，也就是注册6个BeanDefinition到spring工厂的BeanDefinitionMap中去
		AnnotationConfigUtils.registerAnnotationConfigProcessors(this.registry);
	}


	/**
	 * Return the BeanDefinitionRegistry that this scanner operates on.
	 */
	public final BeanDefinitionRegistry getRegistry() {
		return this.registry;
	}

	/**
	 * Set the Environment to use when evaluating whether
	 * {@link Conditional @Conditional}-annotated component classes should be registered.
	 * <p>The default is a {@link StandardEnvironment}.
	 * @see #registerBean(Class, String, Class...)
	 */
	public void setEnvironment(Environment environment) {
		this.conditionEvaluator = new ConditionEvaluator(this.registry, environment, null);
	}

	/**
	 * Set the BeanNameGenerator to use for detected bean classes.
	 * <p>The default is a {@link AnnotationBeanNameGenerator}.
	 */
	public void setBeanNameGenerator(@Nullable BeanNameGenerator beanNameGenerator) {
		this.beanNameGenerator = (beanNameGenerator != null ? beanNameGenerator : new AnnotationBeanNameGenerator());
	}

	/**
	 * Set the ScopeMetadataResolver to use for detected bean classes.
	 * <p>The default is an {@link AnnotationScopeMetadataResolver}.
	 */
	public void setScopeMetadataResolver(@Nullable ScopeMetadataResolver scopeMetadataResolver) {
		this.scopeMetadataResolver =
				(scopeMetadataResolver != null ? scopeMetadataResolver : new AnnotationScopeMetadataResolver());
	}


	/**
	 * 循环注册要处理的加了@Configuration的配置类
	 * Register one or more annotated classes to be processed.
	 * <p>Calls to {@code register} are idempotent; adding the same
	 * annotated class more than once has no additional effect.
	 * @param annotatedClasses one or more annotated classes,
	 * e.g. {@link Configuration @Configuration} classes
	 */
	public void register(Class<?>... annotatedClasses) {
		for (Class<?> annotatedClass : annotatedClasses) {
			registerBean(annotatedClass);
		}
	}

	/**
	 * Register a bean from the given bean class, deriving its metadata from
	 * class-declared annotations.
	 * @param annotatedClass the class of the bean
	 */
	public void registerBean(Class<?> annotatedClass) {
		doRegisterBean(annotatedClass, null, null, null);
	}

	/**
	 * Register a bean from the given bean class, deriving its metadata from
	 * class-declared annotations, using the given supplier for obtaining a new
	 * instance (possibly declared as a lambda expression or method reference).
	 * @param annotatedClass the class of the bean
	 * @param instanceSupplier a callback for creating an instance of the bean
	 * (may be {@code null})
	 * @since 5.0
	 */
	public <T> void registerBean(Class<T> annotatedClass, @Nullable Supplier<T> instanceSupplier) {
		doRegisterBean(annotatedClass, instanceSupplier, null, null);
	}

	/**
	 * Register a bean from the given bean class, deriving its metadata from
	 * class-declared annotations, using the given supplier for obtaining a new
	 * instance (possibly declared as a lambda expression or method reference).
	 * @param annotatedClass the class of the bean
	 * @param name an explicit name for the bean
	 * @param instanceSupplier a callback for creating an instance of the bean
	 * (may be {@code null})
	 * @since 5.0
	 */
	public <T> void registerBean(Class<T> annotatedClass, String name, @Nullable Supplier<T> instanceSupplier) {
		doRegisterBean(annotatedClass, instanceSupplier, name, null);
	}

	/**
	 * Register a bean from the given bean class, deriving its metadata from
	 * class-declared annotations.
	 * @param annotatedClass the class of the bean
	 * @param qualifiers specific qualifier annotations to consider,
	 * in addition to qualifiers at the bean class level
	 */
	@SuppressWarnings("unchecked")
	public void registerBean(Class<?> annotatedClass, Class<? extends Annotation>... qualifiers) {
		doRegisterBean(annotatedClass, null, null, qualifiers);
	}

	/**
	 * Register a bean from the given bean class, deriving its metadata from
	 * class-declared annotations.
	 * @param annotatedClass the class of the bean
	 * @param name an explicit name for the bean
	 * @param qualifiers specific qualifier annotations to consider,
	 * in addition to qualifiers at the bean class level
	 */
	@SuppressWarnings("unchecked")
	public void registerBean(Class<?> annotatedClass, String name, Class<? extends Annotation>... qualifiers) {
		doRegisterBean(annotatedClass, null, name, qualifiers);
	}

	/**
	 * 这个方法是把我们的注解的类注册到BeanDefinition中去
	 * Register a bean from the given bean class, deriving its metadata from
	 * class-declared annotations.
	 * @param annotatedClass the class of the bean
	 * @param instanceSupplier a callback for creating an instance of the bean
	 * (may be {@code null})
	 * @param name an explicit name for the bean
	 * @param qualifiers specific qualifier annotations to consider, if any,
	 * in addition to qualifiers at the bean class level
	 * @param definitionCustomizers one or more callbacks for customizing the
	 * factory's {@link BeanDefinition}, e.g. setting a lazy-init or primary flag
	 * @since 5.0
	 */
	<T> void doRegisterBean(Class<T> annotatedClass, @Nullable Supplier<T> instanceSupplier, @Nullable String name,
			@Nullable Class<? extends Annotation>[] qualifiers, BeanDefinitionCustomizer... definitionCustomizers) {

		/**   --------------   接下来这个方法中的过程实际上把bean转换成一个bd的过程 ----------------  **/


		/**
		 * 根据指定的bean创建一个AnnotatedGenericBeanDefinition
		 * 这个AnnotatedGenericBeanDefinition可以理解为一个数据结构
		 *
		 * BeanDefinition分为几个种类，前面初始化的spring的6个后置处理器的类型为RootBeanDefinition
		 * 这里是我们自己定义的Appconfig配置类，这里使用的是AnnotatedGenericBeanDefinition类型
		 * 但是他们都是BeanDefinition的子类
		 */
		AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(annotatedClass);

		/**
		 * 这句话判断类是否加了注解（查看类中是否有@Compotent @service  @Repository诸如此类的注解）
		 * 通过判断有无注解，spring来判断是否需要解析，如果没有加注解，则Spring会跳过解析
		 */
		if (this.conditionEvaluator.shouldSkip(abd.getMetadata())) {
			return;
		}

		/**
		 * 判读是否有方法回调
		 */
		abd.setInstanceSupplier(instanceSupplier);

		/**
		 * 得到bean类的作用域，默认为singleton
		 * 如果Appconfig上面加了@Scope(value = "prototype")
		 * 则spring会设定scopeMetadata的scopeName="prototype"
		 * 表示是使用原型，而不是使用单例
		 */
		ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(abd);

		/**
		 * 把bean类的作用域添加到类定义中
		 */
		abd.setScope(scopeMetadata.getScopeName());

		/**
		 * 通过beanNameGenerator生成一个BeanName
		 */
		// 查看是否Bean有定义自己的beanName；如：@Configuration(value = "appConfig")、@Component(value = "appConfig")
	    // 如果有，则把程序员自己定义的beanName返回出去，否则则使用spring的默认规则（类名的首字母小写）
		String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(abd, this.registry));

		// 处理一些特殊的注解，比如@Lazy、@Primary、@DependsOn
		AnnotationConfigUtils.processCommonDefinitionAnnotations(abd);


		if (qualifiers != null) {
			for (Class<? extends Annotation> qualifier : qualifiers) {
				// @Primary注解的作用是当spring扫描到一个接口的两个实现类的时候，
				// 加了@Primary的bean将作为首选
				if (Primary.class == qualifier) {
					abd.setPrimary(true);
				}
				else if (Lazy.class == qualifier) {
					abd.setLazyInit(true);
				}
				else {
					abd.addQualifier(new AutowireCandidateQualifier(qualifier));
				}
			}
		}
		// 处理spring和客户自定义的bean 暂时不知道是个什么鬼东西
		for (BeanDefinitionCustomizer customizer : definitionCustomizers) {
			customizer.customize(abd);
		}

		/**
		 * 定义一个BeanDefinitionHolder用来包装我们spring中beanDeintionMap结构中bd+beanName，
		 * 方便后面调用（后面会代码中会再分解开），没有实际意义
		 */
		BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd, beanName);


		/**
		 * 是否启用代理模式
		 */
		definitionHolder = AnnotationConfigUtils.applyScopedProxyMode(scopeMetadata, definitionHolder, this.registry);

		/** -------   从这一行往上的代码就是把一个bean变为一个bd（BeanDefinition）过程   --------- **/



		// 这里是把我们前面的bean放入到BeanDefinition中去
		// 很重要
		BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, this.registry);
	}


	/**
	 * Get the Environment from the given registry if possible, otherwise return a new
	 * StandardEnvironment.
	 */
	private static Environment getOrCreateEnvironment(BeanDefinitionRegistry registry) {
		Assert.notNull(registry, "BeanDefinitionRegistry must not be null");
		if (registry instanceof EnvironmentCapable) {
			return ((EnvironmentCapable) registry).getEnvironment();
		}
		return new StandardEnvironment();
	}

}
