package com.ria.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback extends BasicEntity {
    @Id
    private String id;
    private String date;
    private String startTime;
    private String endTime;
    private String interviewer;
    private String comments;
    private String notes;
    private String interviewId;
}
