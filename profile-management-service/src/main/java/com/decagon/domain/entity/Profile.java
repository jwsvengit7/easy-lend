package com.decagon.domain.entity;

import com.decagon.domain.screen.converter.JsonConverter;
import com.decagon.domain.constant.ProfileStatus;
import com.decagon.domain.screen.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProfileStatus status;

    @Column(columnDefinition = "json")
    @Convert(converter = JsonConverter.class)
    private ContactInformation contactInformation;

    @Column(columnDefinition = "json")
    @Convert(converter = JsonConverter.class)
    private EmploymentStatus employmentStatus;

    @Column(columnDefinition = "json")
    @Convert(converter = JsonConverter.class)
    private GovernmentID governmentId;

    @Column(columnDefinition = "json")
    @Convert(converter = JsonConverter.class)
    private IncomeStatus incomeStatus;

    @Column(columnDefinition = "json")
    @Convert(converter = JsonConverter.class)
    private ProofOfAddress proofOfAddress;

    @Column(columnDefinition = "json")
    @Convert(converter = JsonConverter.class)
    private BankAccount bankAccount;
}
