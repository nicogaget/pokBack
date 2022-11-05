package com.pc3v.back.servicesImpl;

import com.pc3v.back.dtos.sectionDTO.GetSectionDTO;
import com.pc3v.back.dtos.topicDTO.DeleteTopicDTO;
import com.pc3v.back.dtos.topicDTO.GetTopicDTO;
import com.pc3v.back.dtos.topicDTO.PostTopicDTO;
import com.pc3v.back.models.User;
import com.pc3v.back.repository.TopicRepository;
import com.pc3v.back.models.Section;
import com.pc3v.back.interfaces.SectionService;
import com.pc3v.back.models.Topic;
import com.pc3v.back.interfaces.TopicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class TopicServiceImpl implements TopicService {
    
    @Autowired
    private TopicRepository topicRepository;
    ModelMapper mapper;
    
    @Autowired
    private SectionService sectionService;
    
    @Override
    public List<GetTopicDTO> findAll() {
        List<Topic> topics = topicRepository.findAll();
        List<GetTopicDTO> topicDTOS = new ArrayList<>();
        topics.forEach(topic -> topicDTOS.add(mapper.map(topic,GetTopicDTO.class)));
        return topicDTOS;
    }
    
    @Override
    public Optional<GetTopicDTO> findOne(Long id) {
        return mapper.map(topicRepository.findById(id).get(), (Type) GetTopicDTO.class);
    }
    
    @Override
    public Set<Topic> findRecent() {
        return topicRepository.findTop5ByOrderByCreationDateDesc();
    }
    
    @Override
    public Set<Topic> findAllByOrderByCreationDateDesc() {
        return topicRepository.findAllByOrderByCreationDateDesc();
    }
    
    @Override
    public Set<Topic> findBySection(Section section) {
        return topicRepository.findBySection(section);
    }

    @Override
    public Topic save(PostTopicDTO postTopicDTO) {
        Topic topic = mapper.map(postTopicDTO,Topic.class);
        topicRepository.save(topic);
        return topic;
    }

    @Override
    public Optional<GetSectionDTO> findBySectionId(Long id) {
        return sectionService.findOne(id);
    }
    
    @Override
    public Set<Topic> findByUser(User user) {
        return topicRepository.findByUser(user);
    }
    
   @Override
    public void delete(DeleteTopicDTO deleteTopicDTO) {
        topicRepository.deleteById(deleteTopicDTO.getId());
    }
    
}
