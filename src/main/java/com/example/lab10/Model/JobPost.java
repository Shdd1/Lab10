package com.example.lab10.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Job")
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null ")
    @NotNull(message = "title can not be null")
    @Length(min = 5,message = "Length must be more than 4")
    private String title;

    @Column(columnDefinition = "varchar(50) not null ")
    @NotNull(message = "description can not be null")
    private String description;

    @Column(columnDefinition = "varchar(50) not null ")
    @NotNull(message = "location can not be null")
    private String location;

    @Column(columnDefinition = "int not null ")
    @NotNull(message = "salary can not be null")
    @Positive(message = "salary must be positive number")
    private int salary;

    @Column(columnDefinition = "Datetime not null")
    @NotNull(message = "can not be null")
    @FutureOrPresent(message = "should be a date in the Future Or Present ")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date postingDate;
}
