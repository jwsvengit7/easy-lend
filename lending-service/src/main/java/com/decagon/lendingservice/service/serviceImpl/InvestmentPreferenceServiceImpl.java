package com.decagon.lendingservice.service.serviceImpl;

import com.decagon.lendingservice.entity.InvestmentPreference;
import com.decagon.lendingservice.lendingDTORequest.InvestmentDTORequest;
import com.decagon.lendingservice.lendingDTOResponse.InvestmentDTOResponse;
import com.decagon.lendingservice.repo.InvestmentPreferenceRepository;
import com.decagon.lendingservice.service.InvestmentPreferenceService;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

        InvestmentPreference response = modelMapper.map(request, InvestmentPreference.class);
        InvestmentPreference savedPreference = investmentRepository.save(response);
        return  new InvestmentDTOResponse(savedPreference);
    }
}
