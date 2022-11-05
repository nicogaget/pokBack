package com.pc3v.back.dtos.sectionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSectionDTO {
    private Long id;
    private String name;
    private String description;

}
