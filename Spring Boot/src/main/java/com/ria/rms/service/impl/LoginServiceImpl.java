package com.ria.rms.service.impl;

import com.ria.rms.dao.LoginRepo;
import com.ria.rms.dto.LoginDto;
import com.ria.rms.entity.Login;
import com.ria.rms.exceptions.BadRequestException;
import com.ria.rms.exceptions.DataNotFoundException;
import com.ria.rms.mappers.LoginMapper;
import com.ria.rms.service.LoginService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepo repo;
    @Autowired
    private LoginMapper mapper;

    @SneakyThrows
    @Override
    public List<LoginDto> findAll() {
        List<Login> categories = repo.findAll();
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
    public LoginDto findById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        Optional<Login> login = repo.findById(id);
        LoginDto dto = mapper.toDto(
                login.orElseThrow(() -> new BadRequestException("Given id " + id + ", is not present. Please verify passing parameter.")));
        return dto;
    }

    @Override
    public LoginDto save(LoginDto dto) {
        Login login = repo.save(mapper.fromDto(dto));
        return mapper.toDto(login);
    }

    @Override
    public LoginDto update(LoginDto dto) {
        Login login = repo.save(mapper.fromDto(dto));
        return mapper.toDto(login);
    }

    @SneakyThrows
    @Override
    public boolean deleteById(String id) {
        if (id == null || id.isEmpty()) throw new BadRequestException("Passing parameter should not be null");
        repo.deleteById(id);
        return true;
    }
}
