package com.pc3v.back.dtos.postDTO;

import com.pc3v.back.models.Topic;
import com.pc3v.back.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPostDTO {
    private Long id;
    private Topic topic;
    private User user;
    private String content;
    private Date creationDate;
    private Date lastUpdateDate;

}
