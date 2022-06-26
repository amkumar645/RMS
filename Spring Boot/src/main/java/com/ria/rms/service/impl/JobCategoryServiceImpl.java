package com.ria.rms.service.impl;

import com.ria.rms.dao.JobCategoryRepo;
import com.ria.rms.dto.JobCategoryDto;
import com.ria.rms.entity.JobCategory;
import com.ria.rms.exceptions.BadRequestException;
import com.ria.rms.exceptions.DataNotFoundException;
import com.ria.rms.mappers.JobCategoryMapper;
import com.ria.rms.service.JobCategoryService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class JobCategoryServiceImpl implements JobCategoryService {

    @Autowired
    private JobCategoryRepo jobCategoryRepo;
    @Autowired
    private JobCategoryMapper jobCategoryMapper;

    @SneakyThrows
    @Override
    public List<JobCategoryDto> findAll() {
        List<JobCategory> categories = jobCategoryRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return jobCategoryMapper.toDtoList(categories);
    }

    @Override
    public Page findAll(Map<String, Object> queryParams) {
        return null;
    }

    @SneakyThrows
    @Override
    public JobCategoryDto findById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        Optional<JobCategory> jobCategory = jobCategoryRepo.findById(id);
        return jobCategoryMapper.toDto(
                jobCategory.orElseThrow(() -> new BadRequestException("Given id " + id + ", is not present. Please verify passing parameter.")));
    }

    @Override
    public JobCategoryDto save(JobCategoryDto jobCategoryDto) {
        JobCategory jobCategory = jobCategoryRepo.save(jobCategoryMapper.fromDto(jobCategoryDto));
        return jobCategoryMapper.toDto(jobCategory);
    }

    @Override
    public JobCategoryDto update(JobCategoryDto jobCategoryDto) {
        JobCategory jobCategory = jobCategoryRepo.save(jobCategoryMapper.fromDto(jobCategoryDto));
        return jobCategoryMapper.toDto(jobCategory);
    }

    @SneakyThrows
    @Override
    public boolean deleteById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        jobCategoryRepo.deleteById(id);
        return true;
    }

    @SneakyThrows
    public List<JobCategoryDto> findByCode(String value) {
        if (value == null || value.isEmpty()) throw new BadRequestException("Passing parameter should not be null");

        Optional<List<JobCategory>> jcList = jobCategoryRepo.findAllByCodeStartsWith(value);
        return jobCategoryMapper.toDtoList(
                jcList.orElseThrow(() -> new BadRequestException("Given code value " + value + ", is not present. Please verify passing parameter.")));
    }

    @SneakyThrows
    public List<JobCategoryDto> findByName(String value) {
        if (value == null || value.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        Optional<List<JobCategory>> jcList = jobCategoryRepo.findAllByName(value);
        return jobCategoryMapper.toDtoList(
                jcList.orElseThrow(() -> new BadRequestException("Given name value " + value + ", is not present. Please verify passing parameter.")));

    }
}

