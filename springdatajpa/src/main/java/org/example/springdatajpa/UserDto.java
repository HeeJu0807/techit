package org.example.springdatajpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private String email;
}
