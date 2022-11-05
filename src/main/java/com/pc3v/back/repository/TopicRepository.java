
package com.pc3v.back.repository;

import com.pc3v.back.models.User;
import com.pc3v.back.models.Section;
import com.pc3v.back.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface TopicRepository extends JpaRepository<Topic, Long> {
    
    Set<Topic> findBySection(Section section);
    
    Set<Topic> findByUser(User user);
    
    Set<Topic> findAllByOrderByCreationDateDesc();
    
    Set<Topic> findTop5ByOrderByCreationDateDesc();
    
    
}
