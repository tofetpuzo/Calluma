/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.application.demo.controller;

import demo.application.domain.Role;
import demo.application.domain.User;
import demo.application.service.UserService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author 44730
 */

@RestController
@RequestMapping(value="/api", method=RequestMethod.GET)
@RequiredArgsConstructor
public class UserResourceController {
    private final UserService userService;
    
//    This gets the list of the users from the database
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        
        return ResponseEntity.ok().body(userService.getUsers());
    }
    
    @GetMapping("/users/save")
    public ResponseEntity<User> saveUsers(@RequestBody User users){
//        fromCurrentContextPath() gets the path of the local host 8088
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(users));
    }
    
    @GetMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role roles){
        return ResponseEntity.ok().body(userService.saveRole(roles));
    }
    
}
