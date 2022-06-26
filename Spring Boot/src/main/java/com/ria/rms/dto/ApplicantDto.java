package com.ria.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicantDto extends BasicDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String summary;
    private String[] documentIds;
}
