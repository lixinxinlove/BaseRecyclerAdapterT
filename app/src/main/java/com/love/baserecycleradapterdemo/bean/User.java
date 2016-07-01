package com.love.baserecycleradapterdemo.bean;

/**
 * Created by lixinxin on 2016/7/1.
 */
public class User {
    private String userName;
    private int age;
    private String phone;


    public User() {
    }

    public User(String userName, int age, String phone) {
        this.userName = userName;
        this.age = age;
        this.phone = phone;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
