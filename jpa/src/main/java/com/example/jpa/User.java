package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "jpa_user")
@Getter@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 데이터베이스에 위임
    // @Column(name="user_id")
    private Long id;
    private String name;
    private String email;

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
}
