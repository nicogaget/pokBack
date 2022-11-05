
package com.pc3v.back.servicesImpl;

import com.pc3v.back.dtos.sectionDTO.DeleteSectionDTO;
import com.pc3v.back.dtos.sectionDTO.GetSectionDTO;
import com.pc3v.back.dtos.sectionDTO.PostSectionDTO;
import com.pc3v.back.dtos.sectionDTO.GetTopicsBySection;
import com.pc3v.back.repository.SectionRepository;
import com.pc3v.back.models.Section;
import com.pc3v.back.interfaces.SectionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    ModelMapper mapper;


    public List<GetSectionDTO> findAll() {
        List<Section> sections = sectionRepository.findAll();
        List<GetSectionDTO> sectionsDTOS = new ArrayList<>();
        sections.forEach(section -> sectionsDTOS.add(mapper.map(section,GetSectionDTO.class)));
        return sectionsDTOS;
    }

    public Optional<GetSectionDTO> findOne(Long id) {
        return mapper.map(sectionRepository.findById(id).get(), (Type) GetSectionDTO.class);
    }

    @Override
    public GetSectionDTO findByName(String name) {
        Section section = sectionRepository.findByName(name);
        return mapper.map(section,GetSectionDTO.class);
    }

    @Override
    public Optional<GetTopicsBySection> findTopicsBySectionId(Long id) {
        Optional<Section> section = sectionRepository.findById(id);
        return mapper.map(section, (Type) GetSectionDTO.class);
    }

    public Section save(PostSectionDTO postSectionDTO) {
        Section section = mapper.map(postSectionDTO,Section.class);
        return sectionRepository.save(section);
    }

    @Override
    public void delete(DeleteSectionDTO deleteSectionDTO ) {
        sectionRepository.deleteById(deleteSectionDTO.getId());
    }

}
