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
        Long user_id = message.getUser_id();
        String fullName = message.getFullName();
        String email = message.getEmail();
        String phoneNumber = message.getPhoneNumber();

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

    @RabbitListener(queues = "${rabbitmq.updateContactInformationQueue}")
    public void receiveUpdateContactInformation(UpdateContactInformationMessage message) {
        try {
            Long profileId = message.getProfileId();
            ContactInformationDTO contactInfo = message.getContactInformation();

            // Call profileService.updateContactInformation to update the ContactInformation screen
            profileService.updateContactInformation(profileId, contactInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "${rabbitmq.updateEmploymentStatusQueue}")
    public void receiveUpdateEmploymentStatus(UpdateEmploymentStatusMessage message) {
        try {
            Long profileId = message.getProfileId();
            EmploymentStatusDTO employmentStatusDTO = message.getEmploymentStatusDTO();

            // Call profileService.updateEmploymentStatus to update the EmploymentStatus screen
            profileService.updateEmploymentStatus(profileId, employmentStatusDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "${rabbitmq.updateGovernmentIDQueue}")
    public void receiveUpdateGovernmentID(UpdateGovernmentIDMessage message) {
        try {
            Long profileId = message.getProfileId();
            GovernmentIDDTO governmentIDDTO = message.getGovernmentIDDTO();

            // Call profileService.updateGovernmentID to update the GovernmentID screen
            profileService.updateGovernmentID(profileId, governmentIDDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "${rabbitmq.updateIncomeStatusQueue}")
    public void receiveUpdateIncomeStatus(UpdateIncomeStatusMessage message) {
        try {
            Long profileId = message.getProfileId();
            IncomeStatusDTO incomeStatusDTO = message.getIncomeStatusDTO();

            // Call profileService.updateIncomeStatus to update the IncomeStatus screen
            profileService.updateIncomeStatus(profileId, incomeStatusDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "${rabbitmq.updateBankAccountQueue}")
    public void receiveUpdateBankAccount(UpdateBankAccountMessage message) {
        try {
            Long profileId = message.getProfileId();
            BankAccountDTO bankAccountDTO = message.getBankAccountDTO();

            // Call profileService.updateBankAccount to update the BankAccount screen
            profileService.updateBankAccount(profileId, bankAccountDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "${rabbitmq.updateProofOfAddressQueue}")
    public void receiveUpdateProofOfAddress(UpdateProofOfAddressMessage message) {
        try {
            Long profileId = message.getProfileId();
            ProofOfAddressDTO proofOfAddressDTO = message.getProofOfAddressDTO();

            // Call profileService.updateProofOfAddress to update the ProofOfAddress screen
            profileService.updateProofOfAddress(profileId, proofOfAddressDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

