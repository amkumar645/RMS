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
public class Application extends BasicEntity {
    @Id
    private String id;
    private String appliedDate;
    private String education;
    private String experience;
    private String applicantId;
    private String jobId;
    private String status;
}
