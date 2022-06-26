package com.ria.rms.mappers;

import com.ria.rms.dto.JobCategoryDto;
import com.ria.rms.entity.JobCategory;
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
public class JobCategoryMapperImpl implements JobCategoryMapper {

    @Override
    public JobCategoryDto toDto(JobCategory jobCategory) {
        if ( jobCategory == null ) {
            return null;
        }

        JobCategoryDto jobCategoryDto = new JobCategoryDto();

        jobCategoryDto.setCreatedAt( jobCategory.getCreatedAt() );
        jobCategoryDto.setModifiedAt( jobCategory.getModifiedAt() );
        jobCategoryDto.setCreatedBy( jobCategory.getCreatedBy() );
        jobCategoryDto.setModifiedBy( jobCategory.getModifiedBy() );
        jobCategoryDto.setId( jobCategory.getId() );
        jobCategoryDto.setCode( jobCategory.getCode() );
        jobCategoryDto.setName( jobCategory.getName() );
        jobCategoryDto.setDescription( jobCategory.getDescription() );

        return jobCategoryDto;
    }

    @Override
    public JobCategory fromDto(JobCategoryDto jobCategoryDto) {
        if ( jobCategoryDto == null ) {
            return null;
        }

        JobCategory jobCategory = new JobCategory();

        jobCategory.setCreatedAt( jobCategoryDto.getCreatedAt() );
        jobCategory.setModifiedAt( jobCategoryDto.getModifiedAt() );
        jobCategory.setCreatedBy( jobCategoryDto.getCreatedBy() );
        jobCategory.setModifiedBy( jobCategoryDto.getModifiedBy() );
        jobCategory.setId( jobCategoryDto.getId() );
        jobCategory.setCode( jobCategoryDto.getCode() );
        jobCategory.setName( jobCategoryDto.getName() );
        jobCategory.setDescription( jobCategoryDto.getDescription() );

        return jobCategory;
    }

    @Override
    public List<JobCategoryDto> toDtoList(List<JobCategory> jobCategoryCollection) {
        if ( jobCategoryCollection == null ) {
            return null;
        }

        List<JobCategoryDto> list = new ArrayList<JobCategoryDto>( jobCategoryCollection.size() );
        for ( JobCategory jobCategory : jobCategoryCollection ) {
            list.add( toDto( jobCategory ) );
        }

        return list;
    }

    @Override
    public List<JobCategory> fromDtoList(List<JobCategoryDto> jobCategoryCollection) {
        if ( jobCategoryCollection == null ) {
            return null;
        }

        List<JobCategory> list = new ArrayList<JobCategory>( jobCategoryCollection.size() );
        for ( JobCategoryDto jobCategoryDto : jobCategoryCollection ) {
            list.add( fromDto( jobCategoryDto ) );
        }

        return list;
    }
}
