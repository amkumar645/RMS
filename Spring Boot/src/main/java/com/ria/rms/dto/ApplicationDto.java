package com.ria.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationDto extends BasicDto {
    private String id;
    private String appliedDate;
    private String education;
    private String experience;
    private String applicantId;
    private String jobId;
    private String status;
}
