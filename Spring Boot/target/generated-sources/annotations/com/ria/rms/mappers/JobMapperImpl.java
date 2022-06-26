package com.ria.rms.mappers;

import com.ria.rms.dto.JobDto;
import com.ria.rms.entity.Job;
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
public class JobMapperImpl implements JobMapper {

    @Override
    public JobDto toDto(Job job) {
        if ( job == null ) {
            return null;
        }

        JobDto jobDto = new JobDto();

        jobDto.setCreatedAt( job.getCreatedAt() );
        jobDto.setModifiedAt( job.getModifiedAt() );
        jobDto.setCreatedBy( job.getCreatedBy() );
        jobDto.setModifiedBy( job.getModifiedBy() );
        jobDto.setId( job.getId() );
        jobDto.setCode( job.getCode() );
        jobDto.setName( job.getName() );
        jobDto.setDescription( job.getDescription() );
        jobDto.setNoOfVacancies( job.getNoOfVacancies() );
        jobDto.setJobCategoryId( job.getJobCategoryId() );
        jobDto.setProcessId( job.getProcessId() );
        jobDto.setJobPositionId( job.getJobPositionId() );

        return jobDto;
    }

    @Override
    public Job fromDto(JobDto jobDto) {
        if ( jobDto == null ) {
            return null;
        }

        Job job = new Job();

        job.setCreatedAt( jobDto.getCreatedAt() );
        job.setModifiedAt( jobDto.getModifiedAt() );
        job.setCreatedBy( jobDto.getCreatedBy() );
        job.setModifiedBy( jobDto.getModifiedBy() );
        job.setId( jobDto.getId() );
        job.setCode( jobDto.getCode() );
        job.setName( jobDto.getName() );
        job.setDescription( jobDto.getDescription() );
        job.setNoOfVacancies( jobDto.getNoOfVacancies() );
        job.setJobCategoryId( jobDto.getJobCategoryId() );
        job.setProcessId( jobDto.getProcessId() );
        job.setJobPositionId( jobDto.getJobPositionId() );

        return job;
    }

    @Override
    public List<JobDto> toDtoList(List<Job> jobCollection) {
        if ( jobCollection == null ) {
            return null;
        }

        List<JobDto> list = new ArrayList<JobDto>( jobCollection.size() );
        for ( Job job : jobCollection ) {
            list.add( toDto( job ) );
        }

        return list;
    }

    @Override
    public List<Job> fromDtoList(List<JobDto> jobCollection) {
        if ( jobCollection == null ) {
            return null;
        }

        List<Job> list = new ArrayList<Job>( jobCollection.size() );
        for ( JobDto jobDto : jobCollection ) {
            list.add( fromDto( jobDto ) );
        }

        return list;
    }
}
