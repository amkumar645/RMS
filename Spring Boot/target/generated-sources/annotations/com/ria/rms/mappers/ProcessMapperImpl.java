package com.ria.rms.mappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-10T15:40:47-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.7 (AdoptOpenJDK)"
)
@Component
public class ProcessMapperImpl implements ProcessMapper {

    @Override
    public ProcessDto toDto(Process process) {
        if ( process == null ) {
            return null;
        }

        ProcessDto processDto = new ProcessDto();

        processDto.setCreatedAt( process.getCreatedAt() );
        processDto.setModifiedAt( process.getModifiedAt() );
        processDto.setCreatedBy( process.getCreatedBy() );
        processDto.setModifiedBy( process.getModifiedBy() );
        processDto.setId( process.getId() );
        processDto.setCode( process.getCode() );
        processDto.setName( process.getName() );
        processDto.setDescription( process.getDescription() );
        String[] stepIds = process.getStepIds();
        if ( stepIds != null ) {
            processDto.setStepIds( Arrays.copyOf( stepIds, stepIds.length ) );
        }

        return processDto;
    }

    @Override
    public Process fromDto(ProcessDto processDto) {
        if ( processDto == null ) {
            return null;
        }

        Process process = new Process();

        process.setCreatedAt( processDto.getCreatedAt() );
        process.setModifiedAt( processDto.getModifiedAt() );
        process.setCreatedBy( processDto.getCreatedBy() );
        process.setModifiedBy( processDto.getModifiedBy() );
        process.setId( processDto.getId() );
        process.setCode( processDto.getCode() );
        process.setName( processDto.getName() );
        process.setDescription( processDto.getDescription() );
        String[] stepIds = processDto.getStepIds();
        if ( stepIds != null ) {
            process.setStepIds( Arrays.copyOf( stepIds, stepIds.length ) );
        }

        return process;
    }

    @Override
    public List<ProcessDto> toDtoList(List<Process> processCollection) {
        if ( processCollection == null ) {
            return null;
        }

        List<ProcessDto> list = new ArrayList<ProcessDto>( processCollection.size() );
        for ( Process process : processCollection ) {
            list.add( toDto( process ) );
        }

        return list;
    }

    @Override
    public List<Process> fromDtoList(List<ProcessDto> processCollection) {
        if ( processCollection == null ) {
            return null;
        }

        List<Process> list = new ArrayList<Process>( processCollection.size() );
        for ( ProcessDto processDto : processCollection ) {
            list.add( fromDto( processDto ) );
        }

        return list;
    }
}
