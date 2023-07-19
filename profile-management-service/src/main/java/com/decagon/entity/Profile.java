package com.decagon.entity;

import com.decagon.config.JsonConverter;
import com.decagon.entity.pojo.*;
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
    private Long profileId;

    private Long user_id;

    @Column(name = "profile_status")
    private String profileCreationStatus;

    @Column(columnDefinition = "json")
    @Convert(converter = JsonConverter.class)
    private ContactInformation contactInformation;

    @Column(columnDefinition = "json")
    @Convert(converter = JsonConverter.class)
    private EmploymentStatus employmentStatus;

    @Column(columnDefinition = "json")
    @Convert(converter = JsonConverter.class)
    private GovernmentID governmentID;

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
