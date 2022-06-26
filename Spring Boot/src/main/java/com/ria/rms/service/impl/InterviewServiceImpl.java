package com.ria.rms.service.impl;

import com.ria.rms.dao.InterviewRepo;
import com.ria.rms.dto.InterviewDto;
import com.ria.rms.entity.Interview;
import com.ria.rms.exceptions.BadRequestException;
import com.ria.rms.exceptions.DataNotFoundException;
import com.ria.rms.mappers.InterviewMapper;
import com.ria.rms.service.InterviewService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepo repo;
    @Autowired
    private InterviewMapper mapper;

    @SneakyThrows
    @Override
    public List<InterviewDto> findAll() {
        List<Interview> categories = repo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return mapper.toDtoList(categories);
    }

    @Override
    public Page findAll(Map<String, Object> queryParams) {
        return null;
    }

    @SneakyThrows
    @Override
    public InterviewDto findById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        Optional<Interview> application = repo.findById(id);
        InterviewDto dto = mapper.toDto(
                application.orElseThrow(() -> new BadRequestException("Given id " + id + ", is not present. Please verify passing parameter.")));
        return dto;
    }

    @Override
    public InterviewDto save(InterviewDto dto) {
        Interview interview = repo.save(mapper.fromDto(dto));
        return mapper.toDto(interview);
    }

    @Override
    public InterviewDto update(InterviewDto dto) {
        Interview interview = repo.save(mapper.fromDto(dto));
        return mapper.toDto(interview);
    }

    @SneakyThrows
    @Override
    public boolean deleteById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        repo.deleteById(id);
        return true;
    }
}

