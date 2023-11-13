package com.finance.simjam.controllers;

import com.finance.simjam.models.ApiResponse;
import com.finance.simjam.models.LoginModel;
import com.finance.simjam.models.User;
import com.finance.simjam.services.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static com.finance.simjam.helper.Constants.DUPLICATE_USERNAME;
import static com.finance.simjam.helper.Constants.HTTP_500;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<User>>> getAllUser() {
        ApiResponse<List<User>> getListAll = userService.getListAllUser();
        return ResponseEntity.ok(getListAll);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable(value = "id") String id) {
        ApiResponse<User> getListAll = userService.getListUserBy(id);
        return ResponseEntity.ok(getListAll);
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<User>> addUser(@Valid @RequestBody User user, Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(new ApiResponse<>(400, errors.getFieldError().getDefaultMessage(), null));
        }

        User submitUser = userService.registerUser(user);
        if (submitUser == null) {
            return ResponseEntity.ok(new ApiResponse<>(400, DUPLICATE_USERNAME, null));
        }
        return ResponseEntity.badRequest().body(new ApiResponse<>(200, "Success", submitUser));
    }

    @CrossOrigin(exposedHeaders = {"Content-Disposition"})
    @PostMapping(value = "/login")
    public ResponseEntity<ApiResponse<User>> login(@Valid @RequestBody LoginModel login, Errors errors) {
        try {
            if(errors.hasErrors()){
                return ResponseEntity.badRequest().body(new ApiResponse<>(400, Objects.requireNonNull(errors.getFieldError()).getDefaultMessage(), null));
            }
            ApiResponse<User> submitUser = userService.loginUser(login);
            return ResponseEntity.status(submitUser.getErrorCode()).body(submitUser);
        }catch (Exception e){
            logger.error("{} # UserController: 53 # Error : {}", HTTP_500, e.getMessage());
            return ResponseEntity.ok(new ApiResponse<>(500, HTTP_500, null));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<User>> updateUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.updateUser(user));
        } catch (Exception e){
            logger.error("{} # UserController: 66 # Error : {}", HTTP_500, e.getMessage());
            return ResponseEntity.ok(new ApiResponse<>(500, HTTP_500, null));
        }
    }
}
