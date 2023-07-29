package com.decagon.service.serviceImplementation;

import com.decagon.config.CloudinaryConfig;
import com.decagon.domain.constant.ProfileStatus;
import com.decagon.domain.entity.Profile;
import com.decagon.domain.screen.*;
import com.decagon.dto.pojoDTO.*;
import com.decagon.dto.response.ProfileResponseDTO;
import com.decagon.exception.InvalidTokenException;
import com.decagon.exception.ProfileNotFoundException;
import com.decagon.repository.ProfileRepository;
import com.decagon.service.ProfileService;
import com.decagon.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final JwtUtils jwtUtils;

    @Override
    public ProfileResponseDTO createProfile(String user_id, ContactInformationDTO contactInformationDTO) {
        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setFirstName(contactInformationDTO.getFirstName());
        contactInformation.setLastName(contactInformationDTO.getLastName());
        contactInformation.setEmail(contactInformationDTO.getEmail());

        Profile profile = new Profile();
        profile.setUserId(user_id);
        profile.setStatus(ProfileStatus.NEW);
        profile.setContactInformation(contactInformation);

        profileRepository.save(profile);
        ProfileResponseDTO responseDTO = new ProfileResponseDTO(profile);

        return responseDTO;
    }

    @Override
    public ProfileResponseDTO updateContactInformation(ContactInformationDTO contactInformationDTO, String authorizationHeader) {
        String userId = getUserID(authorizationHeader);
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        ContactInformation contactInformation = new ContactInformation(contactInformationDTO);
        profile.setContactInformation(contactInformation);
        profile.setStatus(ProfileStatus.CONTACT_UPDATED);
        profileRepository.save(profile);
        return new ProfileResponseDTO(profile);
    }

    @Override
    public ProfileResponseDTO updateEmploymentStatus(EmploymentStatusDTO employmentStatusDTO, String authorizationHeader) {
        String userId = getUserID(authorizationHeader);

        // Fetch the profile from the database using the provided userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        // Convert EmploymentStatusDTO to EmploymentStatus
        EmploymentStatus employmentStatus = new EmploymentStatus(employmentStatusDTO);

        // Update the profile with the new EmploymentStatus
        profile.setEmploymentStatus(employmentStatus);

        // Save the updated profile in the database
        profileRepository.save(profile);

        // Prepare the response DTO

        return new ProfileResponseDTO(profile);
    }

    @Override
    public ProfileResponseDTO updateGovernmentID(GovernmentIDDTO governmentIDDTO, MultipartFile file, String authorizationHeader) {
        String userId = getUserID(authorizationHeader);

        // Fetch the profile from the database using the provided userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        String url = uploadFile(file, profile.getId());
        // Update the GovernmentID screen
        GovernmentID governmentID = new GovernmentID(governmentIDDTO);

        // Update the profileCreationStatus to reflect the screen update
        profile.setGovernmentId(governmentID);
        profile.setStatus(ProfileStatus.GOVERNMENT_UPDATED);
        profileRepository.save(profile);
        return new ProfileResponseDTO(profile);
    }

    @Override
    public ProfileResponseDTO updateIncomeStatus(IncomeStatusDTO incomeStatusDTO, String authorizationHeader) {
        String userId = getUserID(authorizationHeader);

        // Fetch the profile from the database using the provided userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        // Update the IncomeStatus screen
        IncomeStatus incomeStatus = new IncomeStatus(incomeStatusDTO);
        profile.setIncomeStatus(incomeStatus);
        // Update the profileCreationStatus to reflect the screen update
        profile.setStatus(ProfileStatus.INCOME_UPDATED);

        profileRepository.save(profile);

        return new ProfileResponseDTO(profile);
    }

    @Override
    public ProfileResponseDTO updateBankAccount(BankAccountDTO bankAccountDTO, String authorizationHeader) {
        String userId = getUserID(authorizationHeader);

        // Fetch the profile from the database using the provided userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        // Update the BankAccount screen
        BankAccount bankAccount = new BankAccount(bankAccountDTO);
        profile.setBankAccount(bankAccount);
        // Update the profileCreationStatus to reflect the screen update
        profile.setStatus(ProfileStatus.BANK_ACCOUNT_UPDATED);

        profileRepository.save(profile);

        return new ProfileResponseDTO(profile);
    }

    @Override
    public ProfileResponseDTO updateProofOfAddress(ProofOfAddressDTO proofOfAddressDTO, MultipartFile file, String authorizationHeader) {
        String userId = getUserID(authorizationHeader);

        // Fetch the profile from the database using the provided userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found for user ID: " + userId));

        String url = uploadFile(file, profile.getId());
        ProofOfAddress proofOfAddress = new ProofOfAddress(proofOfAddressDTO);
        profile.setProofOfAddress(proofOfAddress);
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

    private String getUserID(String authorizationHeader) {
        String token = jwtUtils.extractToken(authorizationHeader);
        String userId = jwtUtils.extractUserIdFromToken(token);

        if (userId == null) {
            throw new InvalidTokenException("UserId is null");
        }
        return userId;
    }
}