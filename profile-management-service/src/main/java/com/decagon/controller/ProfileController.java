package com.decagon.controller;

import com.decagon.dto.pojoDTO.*;
import com.decagon.dto.response.ApiResponse;
import com.decagon.dto.response.ProfileResponseDTO;
import com.decagon.security.JwtTokenFilter;
import com.decagon.service.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/profile")
@Api(tags = "Profile API")
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
    @ApiOperation(value = "Update contact information for a user profile", response = ApiResponse.class)
    public ResponseEntity<ApiResponse<ProfileResponseDTO>> updateContactInformation(
            @ApiParam(value = "Contact information to update", required = true)
            @RequestBody ContactInformationDTO contactInformation,
            @ApiParam(value = "Access token", required = true)
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<ProfileResponseDTO> responseDTO = new ApiResponse<>(profileService.updateContactInformation(contactInformation, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/employment-status")
    @ApiOperation(value = "Update employment status for a user profile", response = ApiResponse.class)
    public ResponseEntity<ApiResponse<EmploymentStatusDTO>> updateEmploymentStatus(
            @ApiParam(value = "Employment status to update", required = true)
            @RequestBody EmploymentStatusDTO employmentStatusDTO,
            @ApiParam(value = "Access token", required = true)
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<EmploymentStatusDTO> responseDTO = new ApiResponse<>(profileService.updateEmploymentStatus(employmentStatusDTO, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/government-id", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "Update government ID information for a user profile", response = ApiResponse.class)
    public ResponseEntity<ApiResponse<GovernmentIDDTO>> updateGovernmentID(
            @ApiParam(value = "Government ID information to update", required = true)
            @RequestBody GovernmentIDDTO governmentIDDTO,
            @ApiParam(value = "Access token", required = true)
            @RequestHeader("Authorization") String accessToken,
            @ApiParam(value = "Government ID document file", required = true)
            @RequestParam("file") MultipartFile file) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<GovernmentIDDTO> responseDTO = new ApiResponse<>(profileService.updateGovernmentID(governmentIDDTO, file, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/income-status")
    @ApiOperation(value = "Update income status for a user profile", response = ApiResponse.class)
    public ResponseEntity<ApiResponse<IncomeStatusDTO>> updateIncomeStatus(
            @ApiParam(value = "Income status to update", required = true)
            @RequestBody IncomeStatusDTO incomeStatusDTO,
            @ApiParam(value = "Access token", required = true)
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<IncomeStatusDTO> responseDTO = new ApiResponse<>(profileService.updateIncomeStatus(incomeStatusDTO, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/bank-account")
    @ApiOperation(value = "Update bank account information for a user profile", response = ApiResponse.class)
    public ResponseEntity<ApiResponse<BankAccountDTO>> updateBankAccount(
            @ApiParam(value = "Bank account information to update", required = true)
            @RequestBody BankAccountDTO bankAccountDTO,
            @ApiParam(value = "Access token", required = true)
            @RequestHeader("Authorization") String accessToken) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<BankAccountDTO> responseDTO = new ApiResponse<>(profileService.updateBankAccount(bankAccountDTO, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/proof-of-address", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "Update proof of address information for a user profile", response = ApiResponse.class)
    public ResponseEntity<ApiResponse<ProofOfAddressDTO>> updateProofOfAddress(
            @ApiParam(value = "Proof of address information to update", required = true)
            @RequestBody ProofOfAddressDTO proofOfAddressDTO,
            @ApiParam(value = "Access token", required = true)
            @RequestHeader("Authorization") String accessToken,
            @ApiParam(value = "Proof of address document file", required = true)
            @RequestParam("file") MultipartFile file) {

        String userId = jwtTokenFilter.extractUserIdFromToken(accessToken);
        ApiResponse<ProofOfAddressDTO> responseDTO = new ApiResponse<>(profileService.updateProofOfAddress(proofOfAddressDTO, file, userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
