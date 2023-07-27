package com.decagon.dto.response;

import com.decagon.domain.entity.Profile;
import com.decagon.dto.pojoDTO.ContactInformationDTO;
import com.decagon.dto.pojoDTO.IncomeStatusDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResponseDTO {
    private String userId;
    private ContactInformationDTO contactInformationDTO;
    private IncomeStatusDTO incomeStatusDTO;

    public ProfileResponseDTO(Profile profile) {
        this.userId = profile.getUserId();
        this.contactInformationDTO = new ContactInformationDTO(profile.getContactInformation());
        if (profile.getStatus().ordinal() >= 2){
            this.incomeStatusDTO = new IncomeStatusDTO(profile.getIncomeStatus());
        }
    }
}
