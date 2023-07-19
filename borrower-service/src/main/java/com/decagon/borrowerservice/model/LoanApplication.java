package com.decagon.borrowerservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "LoanApplication")

public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int applicationId;
    private int userId;
    private int loanId;
    private Date applicationDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
