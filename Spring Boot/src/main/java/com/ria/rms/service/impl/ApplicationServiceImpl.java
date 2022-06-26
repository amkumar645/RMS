package com.ria.rms.service.impl;

import com.ria.rms.dao.ApplicationRepo;
import com.ria.rms.dto.ApplicationDto;
import com.ria.rms.entity.Application;
import com.ria.rms.exceptions.BadRequestException;
import com.ria.rms.exceptions.DataNotFoundException;
import com.ria.rms.mappers.ApplicationMapper;
import com.ria.rms.service.ApplicationService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepo repo;
    @Autowired
    private ApplicationMapper mapper;

    @SneakyThrows
    @Override
    public List<ApplicationDto> findAll() {
        List<Application> categories = repo.findAll();
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
    public ApplicationDto findById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        Optional<Application> application = repo.findById(id);
        ApplicationDto dto = mapper.toDto(
                application.orElseThrow(() -> new BadRequestException("Given id " + id + ", is not present. Please verify passing parameter.")));
        return dto;
    }

    @Override
    public ApplicationDto save(ApplicationDto dto) {
        Application application = repo.save(mapper.fromDto(dto));
        return mapper.toDto(application);
    }

    @Override
    public ApplicationDto update(ApplicationDto dto) {
        Application application = repo.save(mapper.fromDto(dto));
        return mapper.toDto(application);
    }

    @SneakyThrows
    @Override
    public boolean deleteById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        repo.deleteById(id);
        return true;
    }

    @SneakyThrows
    public List<ApplicationDto> findByJobId(String value) {
        if (value == null || value.isEmpty()) throw new BadRequestException("Passing parameter should not be null");

        Optional<List<Application>> aList = repo.findAllByJobId(value);
        return mapper.toDtoList(
                aList.orElseThrow(() -> new BadRequestException("Given id " + value + ", is not present. Please verify passing parameter.")));
    }

    @SneakyThrows
    public List<ApplicationDto> findByApplicantId(String value) {
        if (value == null || value.isEmpty()) throw new BadRequestException("Passing parameter should not be null");

        Optional<List<Application>> aList = repo.findAllByApplicantId(value);
        return mapper.toDtoList(
                aList.orElseThrow(() -> new BadRequestException("Given id " + value + ", is not present. Please verify passing parameter.")));
    }

}
