package com.finance.simjam.repositories;

import com.finance.simjam.models.PrimaryKey;
import com.finance.simjam.models.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface UserRepository extends CrudRepository<User, PrimaryKey> {
    User findById(String id);
    List<User> findAllByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    User findAllByIdAndUsername(String id, String username);
    List<User> findAll();
}