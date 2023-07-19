package com.decagon.service.serviceImplementation;

import com.decagon.dto.*;
import com.decagon.dto.response.ProfileResponseDTO;
import com.decagon.entity.Profile;
import com.decagon.entity.pojo.ContactInformation;
import com.decagon.exception.ProfileNotFoundException;
import com.decagon.repository.ProfileRepository;
import com.decagon.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;


    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ProfileResponseDTO createProfile(Long user_id, String profileCreationStatus, ContactInformationDTO contactInformationDTO) {
        // Convert ContactInformationDTO to ContactInformation
        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setFirstName(contactInformationDTO.getFirstName());
        contactInformation.setLastName(contactInformationDTO.getLastName());
        contactInformation.setEmail(contactInformationDTO.getEmail());
        contactInformation.setPhoneNumber(contactInformationDTO.getPhoneNumber());

        // Create the Profile entity and save it in the database
        Profile profile = new Profile();
        profile.setUser_id(user_id);
        profile.setProfileCreationStatus(profileCreationStatus);
        profile.setContactInformation(contactInformation);

        profileRepository.save(profile);

        // Prepare the response DTO
        ProfileResponseDTO responseDTO = new ProfileResponseDTO();
//        responseDTO.setId(profile.getId());
        responseDTO.setUser_id(user_id);
        responseDTO.setProfileCreationStatus(profileCreationStatus);
        responseDTO.setContactInformation(contactInformation);
        // Set other screens in the response DTO

        return responseDTO;
    }


    @Override
    public ContactInformationDTO updateContactInformation(Long profileId, ContactInformationDTO contactInfo) {
        // Fetch the profile from the database
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);

        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoundException("Profile not found with ID: " + profileId);
        }

        Profile profile = optionalProfile.get();

        // Convert the ContactInformationDTO to ContactInformation
        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setFirstName(contactInfo.getFirstName());
        contactInformation.setLastName(contactInfo.getLastName());
        contactInformation.setEmail(contactInfo.getEmail());
        contactInformation.setPhoneNumber(contactInfo.getPhoneNumber());

        // Update the ContactInformation screen
        profile.setContactInformation(contactInformation);

        // Update the profileCreationStatus to reflect the screen update
        String updatedStatus = "ContactInformation_updated";
        profile.setProfileCreationStatus(updatedStatus);

        profileRepository.save(profile);

        return contactInfo;
    }

    @Override
    public EmploymentStatusDTO updateEmploymentStatus(Long profileId, EmploymentStatusDTO employmentStatus) {
        return null;
    }

    @Override
    public GovernmentIDDTO updateGovernmentID(Long profileId, GovernmentIDDTO governmentID) {
        return null;
    }

    @Override
    public IncomeStatusDTO updateIncomeStatus(Long profileId, IncomeStatusDTO incomeStatus) {
        return null;
    }

    @Override
    public BankAccountDTO updateBankAccount(Long profileId, BankAccountDTO bankAccount) {
        return null;
    }

    @Override
    public ProofOfAddressDTO updateProofOfAddress(Long profileId, ProofOfAddressDTO proofOfAddress) {
        return null;
    }
}