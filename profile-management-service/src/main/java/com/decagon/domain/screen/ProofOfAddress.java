package com.decagon.domain.screen;

import com.decagon.dto.pojoDTO.ProofOfAddressDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProofOfAddress {
    private String document_Url;

    public ProofOfAddress(ProofOfAddressDTO proofOfAddressDTO) {
//        this.document_Url = proofOfAddressDTO.getDocument_Url();
    }
}