package it.city.app_rest_full_api.service;

import it.city.app_rest_full_api.entity.User;
import it.city.app_rest_full_api.entity.enums.RoleName;
import it.city.app_rest_full_api.payload.ReqRegister;
import it.city.app_rest_full_api.payload.Result;
import it.city.app_rest_full_api.repository.RoleRepository;
import it.city.app_rest_full_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public Result register(ReqRegister reqRegister){
        boolean exists = userRepository.existsByEmailEqualsIgnoreCaseOrUsernameEqualsIgnoreCaseOrPhoneNumberEquals(reqRegister.getEmail(), reqRegister.getUsername(), reqRegister.getPhoneNumber());
        if (!exists){
                User user=new User();
                user.setFirstName(reqRegister.getFirstName());
                user.setLastName(reqRegister.getLastName());
                user.setUsername(reqRegister.getUsername());
                user.setEmail(reqRegister.getEmail());
                user.setPhoneNumber(reqRegister.getPhoneNumber());
                user.setGender(reqRegister.getGender());
                user.setPassword(reqRegister.getPassword());
                user.setRoles(Collections.singleton(roleRepository.findByRoleName(RoleName.ROLE_CLIENT  )));
                user.setActivationCode(saveContact.getId().toString());
                userRepository.save(user);
                SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
                simpleMailMessage.setTo(user.getEmail());
                simpleMailMessage.setSubject("Verify your new account");
                simpleMailMessage.setText("Verify check email. Click to link: \n"+"http://localhost/auth/activationCode/"+user.getActivationCode());
                javaMailSender.send(simpleMailMessage);
                return new Result("Register", true);

}}
