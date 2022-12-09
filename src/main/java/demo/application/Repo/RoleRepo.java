/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package demo.application.Repo;

import demo.application.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author femitemiola
 */
public interface RoleRepo extends JpaRepository<Role, Long>{
    Role findByRoleName(String rolename);
    
}