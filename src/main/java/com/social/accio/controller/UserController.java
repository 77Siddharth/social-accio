package com.social.accio.controller;

import com.social.accio.pojo.User;
import com.social.accio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/mostlikes")
    public User getUserWithMostLikes(){
        return userService.getUserWithMostLikes();
    }

    @PostMapping("/")
    public String createUser(
            @RequestParam String name,
            @RequestParam Integer age
    ){
        return userService.createUser(name,age);
    }

    @PostMapping("/post/{userId}")
    public String createPost(
            @RequestBody String content,
            @PathVariable Long userId
    ){
        return userService.createPost(userId,content);
    }

    @PutMapping("/like/{postId}")
    public String likePost(
            @PathVariable Long postId
    ){
        return userService.likePost(postId);
    }

    @PostMapping("/notification/{postId}")
    public String createNotification(
            @PathVariable Long postId
    ){
        return userService.createNotification(postId);
    }

}

