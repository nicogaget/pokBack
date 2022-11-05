package com.pc3v.back.dtos.sectionDTO;

import com.pc3v.back.dtos.topicDTO.GetTopicDTO;

import java.util.Set;

public class GetTopicsBySection {
    private Long id;
    private String name;
    private String description;
    private Set<GetTopicDTO> topics;
}
