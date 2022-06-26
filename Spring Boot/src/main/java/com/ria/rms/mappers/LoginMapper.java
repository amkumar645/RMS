package com.ria.rms.mappers;

import com.ria.rms.dto.LoginDto;
import com.ria.rms.entity.Login;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoginMapper {
    LoginDto toDto(Login jobPosition);

    Login fromDto(LoginDto jobPositionDto);

    List<LoginDto> toDtoList(List<Login> jobPositionCollection);

    List<Login> fromDtoList(List<LoginDto> jobPositionCollection);

}
