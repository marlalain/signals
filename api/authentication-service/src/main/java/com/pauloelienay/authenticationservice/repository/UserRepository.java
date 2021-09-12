package com.pauloelienay.authenticationservice.repository;

import com.pauloelienay.authenticationservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
