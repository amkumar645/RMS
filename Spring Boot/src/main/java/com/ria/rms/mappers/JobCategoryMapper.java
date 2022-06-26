package com.ria.rms.mappers;

import com.ria.rms.dto.JobCategoryDto;
import com.ria.rms.entity.JobCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobCategoryMapper {

    JobCategoryDto toDto(JobCategory jobCategory);

    JobCategory fromDto(JobCategoryDto jobCategoryDto);

    List<JobCategoryDto> toDtoList(List<JobCategory> jobCategoryCollection);

    List<JobCategory> fromDtoList(List<JobCategoryDto> jobCategoryCollection);

}
