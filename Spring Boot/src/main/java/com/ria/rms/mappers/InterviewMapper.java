package com.ria.rms.mappers;

import com.ria.rms.dto.InterviewDto;
import com.ria.rms.entity.Interview;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InterviewMapper {
    InterviewDto toDto(Interview interview);

    Interview fromDto(InterviewDto interviewDto);

    List<InterviewDto> toDtoList(List<Interview> interviewCollection);

    List<Interview> fromDtoList(List<InterviewDto> interviewCollection);

}
