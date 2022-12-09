/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.application.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.AUTO;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author femitemiola
 */
@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Role {
    @Id 
    @GeneratedValue(strategy=AUTO)
    private Long id;
    
    private String name;
}
