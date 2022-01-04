package com.vbs.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId;        //id
    private String username;    //姓名
    private String phone;       //手機
    private String line;        //Line
    private int role;           //角色
    private int rating;         //評分
    @Column(name = "createdate")
    private Date createDate;    //建立日期

    public User(String username, String phone, String line, int role) {
        this.username = username;
        this.phone = phone;
        this.line = line;
        this.role = role;
        this.rating = 60;
        this.createDate = new Date();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", line='" + line + '\'' +
                ", role=" + role +
                ", rating=" + rating +
                ", createDate=" + createDate +
                '}';
    }
}
