package com.decagon.lendingservice.service;

import com.decagon.lendingservice.dto.InvestmentDTORequest;
import com.decagon.lendingservice.dto.InvestmentDTOResponse;

public interface InvestmentPreferenceService {
    InvestmentDTOResponse createInvestment(InvestmentDTORequest request);
}
