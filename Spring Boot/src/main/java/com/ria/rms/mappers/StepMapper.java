package com.ria.rms.mappers;

import com.ria.rms.dto.StepDto;
import com.ria.rms.entity.Step;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StepMapper {
    StepDto toDto(Step step);

    Step fromDto(StepDto stepDto);

    List<StepDto> toDtoList(List<Step> stepCollection);

    List<Step> fromDtoList(List<StepDto> stepCollection);

}
