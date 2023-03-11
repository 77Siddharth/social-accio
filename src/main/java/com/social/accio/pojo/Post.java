package com.social.accio.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

//Post = Content, Time, User, Like;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PostId;

    private String content;

    private Long likeCount;

    @CreationTimestamp
    @Column(name = "postCreation",updatable = false)
    private Date postCreation;

    @JsonIgnore
    @ManyToOne
    private User user;

}
