package com.decagon.consumer;

import com.decagon.domain.message.*;
import com.decagon.dto.pojoDTO.*;
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
    public void receiveCreateProfileMessage(CreateProfileMessage message) {
        // Fetch user information using the provided user_id from the userDetails
        String user_id = message.getUser_id();
        String fullName = message.getFullName();
        String email = message.getEmail();

        // Split the full name into two parts (firstName and lastName)
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        // Create and save the ContactInformation screen
        ContactInformationDTO contactInformation = new ContactInformationDTO();
        contactInformation.setFirstName(firstName);
        contactInformation.setLastName(lastName);
        contactInformation.setEmail(email);

        // Create the Profile entity and save it in the database using the ProfileService
        profileService.createProfile(user_id, contactInformation);
    }
}

