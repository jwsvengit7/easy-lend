package com.decagon.lendingservice.service;

import com.decagon.lendingservice.lendingDTORequest.InvestmentDTORequest;
import com.decagon.lendingservice.lendingDTOResponse.InvestmentDTOResponse;

public interface InvestmentPreferenceService {
    InvestmentDTOResponse createInvestment(InvestmentDTORequest request, String token);
}
