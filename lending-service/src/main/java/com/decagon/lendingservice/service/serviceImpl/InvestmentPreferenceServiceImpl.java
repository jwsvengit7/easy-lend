package com.decagon.lendingservice.service.serviceImpl;

import com.decagon.lendingservice.entity.InvestmentPreference;
import com.decagon.lendingservice.dto.InvestmentDTORequest;
import com.decagon.lendingservice.dto.InvestmentDTOResponse;
import com.decagon.lendingservice.repo.InvestmentPreferenceRepository;
import com.decagon.lendingservice.service.InvestmentPreferenceService;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InvestmentPreferenceServiceImpl implements InvestmentPreferenceService {
    private final InvestmentPreferenceRepository investmentRepository;
    private final ModelMapper modelMapper;
    @Override
    public InvestmentDTOResponse createInvestment(InvestmentDTORequest request) {
        if (request.getLoanAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Loan amount must be greater than 0");
        }
        InvestmentPreference investmentPreference=investmentRepository.findByUserId("userId").orElse(null);
        if(Objects.nonNull(investmentPreference)){
            throw new ValidationException("Investment preference already exists for user");
        }
        InvestmentPreference response = modelMapper.map(request, InvestmentPreference.class);
        return new InvestmentDTOResponse(investmentRepository.save(response));
    }
}
