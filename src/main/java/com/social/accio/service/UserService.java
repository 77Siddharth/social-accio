package com.social.accio.service;

import com.social.accio.pojo.Notification;
import com.social.accio.pojo.Post;
import com.social.accio.pojo.User;
import com.social.accio.repository.NotificationRepository;
import com.social.accio.repository.PostRepository;
import com.social.accio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    public String createUser(String name, Integer age) {
        User newUser = new User();
        newUser.setAge(age);
        newUser.setName(name);

        userRepository.save(newUser);
        return "Successfully Saved";
    }

    public String createPost(Long userId, String content) {
        Post newPost = new Post();
        User foundUser = userRepository.findById(userId).get();
        newPost.setUser(foundUser);
        newPost.setContent(content);
        newPost.setPostCreation(new Date());
        postRepository.save(newPost);
        return "Success";
    }

    public String likePost(Long postId) {
        Post foundPost = postRepository.findById(postId).get();
        Long curLikes = foundPost.getLikeCount();
        foundPost.setLikeCount(curLikes+1);
        postRepository.save(foundPost);
        return "Liked Post";
    }

    public String createNotification(Long postId) {
        Notification newNotification = new Notification();
        Post foundPost = postRepository.findById(postId).get();
        newNotification.setNotificationTime(new Date());
        newNotification.setPost(foundPost);
        notificationRepository.save(newNotification);
        return "Notified";
    }

    public User getUserWithMostLikes() {
        List<User> ls = userRepository.findAll();

        User mostLiked = null;
        Long maxLikedCount = 0L;
        for (User u:ls){
            Long curLike = u.getLikeCount();
            if (maxLikedCount<curLike){
                mostLiked = u;
                maxLikedCount = curLike;
            }
        }
        return mostLiked;
    }
}
