package com.ria.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StepDto extends BasicDto {
    private String id;
    private String code;
    private String name;
    private String description;
}
