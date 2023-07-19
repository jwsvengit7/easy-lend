package com.decagon.controller;

import com.decagon.dto.ContactInformationDTO;
import com.decagon.dto.EmploymentStatusDTO;
import com.decagon.dto.request.ProfileRequestDTO;
import com.decagon.dto.response.ProfileResponseDTO;
import com.decagon.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProfileResponseDTO> createProfile(@RequestBody ProfileRequestDTO requestDTO) {
        ProfileResponseDTO profile = profileService.createProfile(requestDTO.getUser_id());
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @PostMapping("/{profileId}/contact-information")
    public ResponseEntity<ContactInformationDTO> updateContactInformation(
            @PathVariable Long profileId, @RequestBody ContactInformationDTO contactInfo) {
        ContactInformationDTO updatedContactInfo = profileService.updateContactInformation(profileId, contactInfo);
        return ResponseEntity.ok(updatedContactInfo);
    }

    @PostMapping("/{profileId}/employment-status")
    public ResponseEntity<EmploymentStatusDTO> updateEmploymentStatus(
            @PathVariable Long profileId, @RequestBody EmploymentStatusDTO employmentStatus) {
        EmploymentStatusDTO updatedEmploymentStatus = profileService.updateEmploymentStatus(profileId, employmentStatus);
        return ResponseEntity.ok(updatedEmploymentStatus);
    }

    // Implement similar endpoints for other screens (GovernmentID, IncomeStatus, BankAccount, ProofOfAddress)
}



