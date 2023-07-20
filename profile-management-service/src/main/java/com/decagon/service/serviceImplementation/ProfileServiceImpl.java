package com.decagon.service.serviceImplementation;

import com.decagon.domain.entity.Profile;
import com.decagon.domain.pojo.ContactInformation;
import com.decagon.domain.pojo.EmploymentStatus;
import com.decagon.dto.pojoDTO.*;
import com.decagon.dto.response.ProfileResponseDTO;
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

        // Update the ContactInformation screen directly with the provided data
        ContactInformation contactInformation = profile.getContactInformation();
        contactInformation.setFirstName(contactInfo.getFirstName());
        contactInformation.setLastName(contactInfo.getLastName());
        contactInformation.setEmail(contactInfo.getEmail());
        contactInformation.setPhoneNumber(contactInfo.getPhoneNumber());

        // Update the profileCreationStatus to reflect the screen update
        String updatedStatus = "ContactInformation_updated";
        profile.setProfileCreationStatus(updatedStatus);

        profileRepository.save(profile);

        return contactInfo;
    }

    @Override
    public EmploymentStatusDTO updateEmploymentStatus(Long profileId, EmploymentStatusDTO employmentStatus) {
        // Fetch the profile from the database
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);

        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoundException("Profile not found with ID: " + profileId);
        }

        Profile profile = optionalProfile.get();

        // Update the EmploymentStatus screen directly with the provided data
        EmploymentStatus employmentStatusObj = profile.getEmploymentStatus();
        employmentStatusObj.setPreviouslyEmployed(employmentStatus.isPreviouslyEmployed());
        employmentStatusObj.setEmploymentSituation(employmentStatus.getEmploymentSituation());
        employmentStatusObj.setIncome(employmentStatus.getIncome());
        employmentStatusObj.setJobType(employmentStatus.getJobType());

        // Update the profileCreationStatus to reflect the screen update
        String updatedStatus = "EmploymentStatus_updated";
        profile.setProfileCreationStatus(updatedStatus);

        profileRepository.save(profile);

        return employmentStatus;
    }

    @Override
    public GovernmentIDDTO updateGovernmentID(Long profileId, GovernmentIDDTO governmentIDDTO) {
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);

        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoundException("Profile not found with ID: " + profileId);
        }

        Profile profile = optionalProfile.get();

        // Update the GovernmentID screen
        profile.getGovernmentID().setDocumentType(governmentIDDTO.getDocumentType());
        profile.getGovernmentID().setDocumentNumber(governmentIDDTO.getDocumentNumber());
        profile.getGovernmentID().setDocumentUrl(governmentIDDTO.getDocumentUrl());

        // Update the profileCreationStatus to reflect the screen update
        String updatedStatus = "GovernmentID_updated";
        profile.setProfileCreationStatus(updatedStatus);

        profileRepository.save(profile);

        return governmentIDDTO;
    }

    @Override
    public IncomeStatusDTO updateIncomeStatus(Long profileId, IncomeStatusDTO incomeStatusDTO) {
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);

        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoundException("Profile not found with ID: " + profileId);
        }

        Profile profile = optionalProfile.get();

        // Update the IncomeStatus screen
        profile.getIncomeStatus().setEmploymentStatus(incomeStatusDTO.getEmploymentStatus());
        profile.getIncomeStatus().setMonthlyPersonalIncome(incomeStatusDTO.getMonthlyPersonalIncome());
        profile.getIncomeStatus().setHasOtherSourcesOfIncome(incomeStatusDTO.isHasOtherSourcesOfIncome());
        profile.getIncomeStatus().setExtraIncomeDescription(incomeStatusDTO.getExtraIncomeDescription());

        // Update the profileCreationStatus to reflect the screen update
        String updatedStatus = "IncomeStatus_updated";
        profile.setProfileCreationStatus(updatedStatus);

        profileRepository.save(profile);

        return incomeStatusDTO;
    }

    @Override
    public BankAccountDTO updateBankAccount(Long profileId, BankAccountDTO bankAccountDTO) {
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);

        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoundException("Profile not found with ID: " + profileId);
        }

        Profile profile = optionalProfile.get();

        // Update the BankAccount screen
        profile.getBankAccount().setBank(bankAccountDTO.getBank());
        profile.getBankAccount().setAccountNumber(bankAccountDTO.getAccountNumber());
        profile.getBankAccount().setAccountName(bankAccountDTO.getAccountName());

        // Update the profileCreationStatus to reflect the screen update
        String updatedStatus = "BankAccount_updated";
        profile.setProfileCreationStatus(updatedStatus);

        profileRepository.save(profile);

        return bankAccountDTO;
    }

    @Override
    public ProofOfAddressDTO updateProofOfAddress(Long profileId, ProofOfAddressDTO proofOfAddressDTO) {
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);

        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoundException("Profile not found with ID: " + profileId);
        }

        Profile profile = optionalProfile.get();

        // Update the ProofOfAddress screen
        profile.getProofOfAddress().setDocument_Url(proofOfAddressDTO.getDocument_Url());

        // Update the profileCreationStatus to reflect the screen update
        String updatedStatus = "ProofOfAddress_updated";
        profile.setProfileCreationStatus(updatedStatus);

        profileRepository.save(profile);

        return proofOfAddressDTO;
    }
}