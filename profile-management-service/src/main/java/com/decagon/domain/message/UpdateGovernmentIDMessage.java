package com.decagon.domain.message;

import com.decagon.dto.pojoDTO.GovernmentIDDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateGovernmentIDMessage {
    private Long profileId;
    private GovernmentIDDTO governmentIDDTO;
}
