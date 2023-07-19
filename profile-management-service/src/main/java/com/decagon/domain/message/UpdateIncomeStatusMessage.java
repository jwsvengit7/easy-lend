package com.decagon.domain.message;

import com.decagon.dto.pojoDTO.IncomeStatusDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateIncomeStatusMessage {
    private Long profileId;
    private IncomeStatusDTO incomeStatusDTO;
}
