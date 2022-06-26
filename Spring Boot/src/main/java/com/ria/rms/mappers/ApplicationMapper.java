package com.ria.rms.mappers;

import com.ria.rms.dto.ApplicationDto;
import com.ria.rms.entity.Application;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    ApplicationDto toDto(Application application);

    Application fromDto(ApplicationDto applicationDto);

    List<ApplicationDto> toDtoList(List<Application> applicationCollection);

    List<Application> fromDtoList(List<ApplicationDto> applicationCollection);

}
