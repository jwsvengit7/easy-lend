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
    private IncomeStatusDTO incomeStatusDTO;
    private EmploymentStatusDTO employmentStatusDTO;
    private GovernmentIDDTO governmentIDDTO;
    private BankAccountDTO bankAccountDTO;
    private ProofOfAddressDTO proofOfAddressDTO;

    public ProfileResponseDTO(Profile profile) {
        this.userId = profile.getUserId();
        this.contactInformationDTO = new ContactInformationDTO(profile.getContactInformation());
        if (profile.getStatus().ordinal() >= 2) {
            this.incomeStatusDTO = new IncomeStatusDTO(profile.getIncomeStatus());
        }
        if (profile.getStatus().ordinal() >= 3) {
            this.employmentStatusDTO = new EmploymentStatusDTO(profile.getEmploymentStatus());
        }
        if (profile.getStatus().ordinal() >= 4) {
            this.governmentIDDTO = new GovernmentIDDTO(profile.getGovernmentId());
        }
        if (profile.getStatus().ordinal() >= 5) {
            this.bankAccountDTO = new BankAccountDTO(profile.getBankAccount());
        }
//        if (profile.getStatus().ordinal() >= 6){
//            this.proofOfAddressDTO = new ProofOfAddressDTO(profile.getProofOfAddress());
//        }
    }
}