package com.ria.rms.service;

import com.ria.rms.dto.ProcDto;

import java.util.List;

public interface ProcService extends BasicService<ProcDto> {
    public List<ProcDto> findByName(String value);
}
