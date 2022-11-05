package com.pc3v.back.interfaces;

import com.pc3v.back.dtos.sectionDTO.DeleteSectionDTO;
import com.pc3v.back.dtos.sectionDTO.GetSectionDTO;
import com.pc3v.back.dtos.sectionDTO.PostSectionDTO;
import com.pc3v.back.dtos.sectionDTO.GetTopicsBySection;
import com.pc3v.back.models.Section;

import java.util.List;
import java.util.Optional;


public interface SectionService {

    List<GetSectionDTO> findAll();

    Optional<GetSectionDTO> findOne(Long id);


    GetSectionDTO findByName(String name);

    Optional<GetTopicsBySection> findTopicsBySectionId(Long id);
    
    Section save(PostSectionDTO section);

    
    void delete(DeleteSectionDTO deleteSectionDTO);
    
}
