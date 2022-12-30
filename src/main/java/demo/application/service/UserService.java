/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package demo.application.service;

import demo.application.domain.Role;
import demo.application.domain.Users;
import java.util.List;

/**
 *
 * @author femitemiola
 */
public interface UserService {
    Users saveUser(Users user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    Users getUser(String username);
    List<Users> getUsers();
    
   public static void main(String[] args) {
       String name[] = {"Jack", "Bob", "Mary"};
       System.out.println(name.length);
    }
   }
