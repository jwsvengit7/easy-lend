//package com.decagon.eventListener;
//
//import com.decagon.domain.message.UserObject;
//import com.decagon.dto.pojoDTO.ContactInformationDTO;
//import com.decagon.service.ProfileService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserCreationEventListener {
//    private final ProfileService profileService;
//
//    public UserCreationEventListener(ProfileService profileService) {
//        this.profileService = profileService;
//    }
//
//    @RabbitListener(queues = "rabbitmq.queue")
//    public void handleCreateUserEvent(String message) throws JsonProcessingException {
//        System.out.println("Received message: " + message);
//        // Fetch user information using the provided user_id from the userDetails
//        UserObject user = new ObjectMapper().readValue(message, UserObject.class);
//
//        // Split the full name into two parts (firstName and lastName)
//        String[] nameParts = user.getFullName().split(" ");
//        String firstName = nameParts[0];
//        String lastName = nameParts[1];
//
//        // Create and save the ContactInformation screen
//        ContactInformationDTO contactInformation = new ContactInformationDTO();
//        contactInformation.setFirstName(firstName);
//        contactInformation.setLastName(lastName);
//        contactInformation.setEmail(user.getEmail());
//
//        // Create the Profile entity and save it in the database using the ProfileService
//        profileService.createProfile(user.getUserId(), contactInformation);
//    }
//}
