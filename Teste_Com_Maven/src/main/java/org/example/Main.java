package org.example;

import org.example.dto.UserDTO;
import org.example.mapper.UserMapper;
import org.example.model.UserModel;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

public class Main {
    private final static UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public static void main(String[] args) {

        var user1 = new UserModel(1, "Nathan", LocalDate.now().minusYears(22));
        var user2 = new UserDTO();
        user2.setId(2);
        user2.setName("Julia");
        user2.setBirthday(LocalDate.now().minusYears(22));

        System.out.println(mapper.toDTO(user1));
        System.out.println(mapper.toModel(user2));
    }
}