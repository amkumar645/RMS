package com.ria.rms.mappers;

import com.ria.rms.dto.FeedbackDto;
import com.ria.rms.entity.Feedback;
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
public class FeedbackMapperImpl implements FeedbackMapper {

    @Override
    public FeedbackDto toDto(Feedback feedback) {
        if ( feedback == null ) {
            return null;
        }

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setId( feedback.getId() );
        feedbackDto.setDate( feedback.getDate() );
        feedbackDto.setStartTime( feedback.getStartTime() );
        feedbackDto.setEndTime( feedback.getEndTime() );
        feedbackDto.setInterviewer( feedback.getInterviewer() );
        feedbackDto.setComments( feedback.getComments() );
        feedbackDto.setNotes( feedback.getNotes() );
        feedbackDto.setInterviewId( feedback.getInterviewId() );

        return feedbackDto;
    }

    @Override
    public Feedback fromDto(FeedbackDto feedbackDto) {
        if ( feedbackDto == null ) {
            return null;
        }

        Feedback feedback = new Feedback();

        feedback.setId( feedbackDto.getId() );
        feedback.setDate( feedbackDto.getDate() );
        feedback.setStartTime( feedbackDto.getStartTime() );
        feedback.setEndTime( feedbackDto.getEndTime() );
        feedback.setInterviewer( feedbackDto.getInterviewer() );
        feedback.setComments( feedbackDto.getComments() );
        feedback.setNotes( feedbackDto.getNotes() );
        feedback.setInterviewId( feedbackDto.getInterviewId() );

        return feedback;
    }

    @Override
    public List<FeedbackDto> toDtoList(List<Feedback> feedbackCollection) {
        if ( feedbackCollection == null ) {
            return null;
        }

        List<FeedbackDto> list = new ArrayList<FeedbackDto>( feedbackCollection.size() );
        for ( Feedback feedback : feedbackCollection ) {
            list.add( toDto( feedback ) );
        }

        return list;
    }

    @Override
    public List<Feedback> fromDtoList(List<FeedbackDto> feedbackCollection) {
        if ( feedbackCollection == null ) {
            return null;
        }

        List<Feedback> list = new ArrayList<Feedback>( feedbackCollection.size() );
        for ( FeedbackDto feedbackDto : feedbackCollection ) {
            list.add( fromDto( feedbackDto ) );
        }

        return list;
    }
}
