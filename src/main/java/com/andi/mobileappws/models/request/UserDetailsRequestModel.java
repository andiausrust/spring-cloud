package com.andi.mobileappws.models.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDetailsRequestModel {

    @NotNull(message = "first name cannot be empty")
    @Size(min = 2, message = "size must be more than 2")
    private String firstName;

    @NotNull(message = "last name cannot be empty")
    private String lastName;

    @NotNull(message = "email name cannot be empty")
    @Email
    private String email;

    @NotNull(message = "password cannot be empty")
    @Size(min = 8, max = 16, message = "password must be between 8 and 16")
    private String password;

}
