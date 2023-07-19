package com.decagon.domain.message;

import com.decagon.dto.pojoDTO.ProofOfAddressDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateProofOfAddressMessage {
    private Long profileId;
    private ProofOfAddressDTO proofOfAddressDTO;
}
