package com.decagon.dto.response;

import com.decagon.domain.constant.ProfileStatus;
import com.decagon.domain.entity.Profile;
import com.decagon.domain.screen.BankAccount;
import com.decagon.domain.screen.ContactInformation;
import com.decagon.domain.screen.EmploymentStatus;
import com.decagon.domain.screen.GovernmentID;
import com.decagon.domain.screen.IncomeStatus;
import com.decagon.dto.pojoDTO.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Getter
@Setter
@Slf4j
public class ProfileResponseDTO {
    private String userId;
    private ProfileStatus status;
    private ContactInformationDTO contactInformationDTO;
    private EmploymentStatusDTO employmentStatusDTO;
    private GovernmentIDDTO governmentIDDTO;
    private IncomeStatusDTO incomeStatusDTO;
    private BankAccountDTO bankAccountDTO;
    private ProofOfAddressDTO proofOfAddressDTO;
    private static ObjectMapper mapper=new ObjectMapper();


    public ProfileResponseDTO(Profile profile) {
        this.userId = profile.getUserId();
        this.status = profile.getStatus();
        try {
            if (Objects.nonNull(profile.getContactInformation())) {
                this.contactInformationDTO = new ContactInformationDTO(mapper.readValue(profile.getContactInformation(), ContactInformation.class));
            }
            // Check if employmentStatus is not null before creating the DTO
            if (Objects.nonNull(profile.getEmploymentStatus())) {
                this.employmentStatusDTO = new EmploymentStatusDTO(mapper.readValue(profile.getEmploymentStatus(), EmploymentStatus.class));
            }
            if (Objects.nonNull(profile.getIncomeStatus())) {
                this.incomeStatusDTO = new IncomeStatusDTO(mapper.readValue(profile.getIncomeStatus(), IncomeStatus.class));
            }
            if (Objects.nonNull(profile.getGovernmentId())) {
                this.governmentIDDTO = new GovernmentIDDTO(mapper.readValue(profile.getGovernmentId(), GovernmentID.class));
            }
            if (Objects.nonNull(profile.getBankAccount())) {
                this.bankAccountDTO = new BankAccountDTO(mapper.readValue(profile.getBankAccount(), BankAccount.class));
            }
//        if (profile.getProofOfAddress() != null && profile.getStatus().ordinal() >= 6) {
//            this.proofOfAddressDTO = new ProofOfAddressDTO(profile.getProofOfAddress());
//        }
        }catch (Exception ex){
            log.error("An exception occurred",ex);
        }
    }
}