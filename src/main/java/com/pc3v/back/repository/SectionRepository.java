package com.pc3v.back.repository;

import com.pc3v.back.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SectionRepository extends JpaRepository<Section, Long> {

    Section findByName(String name);

}
