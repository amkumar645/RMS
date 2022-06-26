package com.ria.rms.service;

import com.ria.rms.dto.ApplicantDto;

import java.util.List;

public interface ApplicantService extends BasicService<ApplicantDto> {
    public List<ApplicantDto> findByEmail(String value);
}
