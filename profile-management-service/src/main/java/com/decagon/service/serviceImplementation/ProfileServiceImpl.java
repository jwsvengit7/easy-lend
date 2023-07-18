package com.decagon.service.serviceImplementation;

import com.decagon.dto.request.ProfileRequest;
import com.decagon.dto.response.ProfileResponse;
import com.decagon.repository.ProfileRepository;
import com.decagon.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
        return null;
    }

    @Override
    public ProfileResponse updateProfile(Long id, ProfileRequest profileRequest) {
        return null;
    }
}