package com.ria.rms.mappers;

import com.ria.rms.dto.ApplicantDto;
import com.ria.rms.entity.Applicant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicantMapper {
    ApplicantDto toDto(Applicant applicant);

    Applicant fromDto(ApplicantDto applicantDto);

    List<ApplicantDto> toDtoList(List<Applicant> applicantCollection);

    List<Applicant> fromDtoList(List<ApplicantDto> applicantCollection);

}
