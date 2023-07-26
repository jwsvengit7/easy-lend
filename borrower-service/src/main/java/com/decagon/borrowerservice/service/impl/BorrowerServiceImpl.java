package com.decagon.borrowerservice.service.impl;

import com.decagon.borrowerservice.dto.BorrowerDto;
import com.decagon.borrowerservice.entities.Borrower;
import com.decagon.borrowerservice.repository.BorrowerRepository;
import com.decagon.borrowerservice.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {

    private final BorrowerRepository borrowerRepository;
    private final ModelMapper modelMapper;

    @Override
    public BorrowerDto loanRequest(BorrowerDto borrowerDto) {
        // Loan application validation
        if (borrowerDto.getLoanAmt() <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero");
        }
        if (borrowerDto.getInterestRate() <= 0 || borrowerDto.getInterestRate() > 100) {
            throw new IllegalArgumentException("Invalid interest rate");
        }
        if (borrowerDto.getRepaymentTerm() <= 0) {
            throw new IllegalArgumentException("Repayment term must be greater than zero");
        }

        // Calculating the total repayment amount
        double totalRepayment = borrowerDto.getLoanAmt() * (1 + borrowerDto.getInterestRate() / 100);

        // Set the total repayment amount in the loanDto object
        borrowerDto.setTotalRepayment(totalRepayment);

        // Map LoanDto to Loan entity and save it
        Borrower borrower = modelMapper.map(borrowerDto, Borrower.class);
        Borrower savedBorrower = borrowerRepository.save(borrower);

        // Map the saved Loan entity back to LoanDto and return it
        return new BorrowerDto(savedBorrower);
    }
}