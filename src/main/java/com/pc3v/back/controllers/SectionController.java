package com.pc3v.back.controllers;

import com.pc3v.back.dtos.sectionDTO.DeleteSectionDTO;
import com.pc3v.back.dtos.sectionDTO.GetSectionDTO;
import com.pc3v.back.dtos.sectionDTO.GetTopicsBySection;
import com.pc3v.back.dtos.sectionDTO.PostSectionDTO;
import com.pc3v.back.interfaces.SectionService;
import com.pc3v.back.models.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/sections/")
public class SectionController {
    
    @Autowired
    private SectionService sectionService;

    @RequestMapping()
    public List<GetSectionDTO> findAll(){
        return sectionService.findAll();
    }

    @RequestMapping("{id}")
    public Optional<GetSectionDTO> findOneSection(@PathVariable Long id) {
        return sectionService.findOne(id);
    }

    @RequestMapping("{id}/topics")
    public Optional<GetTopicsBySection> findTopicsBySection(@PathVariable Long id){
        return sectionService.findTopicsBySectionId(id);
    }

    @PostMapping()
    public Section createSection(@RequestBody PostSectionDTO sectionDTO ){
        return sectionService.save(sectionDTO);
    }


    @PutMapping()
    public Section update(@RequestBody PostSectionDTO sectionDTO){
        return sectionService.save(sectionDTO);
    }

    @DeleteMapping()
    public void delete(@RequestBody DeleteSectionDTO deleteSectionDTO){
        sectionService.delete(deleteSectionDTO);
    }
    
}
