package com.easyLend.userservice.event;

import com.easyLend.userservice.domain.entity.AppUser;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class RegisterEventListener implements ApplicationListener<RegisterEvent> {
    @Override
    public void onApplicationEvent(RegisterEvent event) {
       AppUser appUser =  event.getAppUser();
       String url =event.getUrl();
        sendEmail(appUser,url);


    }
    private String sendEmail(AppUser appUser,String url){

        return  appUser.getEmail();
    }
}
