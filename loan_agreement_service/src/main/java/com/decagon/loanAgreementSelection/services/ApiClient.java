package com.decagon.loanAgreementSelection.services;

import com.decagon.loanAgreementSelection.models.LoanOffer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(name = "${loan-offer-api.name}", url = "${loan-offer-api.base-url}")
public interface ApiClient {
    @GetMapping("/accept_offer/{offerId}")
    ResponseEntity<LoanOffer> getLoanOffer(@PathVariable("offerId")Long offerId);
}
