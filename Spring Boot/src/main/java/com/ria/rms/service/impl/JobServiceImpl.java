package com.ria.rms.service.impl;

import com.ria.rms.dao.JobRepo;
import com.ria.rms.dto.JobDto;
import com.ria.rms.entity.Job;
import com.ria.rms.exceptions.BadRequestException;
import com.ria.rms.exceptions.DataNotFoundException;
import com.ria.rms.mappers.JobMapper;
import com.ria.rms.service.JobService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepo jobRepo;
    @Autowired
    private JobMapper jobMapper;

    @SneakyThrows
    @Override
    public List<JobDto> findAll() {
        List<Job> categories = jobRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return jobMapper.toDtoList(categories);
    }

    @Override
    public Page findAll(Map<String, Object> queryParams) {
        return null;
    }

    @SneakyThrows
    @Override
    public JobDto findById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        Optional<Job> job = jobRepo.findById(id);
        JobDto jobDto = jobMapper.toDto(
                job.orElseThrow(() -> new BadRequestException("Given id " + id + ", is not present. Please verify passing parameter.")));
        return jobDto;
    }

    @Override
    public JobDto save(JobDto jobDto) {
        Job job = jobRepo.save(jobMapper.fromDto(jobDto));
        return jobMapper.toDto(job);
    }

    @Override
    public JobDto update(JobDto jobDto) {
        Job job = jobRepo.save(jobMapper.fromDto(jobDto));
        return jobMapper.toDto(job);
    }

    @SneakyThrows
    @Override
    public boolean deleteById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        jobRepo.deleteById(id);
        return true;
    }

    @SneakyThrows
    public List<JobDto> findByCode(String value) {
        if (value == null || value.isEmpty()) throw new BadRequestException("Passing parameter should not be null");

        Optional<List<Job>> jList = jobRepo.findAllByCodeStartsWith(value);
        return jobMapper.toDtoList(
                jList.orElseThrow(() -> new BadRequestException("Given code value " + value + ", is not present. Please verify passing parameter.")));
    }

    @SneakyThrows
    public List<JobDto> findByName(String value) {
        if (value == null || value.isEmpty()) throw new BadRequestException("Passing parameter should not be null");

        Optional<List<Job>> jList = jobRepo.findAllByName(value);
        return jobMapper.toDtoList(
                jList.orElseThrow(() -> new BadRequestException("Given code value " + value + ", is not present. Please verify passing parameter.")));
    }


}

