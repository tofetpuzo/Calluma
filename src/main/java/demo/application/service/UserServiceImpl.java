/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.application.service;

import demo.application.Repo.RoleRepo;
import demo.application.Repo.UserRepo;
import demo.application.domain.Role;
import demo.application.domain.Users;
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
    public Users saveUser(Users user) {    
        return userRepo.save(user);
   
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
        
    }

    @Override
    public void addRoleToUser(String username, String roleName) { 
        Users user = userRepo.findByUsername(username);
        Role role = roleRepo.findByRoleName(roleName);
        user.getRoles().add(role);
        
    }

    @Override
    public Users getUser(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Users> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
