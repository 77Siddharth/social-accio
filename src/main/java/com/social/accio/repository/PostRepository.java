package com.social.accio.repository;

import com.social.accio.pojo.Post;
import com.social.accio.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
