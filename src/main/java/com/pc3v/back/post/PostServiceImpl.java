/**
 * Created by Dawid Stankiewicz on 18.07.2016
 */
package com.pc3v.back.post;

import com.pc3v.back.models.User;
import com.pc3v.back.security.services.UserService;
import com.pc3v.back.topic.Topic;
import com.pc3v.back.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private TopicService topicService;
    
    @Autowired
    private UserService userService;
    
    @Override
    public Post findOne(int id) {
        // todo fix optional
        return postRepository.findById(id).get();
    }
    
    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
    
    @Override
    public Set<Post> findRecent() {
        return postRepository.findTop5ByOrderByCreationDateDesc();
    }
    
    @Override
    public Set<Post> findAllByOrderByCreationDateDesc() {
        return postRepository.findAllByOrderByCreationDateDesc();
    }
    
    @Override
    public Set<Post> findByUser(User user) {
        return postRepository.findByUser(user);
    }
    
    @Override
    public Set<Post> findByTopic(int idTopic) {
        return findByTopic(topicService.findOne(idTopic));
    }
    
    @Override
    public Set<Post> findByTopic(Topic topic) {
        return postRepository.findByTopic(topic);
    }
    
    @Override
    public void save(Post post) {
        postRepository.save(post);
    }
    
    @Override
    public void delete(int id) {
        delete(findOne(id));
    }
    
    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
    
    @Override
    public void save(String content,
                     String username,
                     int idTopic) {
        Post post = new Post();
        post.setTopic(topicService.findOne(idTopic));
        post.setUser(userService.findByUsername(username));
        post.setContent(content);
        save(post);
    }
    
}
