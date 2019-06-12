package com.andi.mobileappws.userservice.impl;

import com.andi.mobileappws.models.request.UserDetailsRequestModel;
import com.andi.mobileappws.models.response.UserRest;
import com.andi.mobileappws.shared.Utils;
import com.andi.mobileappws.userservice.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;

    Utils utils;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest(userDetails.getFirstName(), userDetails.getLastName(),
                userDetails.getEmail(), "");

        if(users == null) users = new HashMap<>();

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);
        users.put(userId, returnValue);

        return returnValue;
    }
}
