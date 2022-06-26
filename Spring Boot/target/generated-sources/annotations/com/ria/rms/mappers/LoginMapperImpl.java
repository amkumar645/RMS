package com.ria.rms.mappers;

import com.ria.rms.dto.LoginDto;
import com.ria.rms.entity.Login;
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
public class LoginMapperImpl implements LoginMapper {

    @Override
    public LoginDto toDto(Login jobPosition) {
        if ( jobPosition == null ) {
            return null;
        }

        LoginDto loginDto = new LoginDto();

        loginDto.setId( jobPosition.getId() );
        loginDto.setPassword( jobPosition.getPassword() );

        return loginDto;
    }

    @Override
    public Login fromDto(LoginDto jobPositionDto) {
        if ( jobPositionDto == null ) {
            return null;
        }

        Login login = new Login();

        login.setId( jobPositionDto.getId() );
        login.setPassword( jobPositionDto.getPassword() );

        return login;
    }

    @Override
    public List<LoginDto> toDtoList(List<Login> jobPositionCollection) {
        if ( jobPositionCollection == null ) {
            return null;
        }

        List<LoginDto> list = new ArrayList<LoginDto>( jobPositionCollection.size() );
        for ( Login login : jobPositionCollection ) {
            list.add( toDto( login ) );
        }

        return list;
    }

    @Override
    public List<Login> fromDtoList(List<LoginDto> jobPositionCollection) {
        if ( jobPositionCollection == null ) {
            return null;
        }

        List<Login> list = new ArrayList<Login>( jobPositionCollection.size() );
        for ( LoginDto loginDto : jobPositionCollection ) {
            list.add( fromDto( loginDto ) );
        }

        return list;
    }
}
