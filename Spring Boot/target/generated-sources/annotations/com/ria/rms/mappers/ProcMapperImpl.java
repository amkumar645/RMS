package com.ria.rms.mappers;

import com.ria.rms.dto.ProcDto;
import com.ria.rms.entity.Proc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-11T08:46:35-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.7 (AdoptOpenJDK)"
)
@Component
public class ProcMapperImpl implements ProcMapper {

    @Override
    public ProcDto toDto(Proc proc) {
        if ( proc == null ) {
            return null;
        }

        ProcDto procDto = new ProcDto();

        procDto.setCreatedAt( proc.getCreatedAt() );
        procDto.setModifiedAt( proc.getModifiedAt() );
        procDto.setCreatedBy( proc.getCreatedBy() );
        procDto.setModifiedBy( proc.getModifiedBy() );
        procDto.setId( proc.getId() );
        procDto.setCode( proc.getCode() );
        procDto.setName( proc.getName() );
        procDto.setDescription( proc.getDescription() );
        String[] stepIds = proc.getStepIds();
        if ( stepIds != null ) {
            procDto.setStepIds( Arrays.copyOf( stepIds, stepIds.length ) );
        }

        return procDto;
    }

    @Override
    public Proc fromDto(ProcDto procDto) {
        if ( procDto == null ) {
            return null;
        }

        Proc proc = new Proc();

        proc.setCreatedAt( procDto.getCreatedAt() );
        proc.setModifiedAt( procDto.getModifiedAt() );
        proc.setCreatedBy( procDto.getCreatedBy() );
        proc.setModifiedBy( procDto.getModifiedBy() );
        proc.setId( procDto.getId() );
        proc.setCode( procDto.getCode() );
        proc.setName( procDto.getName() );
        proc.setDescription( procDto.getDescription() );
        String[] stepIds = procDto.getStepIds();
        if ( stepIds != null ) {
            proc.setStepIds( Arrays.copyOf( stepIds, stepIds.length ) );
        }

        return proc;
    }

    @Override
    public List<ProcDto> toDtoList(List<Proc> procCollection) {
        if ( procCollection == null ) {
            return null;
        }

        List<ProcDto> list = new ArrayList<ProcDto>( procCollection.size() );
        for ( Proc proc : procCollection ) {
            list.add( toDto( proc ) );
        }

        return list;
    }

    @Override
    public List<Proc> fromDtoList(List<ProcDto> procCollection) {
        if ( procCollection == null ) {
            return null;
        }

        List<Proc> list = new ArrayList<Proc>( procCollection.size() );
        for ( ProcDto procDto : procCollection ) {
            list.add( fromDto( procDto ) );
        }

        return list;
    }
}
