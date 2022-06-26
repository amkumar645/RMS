package com.ria.rms.service;

import com.ria.rms.dto.JobPositionDto;

import java.util.List;

public interface JobPositionService extends BasicService<JobPositionDto> {
    public List<JobPositionDto> findByCode(String value);

    public List<JobPositionDto> findByName(String value);
}
