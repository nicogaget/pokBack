package com.pc3v.back.post;

import com.pc3v.back.models.User;
import com.pc3v.back.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface PostRepository extends JpaRepository<Post, Integer> {
    
    Set<Post> findByUser(User user);
    
    Set<Post> findByTopic(Topic topic);
    
    Set<Post> findAllByOrderByCreationDateDesc();
    
    Set<Post> findTop5ByOrderByCreationDateDesc();
}
