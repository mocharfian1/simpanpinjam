package com.finance.simjam.services;

import com.finance.simjam.models.ApiResponse;
import com.finance.simjam.models.LoginModel;
import com.finance.simjam.models.User;
import com.finance.simjam.models.UserUpdate;
import com.finance.simjam.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserRepository userRepository;

    public User registerUser(User user){
        List<User> checkUser = userRepository.findAllByUsername(user.getUsername());
        if(checkUser.isEmpty()){
            return userRepository.save(user);
        }
        return null;
    }

    public ApiResponse<User> updateUser(User user){
        User checkUser = userRepository.findAllByIdAndUsername(user.getId(), user.getUsername());
        if(checkUser != null){
            User updateUser = userRepository.save(user);
            return new ApiResponse<>(200, "Berhasil update akun", updateUser);
        }
        return new ApiResponse<>(404, "Akun tidak ditemukan", null);
    }

    public ApiResponse<User> loginUser(LoginModel loginModel){
        User checkUser = userRepository.findByUsernameAndPassword(loginModel.getUsername(), loginModel.getPassword());

        if(checkUser != null && checkUser.getId() != null){
            return new ApiResponse<>(200, "Success", checkUser);
        }
        return new ApiResponse<>(404, "Akun tidak ditemukan", null);
    }

    public ApiResponse<List<User>> getListAllUser() {
        List<User> allUser = userRepository.findAll();
        if(!allUser.isEmpty()){
            return new ApiResponse<>(200, "Success", allUser);
        }
        return new ApiResponse<>(404, "Akun tidak ditemukan", null);
    }

    public ApiResponse<User> getListUserBy(String id) {
        User user = userRepository.findById(id);
        if(user != null){
            return new ApiResponse<>(200, "Success", user);
        }
        return new ApiResponse<>(404, "Akun tidak ditemukan", null);
    }
}
