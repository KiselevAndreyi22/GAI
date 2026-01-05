package com.example.GAI.model.documentModel;
import com.example.GAI.model.userModel.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@Table(name = "pasports")
@NoArgsConstructor
@AllArgsConstructor
public class Pasport {

    @Id
    private Long id;

    @OneToOne
    @MapsId
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

    @Column(name = "seriaNumber", unique = true)
    private String seriaNumber;

    @Column(name = "region", nullable = false)
    private String region;
}
