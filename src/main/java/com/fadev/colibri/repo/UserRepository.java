package com.fadev.colibri.repo;

import com.fadev.colibri.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
