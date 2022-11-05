package com.pc3v.back.dtos.postDTO;

import com.pc3v.back.models.Topic;
import com.pc3v.back.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPostDTO {
    private Topic topic;
    private User user;
    private String content;
}
