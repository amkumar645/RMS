package com.ria.rms.mappers;

import com.ria.rms.dto.InterviewDto;
import com.ria.rms.entity.Interview;
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
public class InterviewMapperImpl implements InterviewMapper {

    @Override
    public InterviewDto toDto(Interview interview) {
        if ( interview == null ) {
            return null;
        }

        InterviewDto interviewDto = new InterviewDto();

        interviewDto.setId( interview.getId() );
        interviewDto.setApplicationId( interview.getApplicationId() );
        interviewDto.setProcessId( interview.getProcessId() );
        interviewDto.setJobId( interview.getJobId() );

        return interviewDto;
    }

    @Override
    public Interview fromDto(InterviewDto interviewDto) {
        if ( interviewDto == null ) {
            return null;
        }

        Interview interview = new Interview();

        interview.setId( interviewDto.getId() );
        interview.setApplicationId( interviewDto.getApplicationId() );
        interview.setProcessId( interviewDto.getProcessId() );
        interview.setJobId( interviewDto.getJobId() );

        return interview;
    }

    @Override
    public List<InterviewDto> toDtoList(List<Interview> interviewCollection) {
        if ( interviewCollection == null ) {
            return null;
        }

        List<InterviewDto> list = new ArrayList<InterviewDto>( interviewCollection.size() );
        for ( Interview interview : interviewCollection ) {
            list.add( toDto( interview ) );
        }

        return list;
    }

    @Override
    public List<Interview> fromDtoList(List<InterviewDto> interviewCollection) {
        if ( interviewCollection == null ) {
            return null;
        }

        List<Interview> list = new ArrayList<Interview>( interviewCollection.size() );
        for ( InterviewDto interviewDto : interviewCollection ) {
            list.add( fromDto( interviewDto ) );
        }

        return list;
    }
}
