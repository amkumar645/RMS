package com.ria.rms.service.impl;

import com.ria.rms.dao.JobPositionRepo;
import com.ria.rms.dto.JobPositionDto;
import com.ria.rms.entity.JobPosition;
import com.ria.rms.exceptions.BadRequestException;
import com.ria.rms.exceptions.DataNotFoundException;
import com.ria.rms.mappers.JobPositionMapper;
import com.ria.rms.service.JobPositionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class JobPositionServiceImpl implements JobPositionService {

    @Autowired
    private JobPositionRepo jobPositionRepo;
    @Autowired
    private JobPositionMapper jobPositionMapper;

    @SneakyThrows
    @Override
    public List<JobPositionDto> findAll() {
        List<JobPosition> categories = jobPositionRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return jobPositionMapper.toDtoList(categories);
    }

    @Override
    public Page findAll(Map<String, Object> queryParams) {
        return null;
    }

    @SneakyThrows
    @Override
    public JobPositionDto findById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        Optional<JobPosition> jobPosition = jobPositionRepo.findById(id);
        JobPositionDto jobPositionDto = jobPositionMapper.toDto(
                jobPosition.orElseThrow(() -> new BadRequestException("Given id " + id + ", is not present. Please verify passing parameter.")));
        return jobPositionDto;
    }

    @Override
    public JobPositionDto save(JobPositionDto jobPositionDto) {
        JobPosition jobPosition = jobPositionRepo.save(jobPositionMapper.fromDto(jobPositionDto));
        return jobPositionMapper.toDto(jobPosition);
    }

    @Override
    public JobPositionDto update(JobPositionDto jobPositionDto) {
        JobPosition jobPosition = jobPositionRepo.save(jobPositionMapper.fromDto(jobPositionDto));
        return jobPositionMapper.toDto(jobPosition);
    }

    @SneakyThrows
    @Override
    public boolean deleteById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        jobPositionRepo.deleteById(id);
        return true;
    }

    @SneakyThrows
    public List<JobPositionDto> findByCode(String value) {
        if (value == null || value.isEmpty()) throw new BadRequestException("Passing parameter should not be null");

        Optional<List<JobPosition>> jpList = jobPositionRepo.findAllByCodeStartsWith(value);
        return jobPositionMapper.toDtoList(
                jpList.orElseThrow(() -> new BadRequestException("Given code value " + value + ", is not present. Please verify passing parameter.")));
    }

    @SneakyThrows
    public List<JobPositionDto> findByName(String value) {
        if (value == null || value.isEmpty()) throw new BadRequestException("Passing parameter should not be null");

        Optional<List<JobPosition>> jpList = jobPositionRepo.findAllByName(value);
        return jobPositionMapper.toDtoList(
                jpList.orElseThrow(() -> new BadRequestException("Given code value " + value + ", is not present. Please verify passing parameter.")));
    }


}

