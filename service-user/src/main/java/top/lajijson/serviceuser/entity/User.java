package top.lajijson.serviceuser.entity;

import lombok.Data;

@Data
public class User {
    private String name;

    private String nickName;

    private String phone;

    public User() {
    }

    public User(String name, String nickName, String phone) {
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
