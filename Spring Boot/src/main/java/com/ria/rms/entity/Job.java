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
public class Job extends BasicEntity {
    @Id
    private String id;
    private String code;
    private String name;
    private String description;
    private Integer noOfVacancies;
    private String jobCategoryId;
    private String processId;
    private String jobPositionId;
}
