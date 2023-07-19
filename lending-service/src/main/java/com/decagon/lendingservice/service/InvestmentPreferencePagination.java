package com.decagon.lendingservice.service;

import com.decagon.lendingservice.lendingDTOResponse.InvestmentDTOResponse;
import org.springframework.data.domain.Page;

public interface InvestmentPreferencePagination {
    Page<InvestmentDTOResponse> getPaginatedInvestment(int page,int pageSize);
}
