package com.ria.rms.service.impl;

import com.ria.rms.dao.ProcRepo;
import com.ria.rms.dto.ProcDto;
import com.ria.rms.entity.Proc;
import com.ria.rms.exceptions.BadRequestException;
import com.ria.rms.exceptions.DataNotFoundException;
import com.ria.rms.mappers.ProcMapper;
import com.ria.rms.service.ProcService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProcServiceImpl implements ProcService {

    @Autowired
    private ProcRepo repo;
    @Autowired
    private ProcMapper mapper;

    @SneakyThrows
    @Override
    public List<ProcDto> findAll() {
        List<Proc> categories = repo.findAll();
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
    public ProcDto findById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        Optional<Proc> proc = repo.findById(id);
        ProcDto dto = mapper.toDto(
                proc.orElseThrow(() -> new BadRequestException("Given id " + id + ", is not present. Please verify passing parameter.")));
        return dto;
    }

    @Override
    public ProcDto save(ProcDto dto) {
        Proc proc = repo.save(mapper.fromDto(dto));
        return mapper.toDto(proc);
    }

    @Override
    public ProcDto update(ProcDto dto) {
        Proc proc = repo.save(mapper.fromDto(dto));
        return mapper.toDto(proc);
    }

    @SneakyThrows
    @Override
    public boolean deleteById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        repo.deleteById(id);
        return true;
    }

    @SneakyThrows
    public List<ProcDto> findByName(String value) {
        if (value == null || value.isEmpty()) throw new BadRequestException("Passing parameter should not be null");

        Optional<List<Proc>> aList = repo.findAllByName(value);
        return mapper.toDtoList(
                aList.orElseThrow(() -> new BadRequestException("Given email " + value + ", is not present. Please verify passing parameter.")));
    }

}
