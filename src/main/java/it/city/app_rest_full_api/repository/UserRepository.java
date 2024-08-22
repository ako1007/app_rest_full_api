package it.city.app_rest_full_api.repository;

import it.city.app_rest_full_api.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmailEqualsIgnoreCaseOrUsernameEqualsIgnoreCaseOrPhoneNumberEquals(String email, String username, String phoneNumber);


}
