package com.vbs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId;        //id
    @NonNull
    private String username;    //姓名
    @NonNull
    private String phone;       //手機
    private String line;        //Line
    private int role = 1;           //角色
    private int rating = 60;         //評分
    @Column(name = "createdate", updatable = false)
    @JsonFormat(pattern="yyyy/MM/dd")
    @CreationTimestamp
    private Date createDate;    //建立日期


    public User(String username, String phone) {
        this.username = username;
        this.phone = phone;
        this.createDate = new Date();
    }

    public User(String username, String phone, String line, int role) {
        this.username = username;
        this.phone = phone;
        this.line = line;
        this.role = role;
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
