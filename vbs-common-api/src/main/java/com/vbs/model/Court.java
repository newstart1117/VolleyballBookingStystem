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
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;        //id
    @NonNull
    private String name;    //姓名
    @NonNull
    private String country;       //縣市
    @NonNull
    private String address;       //地址
    @NonNull
    @Column(name = "principalid")
    private Long principalId;       //負責人
    private int rating = 60;         //評分
    @Column(name = "createdate", updatable = false)
    @JsonFormat(pattern="yyyy/MM/dd")
    @CreationTimestamp
    private Date createDate;    //建立日期

    public Court(@NonNull String name, @NonNull String country, @NonNull String address, @NonNull long principalId) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.principalId = principalId;
    }

    @Override
    public String toString() {
        return "Court{" +
                "courtId=" + id +
                ", courtName='" + name + '\'' +
                ", county='" + country + '\'' +
                ", address='" + address + '\'' +
                ", principalId='" + principalId + '\'' +
                ", rating=" + rating +
                ", createDate=" + createDate +
                '}';
    }
}
