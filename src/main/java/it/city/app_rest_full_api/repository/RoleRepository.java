package it.city.app_rest_full_api.repository;

import it.city.app_rest_full_api.entity.Role;
import it.city.app_rest_full_api.entity.enums.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(RoleName roleName);


}
