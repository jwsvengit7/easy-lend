package com.decagon.dto.request;


import com.decagon.dto.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileRequestDTO {
    private Long user_id;
    private String profileCreationStatus;
    private ContactInformationDTO contactInformation;
    private EmploymentStatusDTO employmentStatus;
    private GovernmentIDDTO governmentID;
    private IncomeStatusDTO incomeStatus;
    private ProofOfAddressDTO proofOfAddress;
    private BankAccountDTO bankAccount;
}
