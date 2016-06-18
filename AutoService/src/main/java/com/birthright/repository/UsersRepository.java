package com.birthright.repository;

import com.birthright.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Birthright on 28.04.2016.
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findByEmail(String email);

}
