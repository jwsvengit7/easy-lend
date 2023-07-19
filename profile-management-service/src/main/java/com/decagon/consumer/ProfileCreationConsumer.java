package com.decagon.consumer;

import com.decagon.dto.ContactInformationDTO;
import com.decagon.entity.pojo.UserDetails;
import com.decagon.service.ProfileService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProfileCreationConsumer {

    private final ProfileService profileService;

    public ProfileCreationConsumer(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RabbitListener(queues = "${rabbitmq.queueName}")
    public void receiveCreateProfileMessage(UserDetails userDetails) {
        // Fetch user information using the provided user_id from the userDetails
        Long user_id = userDetails.getUser_id();
        String fullName = userDetails.getFullName();
        String email = userDetails.getEmail();
        String phoneNumber = userDetails.getPhoneNumber();

        // Split the full name into two parts (firstName and lastName)
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        // Create and save the ContactInformation screen
        ContactInformationDTO contactInformation = new ContactInformationDTO();
        contactInformation.setFirstName(firstName);
        contactInformation.setLastName(lastName);
        contactInformation.setEmail(email);
        contactInformation.setPhoneNumber(phoneNumber);

        // Set the profileCreationStatus as "new"
        String profileCreationStatus = "new";

        // Create the Profile entity and save it in the database using the ProfileService
        profileService.createProfile(user_id, profileCreationStatus, contactInformation);
    }
}

