package com.easyLend.userservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "otp")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VerificationEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String otp;
    private LocalDateTime localDateTime;
    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

}
