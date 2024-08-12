package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null unique")
    @NotEmpty(message = "Name can not be empty")
    private String name;

    @Column(columnDefinition ="varchar(20) not null unique" )
    @NotEmpty(message = "Email must not null")
    @Email(message = "Email must be valid")
    private String email;

    @Column(columnDefinition = "varchar(20) not null ")
    @NotEmpty(message = "Password must not be null")
    @Size(min = 7, message = "Password must be more than 6 characters long")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).+$", message = "Password must have characters and digits")
    private String password;

    @Column(columnDefinition = "varchar(10) not null ")
    //@Column(columnDefinition = "varchar(20) not null Check(role='JOB_SEEKER' or role='EMPLOYER')")
    @NotEmpty(message = "Role must not be null")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$", message = "Role must be either 'JOB_SEEKER' or 'EMPLOYER'")
    private String role;
}
