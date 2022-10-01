package br.com.fiap.epictaskapi.mappers;

import br.com.fiap.epictaskapi.dto.RegistryUserDto;
import br.com.fiap.epictaskapi.dto.SearchUserDto;
import br.com.fiap.epictaskapi.model.User;

public class UserMapper {

    public static User fromDTO(RegistryUserDto dto){
        return new User(dto.getName(), dto.getEmail(), dto.getPassword());
    }

    public static User fromSearchDTO(SearchUserDto dto){
        return new User(dto.getName(), dto.getEmail(), null);
    }

    public static SearchUserDto fromEntity(User user){
        return new SearchUserDto(
                user.getName(),
                user.getEmail()
        );
    }
}
