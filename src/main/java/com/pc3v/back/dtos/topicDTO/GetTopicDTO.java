package com.pc3v.back.dtos.topicDTO;

import com.pc3v.back.models.Section;
import com.pc3v.back.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTopicDTO {
    private Long id;
    private User user;
    private Section section;
    private String title;
    private String content;
    private int views;
    private Date creationDate;
    private Date lastUpdateDate;
    private boolean closed;

}
