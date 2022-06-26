package com.ria.rms.service;

import com.ria.rms.dto.ApplicationDto;

import java.util.List;

public interface ApplicationService extends BasicService<ApplicationDto> {
    public List<ApplicationDto> findByJobId(String value);

    public List<ApplicationDto> findByApplicantId(String value);
}
