package com.ria.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackDto {
    private String id;
    private String date;
    private String startTime;
    private String endTime;
    private String interviewer;
    private String comments;
    private String notes;
    private String interviewId;
}
