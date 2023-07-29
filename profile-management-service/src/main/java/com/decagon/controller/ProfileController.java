package com.decagon.controller;

import com.decagon.dto.pojoDTO.ContactInformationDTO;
import com.decagon.dto.response.ApiResponse;
import com.decagon.dto.response.ProfileResponseDTO;
import com.decagon.service.ProfileService;
import com.decagon.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@Tag(name = "Profile API")
public class ProfileController {
    @Value("${jwt.secret}")
    private String jwtSecret;

    private final ProfileService profileService;
    private final JwtUtils jwtUtils;

    public ProfileController(ProfileService profileService, JwtUtils jwtUtils) {
        this.profileService = profileService;
        this.jwtUtils = jwtUtils;
    }

    @PutMapping("/contact-information")
    @Operation(summary = "Update contact information for a user profile")
    public ResponseEntity<ApiResponse<ProfileResponseDTO>> updateContactInformation(
            @Parameter(description = "Contact information to update", required = true)
            @RequestBody ContactInformationDTO contactInfo, @RequestHeader("Authorization") String authorizationHeader) {

        ApiResponse<ProfileResponseDTO> responseDTO = new ApiResponse<>(profileService.updateContactInformation(contactInfo, authorizationHeader));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    @PutMapping("/employment-status")
//    @Operation(summary = "Update employment status for a user profile")
//    public ResponseEntity<ApiResponse<ProfileResponseDTO>> updateEmploymentStatus(
//            @Parameter(description = "Employment status to update", required = true)
//            @RequestBody EmploymentStatusDTO employmentStatusDTO,
//            @RequestHeader("Authorization") String accessToken) {
//
////        System.out.println(accessToken);
////        String userId = jwtUtils.getUserIDFromToken(accessToken);
////        System.out.println(userId);
//        ApiResponse<ProfileResponseDTO> responseDTO = new ApiResponse<>(profileService.updateEmploymentStatus(employmentStatusDTO, userId));
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }

//    @PutMapping(value = "/government-id", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    @Operation(summary = "Update government ID information for a user profile")
//    public ResponseEntity<ApiResponse<ProfileResponseDTO>> updateGovernmentID(
//            @Parameter(description = "Government ID information to update", required = true)
//            @RequestPart("governmentIDDTO") GovernmentIDDTO governmentIDDTO,
//            @RequestPart("file") MultipartFile file,
//            @RequestHeader("Authorization") String accessToken) {
//
//        ApiResponse<ProfileResponseDTO> responseDTO = new ApiResponse<>(profileService.updateGovernmentID(governmentIDDTO, file, userId));
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//    @PutMapping("/income-status")
//    @Operation(summary = "Update income status for a user profile")
//    public ResponseEntity<ApiResponse<ProfileResponseDTO>> updateIncomeStatus(
//            @Parameter(description = "Income status to update", required = true)
//            @RequestBody IncomeStatusDTO incomeStatusDTO,
//            @RequestHeader("Authorization") String accessToken) {
//
//        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
//        ApiResponse<ProfileResponseDTO> responseDTO = new ApiResponse<>(profileService.updateIncomeStatus(incomeStatusDTO, userId));
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//    @PutMapping("/bank-account")
//    @Operation(summary = "Update bank account information for a user profile")
//    public ResponseEntity<ApiResponse<ProfileResponseDTO>> updateBankAccount(
//            @Parameter(description = "Bank account information to update", required = true)
//            @RequestBody BankAccountDTO bankAccountDTO,
//            @RequestHeader("Authorization") String accessToken) {
//
//        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
//        ApiResponse<ProfileResponseDTO> responseDTO = new ApiResponse<>(profileService.updateBankAccount(bankAccountDTO, userId));
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//    @PutMapping(value = "/proof-of-address", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    @Operation(summary = "Update proof of address information for a user profile")
//    public ResponseEntity<ApiResponse<ProfileResponseDTO>> updateProofOfAddress(
//            @Parameter(description = "Proof of address information to update", required = true)
//            @RequestPart("proofOfAddressDTO") ProofOfAddressDTO proofOfAddressDTO,
//            @RequestPart("file") MultipartFile file,
//            @RequestHeader("Authorization") String accessToken) {
//
//        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
//        ApiResponse<ProfileResponseDTO> responseDTO = new ApiResponse<>(profileService.updateProofOfAddress(proofOfAddressDTO, file, userId));
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
}
