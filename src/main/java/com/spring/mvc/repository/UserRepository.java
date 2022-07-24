package com.spring.mvc.repository;

import com.spring.mvc.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
//    UserEntity findUserByEmail(String email);
}
