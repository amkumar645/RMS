package com.ria.rms.mappers;

import com.ria.rms.dto.JobPositionDto;
import com.ria.rms.entity.JobPosition;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobPositionMapper {

    JobPositionDto toDto(JobPosition jobPosition);

    JobPosition fromDto(JobPositionDto jobPositionDto);

    List<JobPositionDto> toDtoList(List<JobPosition> jobPositionCollection);

    List<JobPosition> fromDtoList(List<JobPositionDto> jobPositionCollection);

}
