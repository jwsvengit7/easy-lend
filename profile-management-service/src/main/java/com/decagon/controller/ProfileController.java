package com.decagon.controller;

import com.decagon.dto.pojoDTO.*;
import com.decagon.dto.response.ApiResponse;
import com.decagon.dto.response.ProfileResponseDTO;
import com.decagon.security.JwtTokenFilter;
import com.decagon.service.ProfileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Value("${jwt.secret}")
    private String jwtSecret;

    private final ProfileService profileService;
    private final JwtTokenFilter jwtTokenFilter;

    public ProfileController(ProfileService profileService, JwtTokenFilter jwtTokenFilter) {
        this.profileService = profileService;
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @PutMapping("/contact-information")
    public ResponseEntity<ApiResponse<ProfileResponseDTO>> updateContactInformation(
            @RequestBody ContactInformationDTO contactInformation,
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<ProfileResponseDTO> responseDTO = new ApiResponse<>(profileService.updateContactInformation(contactInformation, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/employment-status")
    public ResponseEntity<ApiResponse<EmploymentStatusDTO>> updateEmploymentStatus(
            @RequestBody EmploymentStatusDTO employmentStatusDTO,
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<EmploymentStatusDTO> responseDTO = new ApiResponse<>(profileService.updateEmploymentStatus(employmentStatusDTO, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/government-id", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<GovernmentIDDTO>> updateGovernmentID(
            @RequestBody GovernmentIDDTO governmentIDDTO,
            @RequestHeader("Authorization") String accessToken,
            @RequestParam("file") MultipartFile file) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<GovernmentIDDTO> responseDTO = new ApiResponse<>(profileService.updateGovernmentID(governmentIDDTO, file, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/income-status")
    public ResponseEntity<ApiResponse<IncomeStatusDTO>> updateIncomeStatus(
            @RequestBody IncomeStatusDTO incomeStatusDTO,
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<IncomeStatusDTO> responseDTO = new ApiResponse<>(profileService.updateIncomeStatus(incomeStatusDTO, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/bank-account")
    public ResponseEntity<ApiResponse<BankAccountDTO>> updateBankAccount(
            @RequestBody BankAccountDTO bankAccountDTO,
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<BankAccountDTO> responseDTO = new ApiResponse<>(profileService.updateBankAccount(bankAccountDTO, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/proof-of-address", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ProofOfAddressDTO>> updateProofOfAddress(
            @RequestBody ProofOfAddressDTO proofOfAddressDTO,
            @RequestHeader("Authorization") String accessToken,
            @RequestParam("file") MultipartFile file) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<ProofOfAddressDTO> responseDTO = new ApiResponse<>(profileService.updateProofOfAddress(proofOfAddressDTO, file, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
