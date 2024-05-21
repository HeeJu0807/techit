package org.example.jdbc01;

import lombok.*;

//롬복!!
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자를 자동으로 생성
@Getter
@ToString
//@NoArgsConstructor   // 파라미터가 없는 기본 생성자를 자동으로 생성
//@Setter
public class User{
    private Long id;
    private String name;
    private String email;
}