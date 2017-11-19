package com.example.java.gettingstarted;

import org.springframework.data.repository.CrudRepository;

/**
 * Simple User Crud Repository.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
