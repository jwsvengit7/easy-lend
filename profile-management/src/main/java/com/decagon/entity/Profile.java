package com.decagon.entity;

import com.decagon.enums.UserType;
import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profile_id;

    //user id will be mapped here as foreign key

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_information_id")
    private ContactInformation contactInformation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employment_status_id")
    private EmploymentStatus employmentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "government_id_id")
    private GovernmentID governmentID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "income_status_id")
    private IncomeStatus incomeStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proof_of_address_id")
    private ProofOfAddress proofOfAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "linked_bank_account_id")
    private LinkedBankAccount linkedBankAccount;
}
