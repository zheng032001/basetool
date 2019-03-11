package com.orange.basetool.entity.global;


import org.springframework.context.annotation.Bean;


/**
 * 用户实体类
 */
public class User {

    /**
     * 用户账号
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private int birthday;

    /**
     * 当前用户组编号
     */
    private String currentGroupId;

    /**
     * 当前用户组名称
     */
    private String currentGroupName;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 电话号码
     */
    private String phoneNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getCurrentGroupId() {
        return currentGroupId;
    }

    public void setCurrentGroupId(String currentGroupId) {
        this.currentGroupId = currentGroupId;
    }

    public String getCurrentGroupName() {
        return currentGroupName;
    }

    public void setCurrentGroupName(String currentGroupName) {
        this.currentGroupName = currentGroupName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
