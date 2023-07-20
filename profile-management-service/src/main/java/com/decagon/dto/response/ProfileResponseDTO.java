package com.decagon.dto.response;

import com.decagon.domain.pojo.ContactInformation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResponseDTO {
    private Long user_id;
    private String profileCreationStatus;
    private ContactInformation contactInformation;
}
