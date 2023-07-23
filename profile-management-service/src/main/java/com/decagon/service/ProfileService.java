package com.decagon.service;

import com.decagon.dto.pojoDTO.*;
import com.decagon.dto.response.ProfileResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {
    ProfileResponseDTO createProfile(String user_id, ContactInformationDTO contactInformation);

    ProfileResponseDTO updateContactInformation(ContactInformationDTO contactInfo, String userId);

    EmploymentStatusDTO updateEmploymentStatus(EmploymentStatusDTO employmentStatus, String userId);

    GovernmentIDDTO updateGovernmentID(GovernmentIDDTO governmentID, MultipartFile file, String userId);

    IncomeStatusDTO updateIncomeStatus(IncomeStatusDTO incomeStatus, String userId);

    BankAccountDTO updateBankAccount(BankAccountDTO bankAccount, String userId);

    ProofOfAddressDTO updateProofOfAddress(ProofOfAddressDTO proofOfAddress, MultipartFile file, String userId);
}