package com.decagon.entity;

import com.decagon.config.JsonConverter;
import com.decagon.entity.pojo.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;

    private String profileStatus;

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

    public Profile(Long id, Long user_id, String profileStatus, ContactInformation contactInformation,
                   EmploymentStatus employmentStatus, GovernmentID governmentID,
                   IncomeStatus incomeStatus, ProofOfAddress proofOfAddress,
                   BankAccount bankAccount) {
        this.id = id;
        this.user_id = user_id;
        this.profileStatus = "new";
        this.contactInformation = contactInformation;
        this.employmentStatus = employmentStatus;
        this.governmentID = governmentID;
        this.incomeStatus = incomeStatus;
        this.proofOfAddress = proofOfAddress;
        this.bankAccount = bankAccount;
    }
}
