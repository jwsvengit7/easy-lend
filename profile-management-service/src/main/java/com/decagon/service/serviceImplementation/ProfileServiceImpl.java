package com.decagon.service.serviceImplementation;

import com.decagon.domain.entity.Profile;
import com.decagon.domain.pojo.ContactInformation;
import com.decagon.domain.pojo.EmploymentStatus;
import com.decagon.domain.pojo.ProfileStatus;
import com.decagon.dto.pojoDTO.BankAccountDTO;
import com.decagon.dto.pojoDTO.ContactInformationDTO;
import com.decagon.dto.pojoDTO.EmploymentStatusDTO;
import com.decagon.dto.pojoDTO.GovernmentIDDTO;
import com.decagon.dto.pojoDTO.IncomeStatusDTO;
import com.decagon.dto.pojoDTO.ProofOfAddressDTO;
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
        profile.setUserId(user_id);
        profile.setStatus(ProfileStatus.NEW);
        profile.setContactInformation(contactInformation);

        profileRepository.save(profile);
        // Prepare the response DTO
        ProfileResponseDTO responseDTO = new ProfileResponseDTO(profile);

        return responseDTO;
    }

    @Override
    public ProfileResponseDTO updateContactInformation(Long profileId, ContactInformationDTO contactInfo) {
        // Fetch the profile from the database
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ProfileNotFoundException("Profile not found with ID: " + profileId));

        // Update the ContactInformation screen directly with the provided data
        ContactInformation contactInformation = profile.getContactInformation();
        contactInformation.setFirstName(contactInfo.getFirstName());
        contactInformation.setLastName(contactInfo.getLastName());
        contactInformation.setEmail(contactInfo.getEmail());
        contactInformation.setPhoneNumber(contactInfo.getPhoneNumber());

        profile.setContactInformation(contactInformation);
        // Update the profileCreationStatus to reflect the screen update
        profile.setStatus(ProfileStatus.INCOME_UPDATED);

        profileRepository.save(profile);

        return new ProfileResponseDTO(profile);
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

        // Update the profileCreationStatus to reflect the screen updateprofile.setStatus(ProfileStatus.EMPLOYMENT_UPDATED);

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
        profile.getGovernmentId().setDocumentType(governmentIDDTO.getDocumentType());
        profile.getGovernmentId().setDocumentNumber(governmentIDDTO.getDocumentNumber());
        profile.getGovernmentId().setDocumentUrl(governmentIDDTO.getDocumentUrl());

        // Update the profileCreationStatus to reflect the screen update
        profile.setStatus(ProfileStatus.GOVERNMENT_UPDATED);

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
        profile.setStatus(ProfileStatus.INCOME_UPDATED);

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
        profile.setStatus(ProfileStatus.BANK_ACCOUNT_UPDATED);

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
        profile.setStatus(ProfileStatus.PROOF_OF_ADDRESS);

        profileRepository.save(profile);

        return proofOfAddressDTO;
    }
}