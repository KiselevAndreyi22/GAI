package com.example.GAI.model.documentModel;

import com.example.GAI.model.userModel.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Entity
@Builder
@Table(name = "snils")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Snils {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    User user;

    @Column(name = "number", length = 11, unique = true)
    String number;
}
