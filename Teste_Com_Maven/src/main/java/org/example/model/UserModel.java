package org.example.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class UserModel {
    private int code;
    private String userName;
    private LocalDate birthday;
}
