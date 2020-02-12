package com.ant.spring.ioc.overview.domain;

/**
 * <p>
 * 用户类
 * </p>
 *
 * @author Ant gxstax@163.com
 * @since 2020-01-03 09:24
 */
public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("马以");
        return user;
    }
}
