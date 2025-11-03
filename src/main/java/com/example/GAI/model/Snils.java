package com.example.GAI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "snils")
@NoArgsConstructor
@AllArgsConstructor
public class Snils {
    @Id
    @Column(name = "number")
    private Long number;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;
}
