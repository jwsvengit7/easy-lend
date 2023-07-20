package com.decagon.controller;

import com.decagon.dto.pojoDTO.*;
import com.decagon.dto.response.ProfileResponseDTO;
import com.decagon.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PutMapping("/{profileId}/contact-information")
    public ResponseEntity<ProfileResponseDTO> updateContactInformation(
            @PathVariable Long profileId,
            @RequestBody ContactInformationDTO contactInformation) {
        ProfileResponseDTO responseDTO = profileService.updateContactInformation(profileId, contactInformation);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{profileId}/employment-status")
    public ResponseEntity<EmploymentStatusDTO> updateEmploymentStatus(
            @PathVariable Long profileId,
            @RequestBody EmploymentStatusDTO employmentStatusDTO) {
        EmploymentStatusDTO responseDTO = profileService.updateEmploymentStatus(profileId, employmentStatusDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{profileId}/government-id")
    public ResponseEntity<GovernmentIDDTO> updateGovernmentID(
            @PathVariable Long profileId,
            @RequestBody GovernmentIDDTO governmentIDDTO) {
        GovernmentIDDTO responseDTO = profileService.updateGovernmentID(profileId, governmentIDDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{profileId}/income-status")
    public ResponseEntity<IncomeStatusDTO> updateIncomeStatus(
            @PathVariable Long profileId,
            @RequestBody IncomeStatusDTO incomeStatusDTO) {
        IncomeStatusDTO responseDTO = profileService.updateIncomeStatus(profileId, incomeStatusDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{profileId}/bank-account")
    public ResponseEntity<BankAccountDTO> updateBankAccount(
            @PathVariable Long profileId,
            @RequestBody BankAccountDTO bankAccountDTO) {
        BankAccountDTO responseDTO = profileService.updateBankAccount(profileId, bankAccountDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{profileId}/proof-of-address")
    public ResponseEntity<ProofOfAddressDTO> updateProofOfAddress(
            @PathVariable Long profileId,
            @RequestBody ProofOfAddressDTO proofOfAddressDTO) {
        ProofOfAddressDTO responseDTO = profileService.updateProofOfAddress(profileId, proofOfAddressDTO);
        return ResponseEntity.ok(responseDTO);
    }
}



