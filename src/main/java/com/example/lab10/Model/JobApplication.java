package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Application")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null unique")
    @NotNull(message = "userId can not be null")
    private Integer userId;

    @Column(columnDefinition = "int not null unique")
    @NotNull(message = "job Pos tId can not be null")
    private Integer jobPostId;
}
