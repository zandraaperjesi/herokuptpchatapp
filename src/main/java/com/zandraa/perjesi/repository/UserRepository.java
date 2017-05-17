package com.zandraa.perjesi.repository;

import com.zandraa.perjesi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
}
