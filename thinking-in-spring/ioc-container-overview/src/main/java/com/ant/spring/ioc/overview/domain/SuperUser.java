package com.ant.spring.ioc.overview.domain;

import com.ant.spring.ioc.overview.annotation.Super;

/**
 * <p>
 * 超级用户
 * </p>
 *
 * @author Ant gxstax@163.com
 * @since 2020-01-06 09:06
 */
@Super
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
