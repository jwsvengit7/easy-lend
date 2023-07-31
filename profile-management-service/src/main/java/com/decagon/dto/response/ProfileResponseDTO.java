package com.decagon.dto.response;

import com.decagon.domain.entity.Profile;
import com.decagon.dto.pojoDTO.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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
        if(Objects.nonNull(profile.getContactInformation())) {
            this.contactInformationDTO = new ContactInformationDTO(profile.getContactInformation());
        }
        // Check if employmentStatus is not null before creating the DTO
        if (Objects.nonNull(profile.getEmploymentStatus())) {
            this.employmentStatusDTO = new EmploymentStatusDTO(profile.getEmploymentStatus());
        }
        if (Objects.nonNull(profile.getGovernmentId())) {
            this.governmentIDDTO = new GovernmentIDDTO(profile.getGovernmentId());
        }
        if (Objects.nonNull(profile.getIncomeStatus())) {
            this.incomeStatusDTO = new IncomeStatusDTO(profile.getIncomeStatus());
        }
        if (Objects.nonNull(profile.getBankAccount())) {
            this.bankAccountDTO = new BankAccountDTO(profile.getBankAccount());
        }
//        if (profile.getProofOfAddress() != null && profile.getStatus().ordinal() >= 6) {
//            this.proofOfAddressDTO = new ProofOfAddressDTO(profile.getProofOfAddress());
//        }
    }
}