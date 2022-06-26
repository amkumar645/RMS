package com.ria.rms.mappers;

import com.ria.rms.dto.FeedbackDto;
import com.ria.rms.entity.Feedback;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    FeedbackDto toDto(Feedback feedback);

    Feedback fromDto(FeedbackDto feedbackDto);

    List<FeedbackDto> toDtoList(List<Feedback> feedbackCollection);

    List<Feedback> fromDtoList(List<FeedbackDto> feedbackCollection);
}
