package com.decagon.dto.pojoDTO;

import com.decagon.domain.pojo.GovernmentID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GovernmentIDDTO {
    private String documentType;
    private String documentNumber;

    public GovernmentIDDTO(GovernmentID governmentID) {
        this.documentType = governmentID.getDocumentType();
        this.documentNumber = governmentID.getDocumentNumber();
    }
}
