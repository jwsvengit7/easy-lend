package com.easyLend.userservice.services.serviceImpl;

import com.easyLend.userservice.domain.constant.UserType;
import com.easyLend.userservice.domain.entity.AppUser;
import com.easyLend.userservice.domain.repository.AppUserRepository;
import com.easyLend.userservice.event.RegisterEvent;
import com.easyLend.userservice.exceptions.UserAlreadyExistExceptions;
import com.easyLend.userservice.request.RegisterRequest;
import com.easyLend.userservice.response.RegisterResponse;
import com.easyLend.userservice.services.AppUserService;
import com.easyLend.userservice.utils.EmailUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final ApplicationEventPublisher publisher;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    private AppUser confirmUserExists(String email){
        return appUserRepository.findAppUserByEmail(email).orElseThrow(()-> new UserAlreadyExistExceptions("USER NOT FOUND"));
    }
    private void confirmUser(String email){
        Boolean appUser = appUserRepository.existsAppUserByEmail(email);
        if (appUser){
            throw new UserAlreadyExistExceptions("USER ALREADY EXIST");
        }
    }
    @Override
    public RegisterResponse registerUser(RegisterRequest request, UserType userType, HttpServletRequest httpServletRequest) {
             confirmUser(request.getEmail());
            AppUser appUser = appUserRepository.save(saveUserDTO(request));
            publisher.publishEvent(new RegisterEvent(appUser, EmailUtils.applicationUrl(httpServletRequest)));
            return modelMapper.map(appUser,RegisterResponse.class);


    }
    private AppUser saveUserDTO(RegisterRequest request){
        return AppUser.builder()
                .userType(request.getUserType())
                .fullName(request.getFullName())
                .email(request.getEmail())
                .createdAt(LocalDateTime.now())
                .registrationStatus(false)
                .image("")
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }


}
