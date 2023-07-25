package com.decagon.controller;

import com.decagon.dto.pojoDTO.*;
import com.decagon.dto.response.ApiResponse;
import com.decagon.dto.response.ProfileResponseDTO;
import com.decagon.security.JwtTokenFilter;
import com.decagon.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/profile")
@Tag(name = "Profile API")
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
    @Operation(summary = "Update contact information for a user profile")
    public ResponseEntity<ApiResponse<ProfileResponseDTO>> updateContactInformation(
            @Parameter(description = "Contact information to update", required = true)
            @RequestBody ContactInformationDTO contactInformation,
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<ProfileResponseDTO> responseDTO = new ApiResponse<>(profileService.updateContactInformation(contactInformation, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/employment-status")
    @Operation(summary = "Update employment status for a user profile")
    public ResponseEntity<ApiResponse<EmploymentStatusDTO>> updateEmploymentStatus(
            @Parameter(description = "Employment status to update", required = true)
            @RequestBody EmploymentStatusDTO employmentStatusDTO,
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<EmploymentStatusDTO> responseDTO = new ApiResponse<>(profileService.updateEmploymentStatus(employmentStatusDTO, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/government-id", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Update government ID information for a user profile")
    public ResponseEntity<ApiResponse<GovernmentIDDTO>> updateGovernmentID(
            @Parameter(description = "Government ID information to update", required = true)
            @RequestPart("governmentIDDTO") GovernmentIDDTO governmentIDDTO,
            @RequestPart("file") MultipartFile file,
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<GovernmentIDDTO> responseDTO = new ApiResponse<>(profileService.updateGovernmentID(governmentIDDTO, file, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/income-status")
    @Operation(summary = "Update income status for a user profile")
    public ResponseEntity<ApiResponse<IncomeStatusDTO>> updateIncomeStatus(
            @Parameter(description = "Income status to update", required = true)
            @RequestBody IncomeStatusDTO incomeStatusDTO,
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<IncomeStatusDTO> responseDTO = new ApiResponse<>(profileService.updateIncomeStatus(incomeStatusDTO, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/bank-account")
    @Operation(summary = "Update bank account information for a user profile")
    public ResponseEntity<ApiResponse<BankAccountDTO>> updateBankAccount(
            @Parameter(description = "Bank account information to update", required = true)
            @RequestBody BankAccountDTO bankAccountDTO,
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<BankAccountDTO> responseDTO = new ApiResponse<>(profileService.updateBankAccount(bankAccountDTO, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/proof-of-address", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Update proof of address information for a user profile")
    public ResponseEntity<ApiResponse<ProofOfAddressDTO>> updateProofOfAddress(
            @Parameter(description = "Proof of address information to update", required = true)
            @RequestPart("proofOfAddressDTO") ProofOfAddressDTO proofOfAddressDTO,
            @RequestPart("file") MultipartFile file,
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<ProofOfAddressDTO> responseDTO = new ApiResponse<>(profileService.updateProofOfAddress(proofOfAddressDTO, file, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
