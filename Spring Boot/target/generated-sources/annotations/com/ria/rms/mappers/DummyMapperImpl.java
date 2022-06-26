package com.ria.rms.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-30T15:36:31-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.7 (AdoptOpenJDK)"
)
@Component
public class DummyMapperImpl implements DummyMapper {

    @Override
    public DummyDto toDto(Dummy dummy) {
        if ( dummy == null ) {
            return null;
        }

        DummyDto dummyDto = new DummyDto();

        dummyDto.setCreatedAt( dummy.getCreatedAt() );
        dummyDto.setModifiedAt( dummy.getModifiedAt() );
        dummyDto.setCreatedBy( dummy.getCreatedBy() );
        dummyDto.setModifiedBy( dummy.getModifiedBy() );
        dummyDto.setId( dummy.getId() );

        return dummyDto;
    }

    @Override
    public Dummy fromDto(DummyDto dummyDto) {
        if ( dummyDto == null ) {
            return null;
        }

        Dummy dummy = new Dummy();

        dummy.setCreatedAt( dummyDto.getCreatedAt() );
        dummy.setModifiedAt( dummyDto.getModifiedAt() );
        dummy.setCreatedBy( dummyDto.getCreatedBy() );
        dummy.setModifiedBy( dummyDto.getModifiedBy() );
        dummy.setId( dummyDto.getId() );

        return dummy;
    }

    @Override
    public List<DummyDto> toDtoList(List<Dummy> dummyCollection) {
        if ( dummyCollection == null ) {
            return null;
        }

        List<DummyDto> list = new ArrayList<DummyDto>( dummyCollection.size() );
        for ( Dummy dummy : dummyCollection ) {
            list.add( toDto( dummy ) );
        }

        return list;
    }

    @Override
    public List<Dummy> fromDtoList(List<DummyDto> dummyCollection) {
        if ( dummyCollection == null ) {
            return null;
        }

        List<Dummy> list = new ArrayList<Dummy>( dummyCollection.size() );
        for ( DummyDto dummyDto : dummyCollection ) {
            list.add( fromDto( dummyDto ) );
        }

        return list;
    }
}
