package com.decagon.dto.response;

import com.decagon.dto.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {
    private Long user_id;
    private ContactInformationDTO contactInformation;
    private EmploymentStatusDTO employmentStatus;
    private GovernmentIDDTO governmentID;
    private IncomeStatusDTO incomeStatus;
    private ProofOfAddressDTO proofOfAddress;
    private BankAccountDTO bankAccount;
}
