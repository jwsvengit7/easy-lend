package com.decagon.dto.pojoDTO;

import com.decagon.domain.pojo.ContactInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.netty.http.server.ConnectionInformation;

@Getter
@Setter
@NoArgsConstructor
public class ContactInformationDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public ContactInformationDTO(ContactInformation contactInformation) {
        this.firstName = contactInformation.getFirstName();
        this.lastName = contactInformation.getLastName();
        this.email = contactInformation.getEmail();
        this.phoneNumber = contactInformation.getPhoneNumber();
    }
}
