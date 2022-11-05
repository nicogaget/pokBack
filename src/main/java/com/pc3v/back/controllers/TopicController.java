/**
 * Created by Dawid Stankiewicz on 19.07.2016
 */
package com.pc3v.back.controllers;

import com.pc3v.back.dtos.topicDTO.DeleteTopicDTO;
import com.pc3v.back.dtos.topicDTO.GetTopicDTO;
import com.pc3v.back.dtos.topicDTO.PostTopicDTO;
import com.pc3v.back.interfaces.TopicService;
import com.pc3v.back.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/topics/")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping()
    public List<GetTopicDTO> findAll(){
        return topicService.findAll();
    }

    @RequestMapping("{id}")
    public Optional<GetTopicDTO> findOneTopic(@PathVariable Long id) {
        return topicService.findOne(id);
    }

    @PostMapping()
    public Topic createTopic(@RequestBody PostTopicDTO postTopicDTO ){ return topicService.save(postTopicDTO);}

    @PutMapping()
    public Topic update(@RequestBody PostTopicDTO postTopicDTO){
        return topicService.save(postTopicDTO);
    }

    @DeleteMapping()
    public void delete(@RequestBody DeleteTopicDTO deleteTopicDTO){
        topicService.delete(deleteTopicDTO);
    }


}
