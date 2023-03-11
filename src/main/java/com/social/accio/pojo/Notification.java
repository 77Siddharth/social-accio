package com.social.accio.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

//Notification = Post, Time


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private static Long likeCount;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @CreationTimestamp
    @Column(name = "notificationTime",updatable = false)
    private Date notificationTime;

    @JsonIgnore
    @ManyToOne
    private Post post;

    @JsonIgnore
    @ManyToOne
    private User user;
}
