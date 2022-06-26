package com.ria.rms.mappers;

import com.ria.rms.dto.ProcDto;
import com.ria.rms.entity.Proc;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProcMapper {
    ProcDto toDto(Proc proc);

    Proc fromDto(ProcDto procDto);

    List<ProcDto> toDtoList(List<Proc> procCollection);

    List<Proc> fromDtoList(List<ProcDto> procCollection);
}
