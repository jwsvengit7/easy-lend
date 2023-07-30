package com.decagon.service;

import com.decagon.dto.pojoDTO.*;
import com.decagon.dto.response.ProfileResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {
    ProfileResponseDTO createProfile(String user_id, ContactInformationDTO contactInformation);

    ProfileResponseDTO updateContactInformation(ContactInformationDTO contactInfo, String authorizationHeader);

    ProfileResponseDTO updateEmploymentStatus(EmploymentStatusDTO employmentStatus, String userId);

    ProfileResponseDTO updateGovernmentID(GovernmentIDDTO governmentID, MultipartFile file, String userId);

    ProfileResponseDTO updateIncomeStatus(IncomeStatusDTO incomeStatus, String userId);

    ProfileResponseDTO updateBankAccount(BankAccountDTO bankAccount, String userId);

    ProfileResponseDTO updateProofOfAddress(ProofOfAddressDTO proofOfAddress, MultipartFile file, String userId);
}