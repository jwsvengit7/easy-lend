package com.decagon.service.serviceImplementation;

import com.decagon.config.CloudinaryConfig;
import com.decagon.domain.entity.Profile;
import com.decagon.domain.pojo.*;
import com.decagon.dto.pojoDTO.*;
import com.decagon.dto.response.ProfileResponseDTO;
import com.decagon.exception.ProfileNotFoundException;
import com.decagon.repository.ProfileRepository;
import com.decagon.service.ProfileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;


    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ProfileResponseDTO createProfile(String user_id, ContactInformationDTO contactInformationDTO) {
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
    public ProfileResponseDTO updateContactInformation(ContactInformationDTO contactInfo, String userId) {
        // Fetch the profile from the database using the provided userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        // Update the ContactInformation screen directly with the provided data
        ContactInformation contactInformation = profile.getContactInformation();
        contactInformation.setFirstName(contactInfo.getFirstName());
        contactInformation.setLastName(contactInfo.getLastName());
        contactInformation.setEmail(contactInfo.getEmail());
        contactInformation.setPhoneNumber(contactInfo.getPhoneNumber());

        profile.setContactInformation(contactInformation);
        // Update the profileCreationStatus to reflect the screen update
        profile.setStatus(ProfileStatus.CONTACT_UPDATED);

        profileRepository.save(profile);

        return new ProfileResponseDTO(profile);
    }

    @Override
    public ProfileResponseDTO updateEmploymentStatus(EmploymentStatusDTO employmentStatus, String userId) {
        // Fetch the profile from the database using the provided userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        // Update the EmploymentStatus screen directly with the provided data
        EmploymentStatus employmentStatusObj = profile.getEmploymentStatus();
        employmentStatusObj.setPreviouslyEmployed(employmentStatus.isPreviouslyEmployed());
        employmentStatusObj.setEmploymentSituation(employmentStatus.getEmploymentSituation());
        employmentStatusObj.setIncome(employmentStatus.getIncome());
        employmentStatusObj.setJobType(employmentStatus.getJobType());

        profile.setEmploymentStatus(employmentStatusObj);

        profile.setStatus(ProfileStatus.EMPLOYMENT_UPDATED);

        profileRepository.save(profile);

        return new ProfileResponseDTO(profile);
    }

    @Override
    public ProfileResponseDTO updateGovernmentID(GovernmentIDDTO governmentIDDTO, MultipartFile file, String userId) {
        // Fetch the profile from the database using the provided userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        String url = uploadFile(file, profile.getId());
        // Update the GovernmentID screen
        GovernmentID governmentID = new GovernmentID();
        governmentID.setDocumentType(governmentIDDTO.getDocumentType());
        governmentID.setDocumentNumber(governmentIDDTO.getDocumentNumber());
        profile.setGovernmentId(governmentID);
        // Update the profileCreationStatus to reflect the screen update
        profile.setStatus(ProfileStatus.GOVERNMENT_UPDATED);
        profileRepository.save(profile);
        return new ProfileResponseDTO(profile);
    }

    @Override
    public ProfileResponseDTO updateIncomeStatus(IncomeStatusDTO incomeStatusDTO, String userId) {
        // Fetch the profile from the database using the provided userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        // Update the IncomeStatus screen
        IncomeStatus incomeStatus = new IncomeStatus();
        incomeStatus.setEmploymentStatus(incomeStatusDTO.getEmploymentStatus());
        incomeStatus.setMonthlyPersonalIncome(incomeStatusDTO.getMonthlyPersonalIncome());
        incomeStatus.setHasOtherSourcesOfIncome(incomeStatusDTO.isHasOtherSourcesOfIncome());
        incomeStatus.setExtraIncomeDescription(incomeStatusDTO.getExtraIncomeDescription());
        profile.setIncomeStatus(incomeStatus);
        // Update the profileCreationStatus to reflect the screen update
        profile.setStatus(ProfileStatus.INCOME_UPDATED);

        profileRepository.save(profile);

        return new ProfileResponseDTO(profile);
    }

    @Override
    public ProfileResponseDTO updateBankAccount(BankAccountDTO bankAccountDTO, String userId) {
        // Fetch the profile from the database using the provided userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        // Update the BankAccount screen
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBank(bankAccountDTO.getBank());
        bankAccount.setAccountNumber(bankAccountDTO.getAccountNumber());
        bankAccount.setAccountName(bankAccountDTO.getAccountName());
        profile.setBankAccount(bankAccount);
        // Update the profileCreationStatus to reflect the screen update
        profile.setStatus(ProfileStatus.BANK_ACCOUNT_UPDATED);

        profileRepository.save(profile);

        return new ProfileResponseDTO(profile);
    }

    @Override
    public ProfileResponseDTO updateProofOfAddress(ProofOfAddressDTO proofOfAddressDTO, MultipartFile file, String userId) {
        // Fetch the profile from the database using the provided userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        String url = uploadFile(file, profile.getId());

        // Update the profileCreationStatus to reflect the screen update
        profile.setStatus(ProfileStatus.PROOF_OF_ADDRESS);

        profileRepository.save(profile);

        return new ProfileResponseDTO(profile);
    }

    private String uploadFile(MultipartFile file, Long id) {
        CloudinaryConfig cloudinaryConfig = new CloudinaryConfig();
        String generator = UUID.randomUUID().toString() + id;
        return cloudinaryConfig.imageLink(file, generator);
    }
}