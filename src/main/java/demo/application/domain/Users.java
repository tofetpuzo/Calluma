/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.application.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.AUTO;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author femitemiola
 */


// @Data -> this helps in setter and getter
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Users {
    
    @Id 
    @GeneratedValue(strategy=AUTO)
    private Long id;
    
    private String name;
    private String username;
    
//    map this class to as a tabel to a database
//    the eager is used because at no point will 
//    i want to load the user without loading the user
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
