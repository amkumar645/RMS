package com.ria.rms.service.impl;

import com.ria.rms.dao.FeedbackRepo;
import com.ria.rms.dto.FeedbackDto;
import com.ria.rms.entity.Feedback;
import com.ria.rms.exceptions.BadRequestException;
import com.ria.rms.exceptions.DataNotFoundException;
import com.ria.rms.mappers.FeedbackMapper;
import com.ria.rms.service.FeedbackService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepo repo;
    @Autowired
    private FeedbackMapper mapper;

    @SneakyThrows
    @Override
    public List<FeedbackDto> findAll() {
        List<Feedback> categories = repo.findAll();
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
    public FeedbackDto findById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        Optional<Feedback> feedback = repo.findById(id);
        FeedbackDto dto = mapper.toDto(
                feedback.orElseThrow(() -> new BadRequestException("Given id " + id + ", is not present. Please verify passing parameter.")));
        return dto;
    }

    @Override
    public FeedbackDto save(FeedbackDto dto) {
        Feedback feedback = repo.save(mapper.fromDto(dto));
        return mapper.toDto(feedback);
    }

    @Override
    public FeedbackDto update(FeedbackDto dto) {
        Feedback feedback = repo.save(mapper.fromDto(dto));
        return mapper.toDto(feedback);
    }

    @SneakyThrows
    @Override
    public boolean deleteById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        repo.deleteById(id);
        return true;
    }
}

