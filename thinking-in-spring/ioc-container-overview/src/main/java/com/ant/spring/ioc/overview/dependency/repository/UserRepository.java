package com.ant.spring.ioc.overview.dependency.repository;

import com.ant.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

import java.util.Collection;

/**
 * <p>
 * 用户信息仓库
 * </p>
 *
 * @author Ant gxstax@163.com
 * @since 2020-01-07 08:15
 */
public class UserRepository {
    private Collection<User> users;

    private BeanFactory beanFactory;

    private ObjectFactory<User> userObjectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public ObjectFactory<User> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }
}
