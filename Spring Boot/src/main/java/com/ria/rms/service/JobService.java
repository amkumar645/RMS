package com.ria.rms.service;

import com.ria.rms.dto.JobDto;

import java.util.List;

public interface JobService extends BasicService<JobDto> {
    public List<JobDto> findByCode(String value);

    public List<JobDto> findByName(String value);
}
