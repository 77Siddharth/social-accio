package com.social.accio.repository;

import com.social.accio.pojo.Notification;
import com.social.accio.pojo.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {

}
