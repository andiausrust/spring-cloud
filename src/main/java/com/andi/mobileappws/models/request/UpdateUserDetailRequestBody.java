package com.andi.mobileappws.models.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateUserDetailRequestBody {

    @NotNull(message = "first name must not be null")
    @Size(min = 2, message = "min size of first name must be at least 2")
    private String firstName;

    @NotNull(message = "last name must not be null")
    @Size(min = 2, message = "min size of last name must be at least 2")
    private String lastName;
}
