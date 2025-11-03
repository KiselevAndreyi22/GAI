package com.example.GAI.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Builder
@Table(name = "pasports")
@NoArgsConstructor
@AllArgsConstructor
public class Pasport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "birthday", nullable = false)
    private LocalDate dateOfBirthday;

    @Column(name = "seriaNumber", unique = true, nullable = false)
    private Long seriaNumber;
}
