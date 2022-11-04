package com.pc3v.back.section;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SectionRepository extends JpaRepository<Section, Integer> {
    
    Section findByName(String name);
    
}
