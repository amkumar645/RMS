package com.ria.rms.service.impl;

import com.ria.rms.dao.StepRepo;
import com.ria.rms.dto.StepDto;
import com.ria.rms.entity.Step;
import com.ria.rms.exceptions.BadRequestException;
import com.ria.rms.exceptions.DataNotFoundException;
import com.ria.rms.mappers.StepMapper;
import com.ria.rms.service.StepService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StepServiceImpl implements StepService {

    @Autowired
    private StepRepo repo;
    @Autowired
    private StepMapper mapper;

    @SneakyThrows
    @Override
    public List<StepDto> findAll() {
        List<Step> categories = repo.findAll();
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
    public StepDto findById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        Optional<Step> step = repo.findById(id);
        StepDto dto = mapper.toDto(
                step.orElseThrow(() -> new BadRequestException("Given id " + id + ", is not present. Please verify passing parameter.")));
        return dto;
    }

    @Override
    public StepDto save(StepDto dto) {
        Step step = repo.save(mapper.fromDto(dto));
        return mapper.toDto(step);
    }

    @Override
    public StepDto update(StepDto dto) {
        Step step = repo.save(mapper.fromDto(dto));
        return mapper.toDto(step);
    }

    @SneakyThrows
    @Override
    public boolean deleteById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        repo.deleteById(id);
        return true;
    }

    @SneakyThrows
    public List<StepDto> findByName(String value) {
        if (value == null || value.isEmpty()) throw new BadRequestException("Passing parameter should not be null");

        Optional<List<Step>> aList = repo.findAllByName(value);
        return mapper.toDtoList(
                aList.orElseThrow(() -> new BadRequestException("Given email " + value + ", is not present. Please verify passing parameter.")));
    }

}
