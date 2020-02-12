package com.ant.spring.bean.factory;

import com.ant.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * <p>
 * {@link User} Bean 的 {@link org.springframework.beans.factory.FactoryBean} 实现
 * </p>
 *
 * @Author Ant gxstax@163.com
 * @since 2020/1/18 11:21 下午
 **/
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
