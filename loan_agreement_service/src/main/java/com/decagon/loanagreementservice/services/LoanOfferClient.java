package com.decagon.loanagreementservice.services;

import com.decagon.loanagreementservice.models.LoanOffer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(name = "${loan-offer-api.name}", url = "${loan-offer-api.base-url}")
public interface LoanOfferClient {

    @GetMapping("/getloan/{offerId}")

    ResponseEntity<LoanOffer> getLoanOffer(@PathVariable("offerId") Long loanId);
}
