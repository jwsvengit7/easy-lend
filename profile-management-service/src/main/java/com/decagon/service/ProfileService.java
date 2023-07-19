package com.decagon.service;

import com.decagon.dto.*;
import com.decagon.dto.response.ProfileResponseDTO;

public interface ProfileService {
    ProfileResponseDTO createProfile(Long user_id, String profileCreationStatus, ContactInformationDTO contactInformation);

    ContactInformationDTO updateContactInformation(Long profileId, ContactInformationDTO contactInfo);

    EmploymentStatusDTO updateEmploymentStatus(Long profileId, EmploymentStatusDTO employmentStatus);

    GovernmentIDDTO updateGovernmentID(Long profileId, GovernmentIDDTO governmentID);

    IncomeStatusDTO updateIncomeStatus(Long profileId, IncomeStatusDTO incomeStatus);

    BankAccountDTO updateBankAccount(Long profileId, BankAccountDTO bankAccount);

    ProofOfAddressDTO updateProofOfAddress(Long profileId, ProofOfAddressDTO proofOfAddress);
}