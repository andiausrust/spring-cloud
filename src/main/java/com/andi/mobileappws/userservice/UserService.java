package com.andi.mobileappws.userservice;

import com.andi.mobileappws.models.request.UserDetailsRequestModel;
import com.andi.mobileappws.models.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel userDetails);
}
