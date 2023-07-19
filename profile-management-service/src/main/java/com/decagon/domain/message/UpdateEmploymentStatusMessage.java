package com.decagon.domain.message;

import com.decagon.dto.pojoDTO.EmploymentStatusDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateEmploymentStatusMessage {
    private Long profileId;
    private EmploymentStatusDTO employmentStatusDTO;
}
