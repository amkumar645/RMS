package com.ria.rms.mappers;

import com.ria.rms.dto.StepDto;
import com.ria.rms.entity.Step;
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
public class StepMapperImpl implements StepMapper {

    @Override
    public StepDto toDto(Step step) {
        if ( step == null ) {
            return null;
        }

        StepDto stepDto = new StepDto();

        stepDto.setCreatedAt( step.getCreatedAt() );
        stepDto.setModifiedAt( step.getModifiedAt() );
        stepDto.setCreatedBy( step.getCreatedBy() );
        stepDto.setModifiedBy( step.getModifiedBy() );
        stepDto.setId( step.getId() );
        stepDto.setCode( step.getCode() );
        stepDto.setName( step.getName() );
        stepDto.setDescription( step.getDescription() );

        return stepDto;
    }

    @Override
    public Step fromDto(StepDto stepDto) {
        if ( stepDto == null ) {
            return null;
        }

        Step step = new Step();

        step.setCreatedAt( stepDto.getCreatedAt() );
        step.setModifiedAt( stepDto.getModifiedAt() );
        step.setCreatedBy( stepDto.getCreatedBy() );
        step.setModifiedBy( stepDto.getModifiedBy() );
        step.setId( stepDto.getId() );
        step.setCode( stepDto.getCode() );
        step.setName( stepDto.getName() );
        step.setDescription( stepDto.getDescription() );

        return step;
    }

    @Override
    public List<StepDto> toDtoList(List<Step> stepCollection) {
        if ( stepCollection == null ) {
            return null;
        }

        List<StepDto> list = new ArrayList<StepDto>( stepCollection.size() );
        for ( Step step : stepCollection ) {
            list.add( toDto( step ) );
        }

        return list;
    }

    @Override
    public List<Step> fromDtoList(List<StepDto> stepCollection) {
        if ( stepCollection == null ) {
            return null;
        }

        List<Step> list = new ArrayList<Step>( stepCollection.size() );
        for ( StepDto stepDto : stepCollection ) {
            list.add( fromDto( stepDto ) );
        }

        return list;
    }
}
