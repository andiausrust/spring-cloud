package com.andi.mobileappws.controller;

import com.andi.mobileappws.exceptions.UserServiceException;
import com.andi.mobileappws.models.request.UpdateUserDetailRequestBody;
import com.andi.mobileappws.models.request.UserDetailsRequestModel;
import com.andi.mobileappws.models.response.UserRest;
import com.andi.mobileappws.userservice.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    Map<String, UserRest> users;

    UserService userService;

    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "15") int limit,
                           @RequestParam(value = "sort", required = false) String sort) {

        return "get user was called with userID with page: " + page + "limit " + limit + "sort " + sort;
    }


    @GetMapping(path = "/{userId}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        if(true) throw new UserServiceException("a user service Exception is thrown");

        if(users.containsKey(userId)){
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping(consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
                },
                produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
                })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel requestModel) {

        UserRest returnValue = userService.createUser(requestModel);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }


    @PutMapping(path = "/{userId}",
                    consumes = {
                        MediaType.APPLICATION_JSON_VALUE,
                        MediaType.APPLICATION_XML_VALUE
                },  produces = { MediaType.APPLICATION_XML_VALUE,
                        MediaType.APPLICATION_JSON_VALUE
                })
    public ResponseEntity<UserRest> updateUser(@PathVariable String userId,
                                               @RequestBody @Valid UpdateUserDetailRequestBody updateUser) {

        if(users.containsKey(userId)){
            users.get(userId).setFirstName(updateUser.getFirstName());
            users.get(userId).setLastName(updateUser.getLastName());
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @DeleteMapping(path = "/{userId")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        if (users.containsKey(userId)) {
            users.remove(userId);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
