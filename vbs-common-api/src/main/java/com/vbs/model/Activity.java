package com.vbs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;        //id
    @NonNull
    private String name;    //名稱
    private String description;     //敘述
    @NonNull
    @Column(name = "netheight")
    private String netHeight;       //網高類型  男網、女網
    @NonNull
    private String sex;             //性別  純男、純女、混排
    private int quota = 18;         //人數限制
    @Column(name = "starttime", updatable = false)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date startTime;    //開始時間
    @Column(name = "endtime", updatable = false)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date endTime;    //結束時間
    @Column(name = "createdate", updatable = false)
    @JsonFormat(pattern = "yyyy/MM/dd")
    @CreationTimestamp
    private Date createDate;    //建立日期
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizer")
    @NonNull
    private User user;       //發起人
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courtid")
    @NonNull
    private Court court;       //球場

    public Activity(@NonNull String name, String description, @NonNull String netHeight, @NonNull String sex, int quota, Date startTime, Date endTime, @NonNull User user, @NonNull Court court) {
        this.name = name;
        this.description = description;
        this.netHeight = netHeight;
        this.sex = sex;
        this.quota = quota;
        this.startTime = startTime;
        this.endTime = endTime;
        this.user = user;
        this.court = court;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", netHeight='" + netHeight + '\'' +
                ", sex='" + sex + '\'' +
                ", quota=" + quota +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createDate=" + createDate +
                ", user=" + user +
                ", court=" + court +
                '}';
    }
}
