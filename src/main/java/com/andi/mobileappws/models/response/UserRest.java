package com.andi.mobileappws.models.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRest {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;

}
