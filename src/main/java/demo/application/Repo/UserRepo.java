/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package demo.application.Repo;

import demo.application.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author femitemiola
 */
public interface UserRepo extends JpaRepository<Users, Long>{
    Users findByUsername(String username);
    
}
