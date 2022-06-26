package com.ria.rms.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;

@Data
public class BasicEntity {

    @CreatedDate
    @Column(name = "CREATED_AT")
    private String createdAt;
    @LastModifiedDate
    @Column(name = "MODIFIED_AT")
    private String modifiedAt;
    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;
    @LastModifiedBy
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
}
