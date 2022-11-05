package com.pc3v.back.controllers;

import com.pc3v.back.dtos.postDTO.DeletePostDTO;
import com.pc3v.back.dtos.postDTO.GetPostDTO;
import com.pc3v.back.dtos.postDTO.PostPostDTO;
import com.pc3v.back.interfaces.PostService;
import com.pc3v.back.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping()
    public List<GetPostDTO> findAll(){
        return postService.findAll();
    }

    @RequestMapping("{id}")
    public GetPostDTO findOnePost(@PathVariable Long id) {
        return postService.findOne(id);
    }


    @PostMapping()
    public Post createPost(@RequestBody PostPostDTO postDTO ){
        return postService.save(postDTO);
    }


    @PutMapping()
    public Post update(@RequestBody PostPostDTO postDTO){
        return postService.save(postDTO);
    }

    @DeleteMapping()
    public void delete(@RequestBody DeletePostDTO deletePostDTO) throws Exception {
        postService.delete(deletePostDTO.getId());
    }
}

