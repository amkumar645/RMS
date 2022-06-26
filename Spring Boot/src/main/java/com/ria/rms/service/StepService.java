package com.ria.rms.service;

import com.ria.rms.dto.StepDto;

import java.util.List;

public interface StepService extends BasicService<StepDto> {
    public List<StepDto> findByName(String value);
}
