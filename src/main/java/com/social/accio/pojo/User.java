package com.social.accio.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//User = UserId, Name, Age, List<Post>, List<Notification>
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    private String name;

    private Integer age;

    private Long likeCount;

    @OneToMany(mappedBy = "user")
    private Post post;

    @OneToMany(mappedBy = "user")
    private Notification notification;
}
