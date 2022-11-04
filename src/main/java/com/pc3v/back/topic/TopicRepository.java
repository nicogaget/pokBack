
package com.pc3v.back.topic;

import com.pc3v.back.models.User;
import com.pc3v.back.section.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface TopicRepository extends JpaRepository<Topic, Integer> {
    
    Set<Topic> findBySection(Section section);
    
    Set<Topic> findByUser(User user);
    
    Set<Topic> findAllByOrderByCreationDateDesc();
    
    Set<Topic> findTop5ByOrderByCreationDateDesc();
    
    
}
