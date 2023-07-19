package com.decagon.service.serviceImplementation;

import com.decagon.dto.ContactInformationDTO;
import com.decagon.dto.UserDTO;
import com.decagon.dto.response.ProfileResponseDTO;
import com.decagon.entity.Profile;
import com.decagon.repository.ProfileRepository;
import com.decagon.service.ProfileService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final UserServiceFeignClient userServiceFeignClient;

    public ProfileServiceImpl(ProfileRepository profileRepository, UserServiceFeignClient userServiceFeignClient) {
        this.profileRepository = profileRepository;
        this.userServiceFeignClient = userServiceFeignClient;
    }

    @Override
    public ProfileResponseDTO createProfile(Long user_id) {
        // Fetch user information using the FeignClient
        UserDTO userDTO = userServiceFeignClient.getUserById(user_id);

        // Split the full name into two parts (firstName and lastName)
        String fullName = userDTO.getFullName();
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        // Create and save the ContactInformation screen
        ContactInformationDTO contactInformation = new ContactInformationDTO();
        contactInformation.setFirstName(firstName);
        contactInformation.setLastName(lastName);
        contactInformation.setEmail(userDTO.getEmail());
        contactInformation.setPhoneNumber(userDTO.getPhoneNumber());

        // Set the profileCreationStatus as "new"
        String profileCreationStatus = "new";

        // Create the Profile entity and save it in the database
        Profile profile = new Profile();
        profile.setUser_id(user_id);
        profile.setProfileCreationStatus(profileCreationStatus);
        profile.setContactInformation(contactInformation);
        // Initialize other screens as needed

        profileRepository.save(profile);

        // Prepare the response DTO
        ProfileResponseDTO responseDTO = new ProfileResponseDTO();
        responseDTO.setProfileCreationStatus(profileCreationStatus);

        return responseDTO;
    }

    // Implement update methods for other screens (ContactInformation, EmploymentStatus, GovernmentID, IncomeStatus, BankAccount, ProofOfAddress)
}