package com.vbs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ActivityRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;                //id
    private int status = 2;         //報名狀態  1申請 2參加 3拒絕 4取消
    @Column(name = "createdate", updatable = false)
    @JsonFormat(pattern = "yyyy/MM/dd")
    @CreationTimestamp
    private Date createDate;        //建立日期
    @Column(name = "updatetime", updatable = true)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @UpdateTimestamp
    private Date updateTime;        //更新時間
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant")
    @NonNull
    private User user;              //參與者
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activityid")
    @NonNull
    private Activity activity;       //活動

    public ActivityRegistration(int status, @NonNull User user, @NonNull Activity activity) {
        this.status = status;
        this.user = user;
        this.activity = activity;
    }
}
