package com.ria.rms.service.impl;

import com.ria.rms.dao.ApplicantRepo;
import com.ria.rms.dto.ApplicantDto;
import com.ria.rms.entity.Applicant;
import com.ria.rms.exceptions.BadRequestException;
import com.ria.rms.exceptions.DataNotFoundException;
import com.ria.rms.mappers.ApplicantMapper;
import com.ria.rms.service.ApplicantService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepo repo;
    @Autowired
    private ApplicantMapper mapper;

    @SneakyThrows
    @Override
    public List<ApplicantDto> findAll() {
        List<Applicant> categories = repo.findAll();
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
    public ApplicantDto findById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        Optional<Applicant> applicant = repo.findById(id);
        ApplicantDto dto = mapper.toDto(
                applicant.orElseThrow(() -> new BadRequestException("Given id " + id + ", is not present. Please verify passing parameter.")));
        return dto;
    }

    @Override
    public ApplicantDto save(ApplicantDto dto) {
        Applicant applicant = repo.save(mapper.fromDto(dto));
        return mapper.toDto(applicant);
    }

    @Override
    public ApplicantDto update(ApplicantDto dto) {
        Applicant applicant = repo.save(mapper.fromDto(dto));
        return mapper.toDto(applicant);
    }

    @SneakyThrows
    @Override
    public boolean deleteById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        repo.deleteById(id);
        return true;
    }

    @SneakyThrows
    public List<ApplicantDto> findByEmail(String value) {
        if (value == null || value.isEmpty()) throw new BadRequestException("Passing parameter should not be null");

        Optional<List<Applicant>> aList = repo.findAllByEmail(value);
        return mapper.toDtoList(
                aList.orElseThrow(() -> new BadRequestException("Given email " + value + ", is not present. Please verify passing parameter.")));
    }

}
