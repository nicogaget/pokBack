package com.pc3v.back.servicesImpl;

import com.pc3v.back.dtos.postDTO.GetPostDTO;
import com.pc3v.back.dtos.postDTO.PostPostDTO;
import com.pc3v.back.exception.ForumException;
import com.pc3v.back.interfaces.PostService;
import com.pc3v.back.interfaces.TopicService;
import com.pc3v.back.interfaces.UserService;
import com.pc3v.back.models.Post;
import com.pc3v.back.models.Topic;
import com.pc3v.back.models.User;
import com.pc3v.back.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    private UserService userService;
    private TopicService topicService;
    ModelMapper mapper;

    @Override
    public GetPostDTO findOne(Long id) {
        return mapper.map(postRepository.findById(id).get(), GetPostDTO.class);
    }

    @Override
    public List<GetPostDTO> findAll() {
        List<Post> posts = postRepository.findAll();
        List<GetPostDTO> getPostDTOS = new ArrayList<>();
        posts.forEach(post -> getPostDTOS.add(mapper.map(post,GetPostDTO.class)));
        return getPostDTOS;
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
    public Set<Post> findByTopic(Long idTopic) {
        return null;
    }

    @Override
    public Set<Post> findByTopic(Topic topic) {
        return postRepository.findByTopic(topic);
    }


    public Post save(PostPostDTO postDTO) {
        Post post = mapper.map(postDTO,Post.class);
       return postRepository.save(post);
    }


    @Override
    public void delete(Long post_id) throws Exception {
        Optional<Post> post = postRepository.findById(post_id);
        if (post == null) {
            throw new ForumException(ForumException.ErrorCode.INVALID_USER_FORM);
        }
        postRepository.deleteById(post_id);

    }


    @Override
    public void save(String content, String username, Long idTopic) {
        Post post = new Post();
        Topic topic=mapper.map(topicService.findOne(idTopic),Topic.class);
       post.setTopic(topic);
       post.setUser(userService.findByUsername(username));
        post.setContent(content);
        postRepository.save(post);
    }

}
