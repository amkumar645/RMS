package com.ria.rms.mappers;

import com.ria.rms.dto.JobPositionDto;
import com.ria.rms.entity.JobPosition;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-11T08:46:35-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.7 (AdoptOpenJDK)"
)
@Component
public class JobPositionMapperImpl implements JobPositionMapper {

    @Override
    public JobPositionDto toDto(JobPosition jobPosition) {
        if ( jobPosition == null ) {
            return null;
        }

        JobPositionDto jobPositionDto = new JobPositionDto();

        jobPositionDto.setCreatedAt( jobPosition.getCreatedAt() );
        jobPositionDto.setModifiedAt( jobPosition.getModifiedAt() );
        jobPositionDto.setCreatedBy( jobPosition.getCreatedBy() );
        jobPositionDto.setModifiedBy( jobPosition.getModifiedBy() );
        jobPositionDto.setId( jobPosition.getId() );
        jobPositionDto.setCode( jobPosition.getCode() );
        jobPositionDto.setName( jobPosition.getName() );
        jobPositionDto.setDescription( jobPosition.getDescription() );

        return jobPositionDto;
    }

    @Override
    public JobPosition fromDto(JobPositionDto jobPositionDto) {
        if ( jobPositionDto == null ) {
            return null;
        }

        JobPosition jobPosition = new JobPosition();

        jobPosition.setCreatedAt( jobPositionDto.getCreatedAt() );
        jobPosition.setModifiedAt( jobPositionDto.getModifiedAt() );
        jobPosition.setCreatedBy( jobPositionDto.getCreatedBy() );
        jobPosition.setModifiedBy( jobPositionDto.getModifiedBy() );
        jobPosition.setId( jobPositionDto.getId() );
        jobPosition.setCode( jobPositionDto.getCode() );
        jobPosition.setName( jobPositionDto.getName() );
        jobPosition.setDescription( jobPositionDto.getDescription() );

        return jobPosition;
    }

    @Override
    public List<JobPositionDto> toDtoList(List<JobPosition> jobPositionCollection) {
        if ( jobPositionCollection == null ) {
            return null;
        }

        List<JobPositionDto> list = new ArrayList<JobPositionDto>( jobPositionCollection.size() );
        for ( JobPosition jobPosition : jobPositionCollection ) {
            list.add( toDto( jobPosition ) );
        }

        return list;
    }

    @Override
    public List<JobPosition> fromDtoList(List<JobPositionDto> jobPositionCollection) {
        if ( jobPositionCollection == null ) {
            return null;
        }

        List<JobPosition> list = new ArrayList<JobPosition>( jobPositionCollection.size() );
        for ( JobPositionDto jobPositionDto : jobPositionCollection ) {
            list.add( fromDto( jobPositionDto ) );
        }

        return list;
    }
}
