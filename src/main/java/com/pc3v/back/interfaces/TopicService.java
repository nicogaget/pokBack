package com.pc3v.back.interfaces;


import com.pc3v.back.dtos.sectionDTO.GetSectionDTO;
import com.pc3v.back.dtos.topicDTO.DeleteTopicDTO;
import com.pc3v.back.dtos.topicDTO.GetTopicDTO;
import com.pc3v.back.dtos.topicDTO.PostTopicDTO;
import com.pc3v.back.models.User;
import com.pc3v.back.models.Section;
import com.pc3v.back.models.Topic;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface TopicService {
    
    List<GetTopicDTO> findAll();

    Optional<GetTopicDTO> findOne(Long id);
    
    Set<Topic> findRecent();

    Optional<GetSectionDTO> findBySectionId(Long id);

    Set<Topic> findAllByOrderByCreationDateDesc();
    
    Set<Topic> findBySection(Section section);

    Topic save(PostTopicDTO postTopicDTO);

    Set<Topic> findByUser(User user);

    void delete(DeleteTopicDTO deleteTopicDTO);
    
}
