package com.decagon.lendingservice.service.serviceImpl;


import com.decagon.lendingservice.entity.InvestmentPreference;

import com.decagon.lendingservice.exceptions.BorrowersNotAllowedException;
import com.decagon.lendingservice.exceptions.InvestmentPreferenceExistsException;
import com.decagon.lendingservice.lendingDTORequest.InvestmentDTORequest;
import com.decagon.lendingservice.lendingDTOResponse.InvestmentDTOResponse;
import com.decagon.lendingservice.repo.InvestmentPreferenceRepository;
import com.decagon.lendingservice.service.InvestmentPreferenceService;
import com.decagon.lendingservice.utils.JwtUtils;
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
    private  final JwtUtils jwtUtils;

    @Override
    public InvestmentDTOResponse createInvestment(InvestmentDTORequest request, String token) {
      if(request.getLoanAmount().compareTo(BigDecimal.ZERO ) <= 0){
          throw  new ValidationException("loan amount must be greater than 0");
      }
      String userType = jwtUtils.getUserTypeFromToken(token);
      if("borrower".equalsIgnoreCase(userType)){
          throw   new BorrowersNotAllowedException("Borrowers are not Allowed to create an Investment");
      }
      String userId = jwtUtils.extractUserIdFromToken(token);
      InvestmentPreference investmentPreference = investmentRepository.findByUserId(userId).orElse(null);
      if(Objects.nonNull(investmentPreference)){
          throw new InvestmentPreferenceExistsException("Investment Already Exists for this User");
      }
      InvestmentPreference response = modelMapper.map(request, InvestmentPreference.class);
      response.setUserId(userId);
      return new InvestmentDTOResponse(investmentRepository.save(response));
    }

}
