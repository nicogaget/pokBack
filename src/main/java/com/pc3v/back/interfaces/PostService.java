package com.pc3v.back.interfaces;


import com.pc3v.back.dtos.postDTO.GetPostDTO;
import com.pc3v.back.dtos.postDTO.PostPostDTO;
import com.pc3v.back.models.User;
import com.pc3v.back.models.Post;
import com.pc3v.back.models.Topic;

import java.util.List;
import java.util.Set;


public interface PostService {

    GetPostDTO findOne(Long id);
    
    List<GetPostDTO> findAll();
    
    Set<Post> findRecent();
    
    Set<Post> findAllByOrderByCreationDateDesc();
    
    Set<Post> findByUser(User user);
    
    Set<Post> findByTopic(Long idTopic);
    
    Set<Post> findByTopic(Topic topic);
    
    Post save(PostPostDTO post);


    void delete(Long id) throws Exception;

    void save(String content,
              String username,
              Long idTopic);
    
}
