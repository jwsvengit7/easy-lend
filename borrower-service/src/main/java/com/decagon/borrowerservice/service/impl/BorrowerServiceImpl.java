package com.decagon.borrowerservice.service.impl;

import com.decagon.borrowerservice.dto.LoanDto;
import com.decagon.borrowerservice.entities.Loan;
import com.decagon.borrowerservice.repository.LoanRepository;
import com.decagon.borrowerservice.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final ModelMapper modelMapper;

    @Override
    public LoanDto loanRequest(LoanDto loanDto) {
        // Loan application validation
        if (loanDto.getLoanAmt() <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero");
        }
        if (loanDto.getInterestRate() <= 0 || loanDto.getInterestRate() > 100) {
            throw new IllegalArgumentException("Invalid interest rate");
        }
        if (loanDto.getRepaymentTerm() <= 0) {
            throw new IllegalArgumentException("Repayment term must be greater than zero");
        }

        // Calculating the total repayment amount
        double totalRepayment = loanDto.getLoanAmt() * (1 + loanDto.getInterestRate() / 100);

        // Set the total repayment amount in the loanDto object
        loanDto.setTotalRepayment(totalRepayment);

        // Map LoanDto to Loan entity and save it
        Loan loan = modelMapper.map(loanDto, Loan.class);
        Loan savedLoan = loanRepository.save(loan);

        // Map the saved Loan entity back to LoanDto and return it
        return new LoanDto(savedLoan);
    }
}