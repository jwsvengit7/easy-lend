package com.decagon.domain.message;

import com.decagon.dto.pojoDTO.ContactInformationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateContactInformationMessage {
    private Long profileId;
    private ContactInformationDTO contactInformation;
}

