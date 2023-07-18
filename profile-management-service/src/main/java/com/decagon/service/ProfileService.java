package com.decagon.service;

import com.decagon.dto.ContactInformationDTO;
import com.decagon.dto.request.ProfileRequest;
import com.decagon.dto.response.ProfileResponse;

public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest request);

    ProfileResponse updateProfile(Long id, ProfileRequest profileRequest);

    ContactInformationDTO updateContactInfo(Long id, ContactInformationDTO contactInformationDTO);


}