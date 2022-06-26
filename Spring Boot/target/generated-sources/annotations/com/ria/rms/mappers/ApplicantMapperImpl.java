package com.ria.rms.mappers;

import com.ria.rms.dto.ApplicantDto;
import com.ria.rms.entity.Applicant;
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
public class ApplicantMapperImpl implements ApplicantMapper {

    @Override
    public ApplicantDto toDto(Applicant applicant) {
        if ( applicant == null ) {
            return null;
        }

        ApplicantDto applicantDto = new ApplicantDto();

        applicantDto.setCreatedAt( applicant.getCreatedAt() );
        applicantDto.setModifiedAt( applicant.getModifiedAt() );
        applicantDto.setCreatedBy( applicant.getCreatedBy() );
        applicantDto.setModifiedBy( applicant.getModifiedBy() );
        applicantDto.setId( applicant.getId() );
        applicantDto.setFirstName( applicant.getFirstName() );
        applicantDto.setLastName( applicant.getLastName() );
        applicantDto.setEmail( applicant.getEmail() );
        applicantDto.setPhone( applicant.getPhone() );
        applicantDto.setSummary( applicant.getSummary() );
        String[] documentIds = applicant.getDocumentIds();
        if ( documentIds != null ) {
            applicantDto.setDocumentIds( Arrays.copyOf( documentIds, documentIds.length ) );
        }

        return applicantDto;
    }

    @Override
    public Applicant fromDto(ApplicantDto applicantDto) {
        if ( applicantDto == null ) {
            return null;
        }

        Applicant applicant = new Applicant();

        applicant.setCreatedAt( applicantDto.getCreatedAt() );
        applicant.setModifiedAt( applicantDto.getModifiedAt() );
        applicant.setCreatedBy( applicantDto.getCreatedBy() );
        applicant.setModifiedBy( applicantDto.getModifiedBy() );
        applicant.setId( applicantDto.getId() );
        applicant.setFirstName( applicantDto.getFirstName() );
        applicant.setLastName( applicantDto.getLastName() );
        applicant.setEmail( applicantDto.getEmail() );
        applicant.setPhone( applicantDto.getPhone() );
        applicant.setSummary( applicantDto.getSummary() );
        String[] documentIds = applicantDto.getDocumentIds();
        if ( documentIds != null ) {
            applicant.setDocumentIds( Arrays.copyOf( documentIds, documentIds.length ) );
        }

        return applicant;
    }

    @Override
    public List<ApplicantDto> toDtoList(List<Applicant> applicantCollection) {
        if ( applicantCollection == null ) {
            return null;
        }

        List<ApplicantDto> list = new ArrayList<ApplicantDto>( applicantCollection.size() );
        for ( Applicant applicant : applicantCollection ) {
            list.add( toDto( applicant ) );
        }

        return list;
    }

    @Override
    public List<Applicant> fromDtoList(List<ApplicantDto> applicantCollection) {
        if ( applicantCollection == null ) {
            return null;
        }

        List<Applicant> list = new ArrayList<Applicant>( applicantCollection.size() );
        for ( ApplicantDto applicantDto : applicantCollection ) {
            list.add( fromDto( applicantDto ) );
        }

        return list;
    }
}
