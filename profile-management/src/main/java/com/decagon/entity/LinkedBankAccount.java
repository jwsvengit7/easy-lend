package com.decagon.entity;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "linked_bank_accounts")
public class LinkedBankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank")
    private String bank;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_name")
    private String accountName;

    public LinkedBankAccount(String bank, String accountNumber) {
        this.bank = bank;
        this.accountNumber = accountNumber;
    }
}