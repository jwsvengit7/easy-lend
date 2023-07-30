package com.decagon.domain.screen;

import com.decagon.dto.pojoDTO.GovernmentIDDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GovernmentID {
    private String documentType;
    private String documentNumber;
    private String documentUrl;

    public GovernmentID(GovernmentIDDTO governmentIDDTO) {
        this.documentType = governmentIDDTO.getDocumentType();
        this.documentNumber = governmentIDDTO.getDocumentNumber();
    }
}