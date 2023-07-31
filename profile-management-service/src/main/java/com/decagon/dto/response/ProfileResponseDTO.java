package com.decagon.dto.response;

import com.decagon.domain.entity.Profile;
import com.decagon.dto.pojoDTO.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResponseDTO {
    private String userId;
    private ContactInformationDTO contactInformationDTO;
    private EmploymentStatusDTO employmentStatusDTO;
    private GovernmentIDDTO governmentIDDTO;
    private IncomeStatusDTO incomeStatusDTO;
    private BankAccountDTO bankAccountDTO;
    private ProofOfAddressDTO proofOfAddressDTO;

    public ProfileResponseDTO(Profile profile) {
        this.userId = profile.getUserId();
        this.contactInformationDTO = new ContactInformationDTO(profile.getContactInformation());

        // Check if employmentStatus is not null before creating the DTO
        if (profile.getEmploymentStatus() != null && profile.getStatus().ordinal() >= 2) {
            this.employmentStatusDTO = new EmploymentStatusDTO(profile.getEmploymentStatus());
        }
        if (profile.getGovernmentId() != null && profile.getStatus().ordinal() >= 3) {
            this.governmentIDDTO = new GovernmentIDDTO(profile.getGovernmentId());
        }
        if (profile.getIncomeStatus() != null && profile.getStatus().ordinal() >= 4) {
            this.incomeStatusDTO = new IncomeStatusDTO(profile.getIncomeStatus());
        }
        if (profile.getBankAccount() != null && profile.getStatus().ordinal() >= 5) {
            this.bankAccountDTO = new BankAccountDTO(profile.getBankAccount());
        }
//        if (profile.getProofOfAddress() != null && profile.getStatus().ordinal() >= 6) {
//            this.proofOfAddressDTO = new ProofOfAddressDTO(profile.getProofOfAddress());
//        }
    }
}