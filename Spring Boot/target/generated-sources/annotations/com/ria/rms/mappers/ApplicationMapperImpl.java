package com.ria.rms.mappers;

import com.ria.rms.dto.ApplicationDto;
import com.ria.rms.entity.Application;
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
public class ApplicationMapperImpl implements ApplicationMapper {

    @Override
    public ApplicationDto toDto(Application application) {
        if ( application == null ) {
            return null;
        }

        ApplicationDto applicationDto = new ApplicationDto();

        applicationDto.setCreatedAt( application.getCreatedAt() );
        applicationDto.setModifiedAt( application.getModifiedAt() );
        applicationDto.setCreatedBy( application.getCreatedBy() );
        applicationDto.setModifiedBy( application.getModifiedBy() );
        applicationDto.setId( application.getId() );
        applicationDto.setAppliedDate( application.getAppliedDate() );
        applicationDto.setEducation( application.getEducation() );
        applicationDto.setExperience( application.getExperience() );
        applicationDto.setApplicantId( application.getApplicantId() );
        applicationDto.setJobId( application.getJobId() );
        applicationDto.setStatus( application.getStatus() );

        return applicationDto;
    }

    @Override
    public Application fromDto(ApplicationDto applicationDto) {
        if ( applicationDto == null ) {
            return null;
        }

        Application application = new Application();

        application.setCreatedAt( applicationDto.getCreatedAt() );
        application.setModifiedAt( applicationDto.getModifiedAt() );
        application.setCreatedBy( applicationDto.getCreatedBy() );
        application.setModifiedBy( applicationDto.getModifiedBy() );
        application.setId( applicationDto.getId() );
        application.setAppliedDate( applicationDto.getAppliedDate() );
        application.setEducation( applicationDto.getEducation() );
        application.setExperience( applicationDto.getExperience() );
        application.setApplicantId( applicationDto.getApplicantId() );
        application.setJobId( applicationDto.getJobId() );
        application.setStatus( applicationDto.getStatus() );

        return application;
    }

    @Override
    public List<ApplicationDto> toDtoList(List<Application> applicationCollection) {
        if ( applicationCollection == null ) {
            return null;
        }

        List<ApplicationDto> list = new ArrayList<ApplicationDto>( applicationCollection.size() );
        for ( Application application : applicationCollection ) {
            list.add( toDto( application ) );
        }

        return list;
    }

    @Override
    public List<Application> fromDtoList(List<ApplicationDto> applicationCollection) {
        if ( applicationCollection == null ) {
            return null;
        }

        List<Application> list = new ArrayList<Application>( applicationCollection.size() );
        for ( ApplicationDto applicationDto : applicationCollection ) {
            list.add( fromDto( applicationDto ) );
        }

        return list;
    }
}
