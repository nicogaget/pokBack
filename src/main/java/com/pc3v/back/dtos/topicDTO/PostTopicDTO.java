package com.pc3v.back.dtos.topicDTO;

import com.pc3v.back.models.Section;
import com.pc3v.back.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostTopicDTO {
    private User user;
    private Section section;
    private String title;
    private String content;
}
