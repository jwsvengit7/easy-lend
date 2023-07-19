package com.decagon.lendingservice.controller;

import com.decagon.lendingservice.lendingDTORequest.InvestmentDTORequest;
import com.decagon.lendingservice.lendingDTOResponse.InvestmentDTOResponse;
import com.decagon.lendingservice.service.InvestmentPreferencePagination;
import com.decagon.lendingservice.service.InvestmentPreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class InvestmentPreferenceController {
    private final InvestmentPreferenceService investmentPreferenceService;
    private  final InvestmentPreferencePagination pagination;

    @PostMapping("/create")
    public ResponseEntity<InvestmentDTOResponse> createInvestment(@RequestBody InvestmentDTORequest request){
       InvestmentDTOResponse invest = investmentPreferenceService.createInvestment(request);
       return  new ResponseEntity<>(invest, HttpStatus.OK);
    }
    @GetMapping("/investment")
    public ResponseEntity<Page<InvestmentDTOResponse>> investmentPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize){
        Page<InvestmentDTOResponse> paginated =  pagination.getPaginatedInvestment(page, pageSize);
        return new ResponseEntity<>(paginated,HttpStatus.OK);
    }
}
