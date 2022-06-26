package com.ria.rms.service;

import com.ria.rms.dto.JobCategoryDto;

import java.util.List;

public interface JobCategoryService extends BasicService<JobCategoryDto> {
    public List<JobCategoryDto> findByCode(String value);

    public List<JobCategoryDto> findByName(String value);
}
