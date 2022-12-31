/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.application.service;

import demo.application.Repo.RoleRepo;
import demo.application.Repo.UserRepo;
import demo.application.domain.Role;
import demo.application.domain.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author femitemiola
 */

@Service @RequiredArgsConstructor @Transactional @Slf4j 
//@RequiredArgsConstructor : This allows us to inject them into the class, 
// Lumbar creates a constructor and makes sure all the variables/fields are passed
// @Slf4j - for logging purposes
public class UserServiceImpl implements UserService{
    
    private final RoleRepo roleRepo = null ;
    private final UserRepo userRepo = null ;

    @Override
    public User saveUser(User user) {    
        log.info("saving users{} into the database", user.getName());
        return userRepo.save(user);
   
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role {} to the database", role.getName());
        return roleRepo.save(role);     
    }

    @Override
    public void addRoleToUser(String username, String roleName) { 
        log.info("Adding role to user {} to a new role {} to the database", roleName, username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByRoleName(roleName);
        user.getRoles().add(role);   
    }

    @Override
    public User getUser(String username) {
        log.info("fetching username{} from database", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("fetching all users");
        return userRepo.findAll();
    }
    
}
