package com.kaishengit.pojo;

/**
 * Created by Administrator on 2016/6/28.
 */
public class UserAdmin {
    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAdmin{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
