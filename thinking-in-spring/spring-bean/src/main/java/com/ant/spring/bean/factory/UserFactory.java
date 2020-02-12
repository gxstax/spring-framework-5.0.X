package com.ant.spring.bean.factory;

import com.ant.spring.ioc.overview.domain.User;

/**
 * <p>
 * {@link com.ant.spring.ioc.overview.domain.User} User 工厂类
 * </p>
 *
 * @Author Ant gxstax@163.com
 * @since 2020/1/18 11:07 下午
 **/
public interface UserFactory {

    default User createUser() {
       return User.createUser();
    }

    void initUserFactory();

    void doDestroy();
}
