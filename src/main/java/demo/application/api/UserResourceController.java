/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.application.api;

import demo.application.domain.Users;
import demo.application.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 44730
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResourceController {
    private final UserService userService;
    
    public ResponseEntity<List<Users>> getUsers(){
        return ResponseEntity.ok().body(this.userService.getUsers());
    }
    
}
