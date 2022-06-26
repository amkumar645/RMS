package com.ria.rms.mappers;

import com.ria.rms.dto.JobDto;
import com.ria.rms.entity.Job;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {

    JobDto toDto(Job job);

    Job fromDto(JobDto jobDto);

    List<JobDto> toDtoList(List<Job> jobCollection);

    List<Job> fromDtoList(List<JobDto> jobCollection);

}
